package ng.ourChemo.utils;

import ng.ourChemo.data.models.User;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.responses.RegisterUserResponse;

public class Mapper {

    public static User mapToUser(RegisterUserRequest request) {
        if (request == null) {
            return null;
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public static RegisterUserResponse mapToRegisterUserResponse(User user) {
        if (user == null) {
            return null;
        }
        RegisterUserResponse response = new RegisterUserResponse();
        response.setId(user.getId());
        response.setMessage("Registration Done Successfully");
        return response;
    }
}
