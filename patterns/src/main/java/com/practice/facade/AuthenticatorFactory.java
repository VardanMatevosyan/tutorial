package com.practice.facade;


import com.practice.facade.model.Authentication;

import java.util.Map;

public interface AuthenticatorFactory {
    Authentication build(Map<String, String> claims);
}
