package com.practice.facade;


import com.practice.facade.model.Authentication;

public interface SecurityAuthFacade {

    Authentication validate(String token);

}
