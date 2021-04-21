package app;

import app.interfaces.PalindromeContainer;
import app.interfaces.PalindromeHandler;
import app.interfaces.PalindromeService;
import app.interfaces.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public List<Pair<User,Integer>> getLeaderboard() {
        return getLeaderboard(5);
    }

    @Override
    public List<Pair<User,Integer>> getLeaderboard(int usersLimit) {
        return userService.getAllUsers()
                .stream()
                .map(user-> {
                    Integer userScore = palindromeContainer
                            .getUserPalindromes(user.getId())
                            .stream()
                            .map(StringUtils::uniqueLettersCount)
                            .reduce(Integer::sum)
                            .orElse(0);
                    return new Pair<>(user,userScore);
                })
                .sorted((p1,p2)-> p2.getRight()- p1.getRight())
                .limit(usersLimit)
                .collect(Collectors.toList());
    }

    @Override
    public boolean savePalindrome(String str, User user) {
        String userId = user.getId();
        str = StringUtils.leaveNumbersAndLetters(str);
        boolean valid = userService.containsUserById(userId)
                && palindromeHandler.isPalindrome(str)
                && !palindromeContainer.containsPalindrome(str, userId);
        if (valid){
            return palindromeContainer.savePalindrome(str,userId);
        }
        return false;
    }
}
