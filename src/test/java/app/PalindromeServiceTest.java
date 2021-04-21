package app;

import app.interfaces.PalindromeContainer;
import app.interfaces.PalindromeHandler;
import app.interfaces.PalindromeService;
import app.interfaces.UserService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PalindromeServiceTest {

    private static PalindromeHandler palindromeHandler;
    private static PalindromeContainer palindromeContainer;
    private static UserService userService;
    private static PalindromeService palindromeService;

    @BeforeClass
    public static void init(){
        palindromeHandler = new PalindromeHandlerImpl();
        palindromeContainer = new PalindromeContainerImpl();
        userService = new UserServiceImpl();
        palindromeService = new PalindromeServiceImpl(
                palindromeHandler,palindromeContainer,userService
        );
    }

    @Test
    public void leaderboardTest(){
        User alex = userService.saveUser("alex");
        User dima = userService.saveUser("dima");
        User pasha = userService.saveUser("pasha");
        User kirill = userService.saveUser("kirill");
        User arsen = userService.saveUser("arsen");
        for (int i = 0; i < 10; i++) userService.saveUser("noname"+i);


        assertTrue(palindromeService.savePalindrome("aabaa", alex));
        assertTrue(palindromeService.savePalindrome("hlbeeykoqqqqokyeeblh",dima));
        assertTrue(palindromeService.savePalindrome("abacaba",arsen));
        assertTrue(palindromeService.savePalindrome("hlbeeykoqqqokyeeblh",kirill));
        assertFalse(palindromeService.savePalindrome("zzzazzazz", pasha));


        List<Pair<User, Integer>> leaderboard = palindromeService.getLeaderboard();

        assertSame(leaderboard.get(0).getLeft(), dima);
        assertSame(leaderboard.get(4).getLeft(), pasha);
    }

}









