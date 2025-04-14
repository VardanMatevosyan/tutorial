package com.practice.facade;

import java.util.Map;

public interface SecurityJwtService {

    Map<String, String> extractClaimSet(String token);

    boolean validateIssuer(String jwtIssuer);

}
