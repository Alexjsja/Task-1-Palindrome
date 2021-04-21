package app.interfaces;

import app.Pair;
import app.User;

import java.util.List;
import java.util.Map;

public interface PalindromeService {

    List<Pair<User,Integer>> getLeaderboard();

    List<Pair<User,Integer>> getLeaderboard(int usersLimit);

    boolean savePalindrome(String str,User user);

}
