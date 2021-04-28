package app;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        loop();
    }

    private static void loop() {
        Scanner scan = new Scanner(System.in);
        PalindromeContainerImpl container = new PalindromeContainerImpl();
        PalindromeHandlerImpl handler = new PalindromeHandlerImpl();
        UserServiceImpl userService = new UserServiceImpl();
        PalindromeServiceImpl palindromeService = new PalindromeServiceImpl(
                handler,container,userService);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - зарегистрироваться в игре");
            System.out.println("2 - посмотреть список лидеров");
            System.out.println("3 - ввести палиндром");
            String action = scan.nextLine();
            switch (action) {
                case "1":
                    System.out.println("Введите ваше имя:");
                    String userName = scan.nextLine();
                    if (userService.containsUserByName(userName)){
                        System.err.println("Имя занято");
                        break;
                    }
                    User savedUser = userService.saveUser(userName);
                    System.err.printf("Ваш id=%s,ЗАПОМНИТЕ ЕГО \n", savedUser.getId());
                    break;
                case "2":
                    System.out.println("5 лучших пользователей");
                    palindromeService.getLeaderboard()
                            .forEach(userPointsPair -> {
                                User user = userPointsPair.getLeft();
                                Integer points = userPointsPair.getRight();
                                System.out.printf("Пользователь %s с очками в количестве %s \n", user.getName(), points);
                            });
                    break;
                case "3":
                    System.out.println("Введите ваш id, что-бы мы поняли кто вы");
                    String userId = scan.nextLine();
                    if (userService.containsUserById(userId)) {
                        System.out.println("Введите полиндром");
                        String palindrome = scan.nextLine();
                        if (container.containsPalindrome(palindrome, userId)) {
                            System.err.println("Вы уже вводили этот полиндром");
                        } else {
                            User user = userService.getUserById(userId);
                            boolean savedSuccess = palindromeService.savePalindrome(palindrome, user);
                            if (savedSuccess) {
                                System.out.println("Палиндром введен, ищите себя в списке лидеров ( ͡° ͜ʖ ͡°)");
                            } else {
                                System.err.println("Вы ввели не палиндром");
                            }
                        }
                    } else {
                        System.err.printf("Пользователь с id = %s не найден \n", userId);
                        break;
                    }
                    break;
                default:
                    System.err.println("Указанного действия не существует");
                    break;
            }
        }
    }

}
