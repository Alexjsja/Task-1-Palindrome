package app;

import app.interfaces.PalindromeHandler;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeHandlerTest {



    @Test
    public void palindromesTest(){
        PalindromeHandler palindromeHandler = new PalindromeHandlerImpl();

        boolean palindrome = palindromeHandler.isPalindrome("aabaa");
        boolean palindrome1 = palindromeHandler.isPalindrome("12321");
        boolean palindrome2 = palindromeHandler.isPalindrome("9912321456");
        boolean palindrome3 = palindromeHandler.isPalindrome("9912333321456");
        boolean palindrome4 = palindromeHandler.isPalindrome("12145445499");
        boolean palindrome5 = palindromeHandler.isPalindrome("abac");
        boolean palindrome6 = palindromeHandler.isPalindrome("a");
        boolean palindrome7 = palindromeHandler.isPalindrome("abacaba");
        boolean palindrome8 = palindromeHandler.isPalindrome("aaabaaaa");
        boolean palindrome9 = palindromeHandler.isPalindrome("zzzazzazz");
        boolean palindrome10 = palindromeHandler.isPalindrome("hlbeeykoqqqqokyeeblh");
        boolean palindrome11 = palindromeHandler.isPalindrome("hlbeeykoqqqokyeeblh");

        assertTrue(palindrome);
        assertTrue(palindrome1);
        assertFalse(palindrome2);
        assertFalse(palindrome3);
        assertFalse(palindrome4);
        assertFalse(palindrome5);
        assertTrue(palindrome6);
        assertTrue(palindrome7);
        assertFalse(palindrome8);
        assertFalse(palindrome9);
        assertTrue(palindrome10);
        assertTrue(palindrome11);
    }
}