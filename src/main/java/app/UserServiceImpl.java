package app;

import app.exceptions.NotFoundException;
import app.interfaces.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    // TODO: 4/21/21 mb map
    private final List<User> users = new ArrayList<>();

    public UserServiceImpl(){}

    @Override
    public User saveUser(String name) {
        User user = UsersFactory.newUser(name);
        users.add(user);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        return users.stream()
                .filter(user->user.getId().equals(userId))
                .findFirst()
                .orElseThrow(()->new NotFoundException("user not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public boolean containsUserById(String userId) {
        return users.stream()
                .anyMatch(usr -> usr.getId().equals(userId));
    }

    @Override
    public boolean containsUserByName(String userName) {
        return users.stream()
                .anyMatch(usr -> usr.getName().equals(userName));
    }
}
