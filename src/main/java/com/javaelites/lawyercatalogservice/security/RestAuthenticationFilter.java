package com.javaelites.lawyercatalogservice.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.javaelites.lawyercatalogservice.util.Constants;

@Component
public class RestAuthenticationFilter extends GenericFilterBean {

    private static final Logger LOG = LoggerFactory.getLogger(RestAuthenticationFilter.class);

    @Autowired
    private JJWTApiAuthenticationService jjwtApiAuthenticationService;


    private static final String ACCESS_TOKEN = "access_token";
//    private static final String API_KEY = "api_key";
//    private static final String AUTHORIZATION_TOKEN = "X-Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String accessToken = httpRequest.getHeader(ACCESS_TOKEN);

        Authentication authentication = null;
        if (!StringUtils.isEmpty(accessToken)) { 
           //TODO implement OAUTH and API gateway implementation
        } else { 
        	// JWT validation
            authentication = jjwtApiAuthenticationService.authenticate(httpRequest);
        }

        LOG.debug("##### RestAuthenticationFilter CAMS Token Validation Changes END");

        if (authentication == null) {
            LOG.error(" RestAuthenticationFilter: " + " AuthenticationFailed ");
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.UNAUTHORIZED);
        } else {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
