package com.practice.facade.imp;


import com.practice.facade.SecurityJwtService;

import java.util.HashMap;
import java.util.Map;

public class SecurityJwtServiceImpl implements SecurityJwtService {

    @Override
    public Map<String, String> extractClaimSet(String token) {
        System.out.println("Get clam set from token");
        Map<String, String> claims = new HashMap<>();
        claims.put("email", "user@gmail.com");
        claims.put("username", "VarUser");
        claims.put("user:group", "admin");
        return claims;
    }

    @Override
    public boolean validateIssuer(String jwtIssuer) {
        System.out.println("Validate jwt issuer");
        return true;
    }


}
