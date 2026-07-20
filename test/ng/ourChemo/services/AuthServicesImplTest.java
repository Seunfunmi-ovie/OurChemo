package ng.ourChemo.services;

import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.data.repositories.UserRepositoryImpl;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;
import ng.ourChemo.dtos.responses.RegisterUserResponse;
import ng.ourChemo.dtos.responses.UserLoginResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AuthServicesImplTest {

    @Test
    void testRegisterUser() {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.deleteAll();
        AuthServices authServices = new AuthServicesImpl(userRepository);

        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("oluwaseunpu@gmail.com");
        request.setPassword("password123");

        RegisterUserResponse response = authServices.register(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Registration Done Successfully", response.getMessage());
        Assertions.assertEquals(1, userRepository.count());
    }

    @Test
    void testLoginUserReturnsNull() {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.deleteAll();
        AuthServices authServices = new AuthServicesImpl(userRepository);

        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("oluwaseunpu@gmail.com");
        request.setPassword("password123");

        UserLoginResponse response = authServices.login(request);

        Assertions.assertNull(response);
    }
}
