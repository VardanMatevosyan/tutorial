package com.practice.facade.imp;


import com.practice.facade.SecurityJwksVerifier;

public class SecurityJwksVerifierImpl implements SecurityJwksVerifier {

    @Override
    public boolean verify(String token) {
        System.out.println("Verifying token jwks");
        return true;
    }
}
