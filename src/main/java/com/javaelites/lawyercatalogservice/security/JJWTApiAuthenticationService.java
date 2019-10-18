
/**
 *
 */
package com.javaelites.lawyercatalogservice.security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@ComponentScan
public class JJWTApiAuthenticationService implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JJWTApiAuthenticationService.class);

    @Autowired
    private TokenHandler tokenHandler;

    private static final String X_AUTH_TOKEN = "X-AUTH-TOKEN";
    private static final String API_KEY = "api_key";
    private static final String JWT_AUTHENTICATION = "jwtAuthentication";

    @Autowired
    private RestUserDetailsService restUserDetailsService;

   
    /**
     * @param request
     * @return
     */
    public Authentication authenticate(HttpServletRequest request) {
        String a2aAccessToken = request.getHeader(X_AUTH_TOKEN);
        String apiKeyToken = request.getParameter(API_KEY);
        String sysUser = "SysUser";
        UserAuthentication userAuthentication = null;

        if (!StringUtils.isEmpty(apiKeyToken) && StringUtils.isEmpty(a2aAccessToken)) {
            a2aAccessToken = apiKeyToken;
        }
        //App to App Authentication
        try {
            tokenHandler.parseUserFromToken(a2aAccessToken);
            userAuthentication = new UserAuthentication(restUserDetailsService.loadUserByUsername(sysUser, JWT_AUTHENTICATION));
        } catch (RuntimeException e) {
            LOGGER.error("Inside" + this.getClass() + "Unauthorized " + e);
        }

        return userAuthentication;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

}
