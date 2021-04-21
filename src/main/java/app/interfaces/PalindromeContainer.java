package app.interfaces;

import java.util.Set;

public interface PalindromeContainer {

    boolean savePalindrome(String str,String userId);

    boolean containsPalindrome(String str,String userId);

    Set<String> getUserPalindromes(String userId);
}


