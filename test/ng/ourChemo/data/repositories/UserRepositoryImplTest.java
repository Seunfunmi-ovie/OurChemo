package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    @Test
    void testSaveUser_IncreasesCountAndSavesUser() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setId(1);
        user.setUsername("user1");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        assertEquals(1, userRepository.count());
    }

    @Test
    void testFindById_ReturnsCorrectUser() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user1");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");

        userRepository.save(user1);
        userRepository.save(user2);

        User foundUser = userRepository.findById(2);
        assertNotNull(foundUser);
        assertEquals(2, foundUser.getId());
        assertEquals("user2", foundUser.getUsername());
    }

    @Test
    void testFindById_ReturnsNullIfNotFound() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setId(1);
        userRepository.save(user);

        User foundUser = userRepository.findById(99);
        assertNull(foundUser);
    }

    @Test
    void testDeleteUser_DecreasesCountAndRemovesUser() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setId(1);
        userRepository.save(user);

        userRepository.delete(user);

        assertEquals(0, userRepository.count());
        assertNull(userRepository.findById(1));
    }

    @Test
    void testDeleteAll_ClearsRepositoryAndResetsCount() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);

        userRepository.save(user1);
        userRepository.save(user2);

        userRepository.deleteAll();

        assertEquals(0, userRepository.count());
        assertNull(userRepository.findById(1));
        assertNull(userRepository.findById(2));
    }
}
