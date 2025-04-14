package com.practice.facade.imp;


import com.practice.facade.AuthenticatorFactory;
import com.practice.facade.model.Authentication;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AuthenticatorFactoryImpl implements AuthenticatorFactory {

    private static final String EMAIL_CLAIM = "email";
    private static final String USERNAME_CLAIM = "username";
    private static final String AUTHORITIES_CLAIM = "user:group";

    @Override
    public Authentication build(Map<String, String> claims) {
        return Authentication.builder()
                .email(extractEmail(claims))
                .username(extractUsername(claims))
                .authorities(extractAuthorities(claims))
                .build();
    }

    private Collection<String> extractAuthorities(Map<String, String> claims) {
        String[] groups = claims.get(AUTHORITIES_CLAIM).split(",");
        return Set.of(groups);
    }

    private String extractUsername(Map<String, String> claims) {
        return claims.get(USERNAME_CLAIM);
    }

    private String extractEmail(Map<String, String> claims) {
        return claims.get(EMAIL_CLAIM);
    }
}
