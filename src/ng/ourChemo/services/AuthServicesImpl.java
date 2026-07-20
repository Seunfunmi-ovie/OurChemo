package ng.ourChemo.services;

import ng.ourChemo.data.models.User;
import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;
import ng.ourChemo.dtos.responses.RegisterUserResponse;
import ng.ourChemo.dtos.responses.UserLoginResponse;
import ng.ourChemo.utils.Mapper;

public class AuthServicesImpl implements AuthServices {

    private final UserRepository userRepository;

    public AuthServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = Mapper.mapToUser(request);
        User savedUser = userRepository.save(user);
        return Mapper.mapToRegisterUserResponse(savedUser);
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        return null;
    }
}
