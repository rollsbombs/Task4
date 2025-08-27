package Task4_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        System.out.println("Введите подстроку");
        String str1 = scanner.nextLine();
        boolean err = false;
        if (str.isEmpty()) {
            System.err.println("Ошибка: строка не может быть пустой");
            err = true;
        }
        if (str1.isEmpty()) {
            System.err.println("Ошибка: подстрока не может быть пустой");
            err = true;
        }
        if (err) {
            scanner.close();
            return;
        }
        int count = 0;
        int index = 0;
        while (index < str.length()) {
            int foundIndex = str.indexOf(str1, index);
            if (foundIndex == -1) {
                break;
            }
            count++;
            index = foundIndex + str1.length();
        }
        if (count == 0) {
            System.out.println("Подстрока '" + str1 + "' не найдена!");
        } else {
            int last1 = count % 10;
            int last2 = count % 100;
            if (last2 >= 11 && last2 <= 14) {
                System.out.println("Подстрока '" + str1 + "' встречается " + count + " раз");
            } else if (last1 == 1) {
                System.out.println("Подстрока '" + str1 + "' встречается " + count + " раз");
            } else if (last1 >= 2 && last1 <= 4) {
                System.out.println("Подстрока '" + str1 + "' встречается " + count + " раза");
            } else {
                System.out.println("Подстрока '" + str1 + "' встречается " + count + " раз");
            }
        }
    }
}
}
