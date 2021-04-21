package app;

import app.interfaces.PalindromeContainer;
import app.interfaces.PalindromeHandler;
import app.interfaces.PalindromeService;
import app.interfaces.UserService;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class PalindromeServiceImpl implements PalindromeService {

    private final PalindromeHandler palindromeHandler;
    private final PalindromeContainer palindromeContainer;
    private final UserService userService;

    public PalindromeServiceImpl(PalindromeHandler palindromeHandler,
                                 PalindromeContainer palindromeContainer,
                                 UserService userService) {
        this.palindromeHandler = palindromeHandler;
        this.palindromeContainer = palindromeContainer;
        this.userService = userService;
    }

    @Override
    public Map<User, Integer> getLeaderboard() {
        return getLeaderboard(5);
    }

    @Override
    public Map<User, Integer> getLeaderboard(int usersLimit) {
        return userService.getAllUsers()
                .stream()
                .map(user-> {
                    Integer userScore = palindromeContainer
                            .getUserPalindromes(user.getId())
                            .stream()
                            .map(str -> str.replaceAll("\\s+", ""))
                            .map(String::length)
                            .reduce(Integer::sum)
                            .orElse(0);
                    return new Pair<>(user,userScore);
                })
                .sorted(Comparator.comparingInt(Pair::getRight))
                .limit(usersLimit)
                .collect(Collectors.toMap(Pair::getLeft,Pair::getRight));
    }

    @Override
    public boolean savePalindrome(String str, User user) {
        String userId = user.getId();
        boolean valid = userService.containsUser(userId)
                && palindromeHandler.isPalindrome(str)
                && !palindromeContainer.containsPalindrome(str, userId);
        if (valid){
            return palindromeContainer.savePalindrome(str,userId);
        }
        return false;
    }
}
