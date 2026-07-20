package ng.ourChemo.services;

import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;

import ng.ourChemo.dtos.responses.RegisterUserResponse;
import ng.ourChemo.dtos.responses.UserLoginResponse;

public interface AuthServices {
    RegisterUserResponse register(RegisterUserRequest request);
        UserLoginResponse login(UserLoginRequest request);

}
