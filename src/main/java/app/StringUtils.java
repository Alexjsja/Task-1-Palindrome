package app;

public class StringUtils {

    public static String leaveNumbersAndLetters(String str) {
        return str
                .toLowerCase()
                .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "")
                .replaceAll("\\s+", "");
    }
}
