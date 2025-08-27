package Task4;

import java.util.Scanner;

public class Task4_2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String str = scanner.nextLine();
            if (str.isEmpty()) {
                System.err.println("Ошибка: строка не может быть пустой");
                return;
            }
            String[] words = str.split("\\s+");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                String lowerWord = word.toLowerCase();
                if (lowerWord.equals("бяка") || lowerWord.equals("кака")) {
                    result.append("вырезано цензурой");
                } else {
                    result.append(word);
                }
                result.append(" ");
            }
            String finalResult = result.toString().trim();
            System.out.println(finalResult);
            if (str.equals(finalResult)) {
                System.out.println("Замен не произведено - запрещённые слова не найдены!");
            }
        }
    }
}