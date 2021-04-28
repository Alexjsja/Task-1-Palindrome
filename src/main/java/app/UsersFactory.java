package app;

public class UsersFactory {

    private static int lastId = 0;

    public static User newUser(String username){
        String id = String.valueOf(++lastId);
        return new User(username, id);
    }

}
