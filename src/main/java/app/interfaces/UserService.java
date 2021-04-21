package app.interfaces;

import app.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(String name);

    User getUserById(String id);

    List<User> getAllUsers();
}
