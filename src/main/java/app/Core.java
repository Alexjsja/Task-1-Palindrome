package app;

import java.util.List;

public class Core {

    public static void main(String[] args) {
        PalindromeHandlerImpl palindromeHandler = new PalindromeHandlerImpl();
        List.of(
        palindromeHandler.isPalindrome("aabaa"),
        palindromeHandler.isPalindrome("12321"),
        palindromeHandler.isPalindrome("9912321456"),
        palindromeHandler.isPalindrome("9912333321456"),
        palindromeHandler.isPalindrome("12145445499"),
        palindromeHandler.isPalindrome("abac"),
        palindromeHandler.isPalindrome("a"),
        palindromeHandler.isPalindrome("az"),
        palindromeHandler.isPalindrome("abacaba"),
        palindromeHandler.isPalindrome("aaabaaaa"),
        palindromeHandler.isPalindrome("zzzazzazz"),
        palindromeHandler.isPalindrome("hlbeeykoqqqqokyeeblh"),
        palindromeHandler.isPalindrome("hlbeeykoqqqokyeeblh"))
        .forEach(System.err::println);

    }

}
