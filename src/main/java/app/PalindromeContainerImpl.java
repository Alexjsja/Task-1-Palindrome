package app;

import app.exceptions.NotFoundException;
import app.interfaces.PalindromeContainer;

import javax.management.ImmutableDescriptor;
import java.util.*;

public class PalindromeContainerImpl implements PalindromeContainer {

    private final Map<String,Set<String>> container = new HashMap<>();

    public PalindromeContainerImpl() {}

    @Override
    public boolean savePalindrome(String str, String userId) {
        if (containsPalindrome(str, userId))return false;

        if (container.containsKey(userId)){
            return container
                    .get(userId)
                    .add(str);
        }else {
            Set<String> palindromes = new HashSet<>();
            palindromes.add(str);
            container.put(userId, palindromes);
            return true;
        }
    }

    @Override
    public boolean containsPalindrome(String str, String userId) {
        if (container.containsKey(userId)){
            return container
                    .get(userId)
                    .contains(str);
        }
        return false;
    }

    @Override
    public Set<String> getUserPalindromes(String userId) {
        return Collections.unmodifiableSet(container.getOrDefault(userId,Set.of()));
    }
}
