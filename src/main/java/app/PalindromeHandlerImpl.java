package app;

import app.interfaces.PalindromeHandler;

public class PalindromeHandlerImpl implements PalindromeHandler {

    @Override
    public boolean isPalindrome(String str) {
        StringBuilder builder1 = new StringBuilder(str);
        return str.equals(builder1.reverse().toString());
    }

}
