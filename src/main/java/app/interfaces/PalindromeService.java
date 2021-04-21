package app.interfaces;

import app.User;

import java.util.Map;

public interface PalindromeService {

    Map<User,Integer> getLeaderboard();

    Map<User,Integer> getLeaderboard(int usersLimit);

    boolean savePalindrome(String str,User user);

}
