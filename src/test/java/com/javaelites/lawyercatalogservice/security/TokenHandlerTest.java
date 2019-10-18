package com.javaelites.lawyercatalogservice.security;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.javaelites.lawyercatalogservice.util.Constants;


@RunWith(MockitoJUnitRunner.class)
public class TokenHandlerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testParseUserFromTokenSuccess() {
			TokenHandler tokenHandler = new TokenHandler();
			tokenHandler.parseUserFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKVXNlciJ9.4CSSpV1zZW5cKiQMEjHScJHKjRv5pggh-UEcyRBtOmuGFozRVuGxWfnOqXaW_2uX_n207O_YQfSMp9W-P3tGuQ");
	}

    @Test
    public void testParseStaticLawyersUserTokenSuccess() {
        TokenHandler tokenHandler = new TokenHandler();
        tokenHandler.parseUserFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKVXNlciJ9.Ai6lv3qSwo9RnVHKmbn2Ycdt4IO8Cif1m2xnKujJsjchFjKyQn_KHZ5qvhwwr3m9RWx8lJcLsL7Jt89VS-BiqA");
    }

	@Test(expected=RuntimeException.class)
	public void testParseUserFromTokenFailure() {
		TokenHandler tokenHandler = new TokenHandler();
		tokenHandler.parseUserFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKVXNlciJ9.4CSSpV1zZW5cKiQMEjHScJHKjRv5pggh-UEcyRBtOmuGFozRVuGxWfnOqXaW_2uX_n207O_YQfSMp9W-P3tGuQ_fail");
	}

	@Test(expected=RuntimeException.class)
	public void testParseUserFromTokenFailure1() {
		TokenHandler tokenHandler = new TokenHandler();
		tokenHandler.parseUserFromToken("failuretokentest");
	}

	@Test
	public void testCreateTokenForUser() {
		TokenHandler tokenHandler = new TokenHandler();
		User user = new User("JUser","JUser",new HashSet<GrantedAuthority>());
		String a2aPrivateSecret = Constants.A2A_PRIVATE_KEY;
		String lawyersSecret = Constants.LAWYERS_PRIVATE_KEY;
		String a2a_generated_token = tokenHandler.createTokenForUser(user, a2aPrivateSecret);
		String lawyers_generated_token = tokenHandler.createTokenForUser(user, lawyersSecret);
		String a2a_valid_token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKVXNlciJ9.4CSSpV1zZW5cKiQMEjHScJHKjRv5pggh-UEcyRBtOmuGFozRVuGxWfnOqXaW_2uX_n207O_YQfSMp9W-P3tGuQ";
        String lawyers_valid_token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKVXNlciJ9.Ai6lv3qSwo9RnVHKmbn2Ycdt4IO8Cif1m2xnKujJsjchFjKyQn_KHZ5qvhwwr3m9RWx8lJcLsL7Jt89VS-BiqA";
		assertEquals(a2a_generated_token, a2a_valid_token);
        assertEquals(lawyers_generated_token, lawyers_valid_token);
        System.out.println(a2a_generated_token);
        System.out.println(lawyers_generated_token);
	}

}
