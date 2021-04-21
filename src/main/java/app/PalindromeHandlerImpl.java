package app;

import app.interfaces.PalindromeHandler;

public class PalindromeHandlerImpl implements PalindromeHandler {
    @Override
    public boolean isPalindrome(String str) {
        String optimizedStr = str
                .toLowerCase()
                .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "")
                .replaceAll("\\s+", "");
        StringBuilder builder1 = new StringBuilder(optimizedStr);
        return optimizedStr.equals(builder1.reverse().toString());
    }
}
