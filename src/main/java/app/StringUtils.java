package app;

import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    public static String leaveNumbersAndLetters(String str) {
        return str
                .toLowerCase()
                .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "")
                .replaceAll("\\s+", "");
    }

    public static int uniqueLettersCount(String str){
        Set<Character> omg = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char el: chars) omg.add(el);
        return omg.size();
    }
}
