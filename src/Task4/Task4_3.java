package Task4;

import java.util.Scanner;

public class Task4_3 {

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isTrueDate(int day, int month, int year) {
        if (month < 1 || month > 12)
            return false;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day >= 1 && day <= 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return day >= 1 && day <= 30;
            case 2:
                boolean isVisYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
                return isVisYear ? day >= 1 && day <= 29 : day >= 1 && day <= 28;
            default:
                return false;
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите строку в формате 'дд.мм.гггг'");
            String date1 = scanner.nextLine();
            if (date1.isEmpty()) {
                System.err.println("Ошибка: строка не может быть пустой");
                return;
            }
            String[] parts = date1.split("\\.");
            if (parts.length != 3) {
                System.err.println("Ошибка: неверный формат даты");
                return;
            }
            String dayStr = parts[0];
            String monthStr = parts[1];
            String yearStr = parts[2];
            if (!isNumber(dayStr) || !isNumber(monthStr) || !isNumber(yearStr)) {
                System.err.println("Ошибка: все части даты должны быть числами");
                return;
            }
            if (yearStr.length() != 4) {
                System.err.println("Ошибка: год должен содержать 4 цифры");
                return;
            }
            int day, month, year;
            try {
                day = Integer.parseInt(dayStr);
                month = Integer.parseInt(monthStr);
                year = Integer.parseInt(yearStr);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: неверный числовой формат");
                return;
            }
            if (!isTrueDate(day, month, year)) {
                System.err.println("Ошибка: такой даты не существует");
                return;
            }
            String formatDay = String.format("%02d", day);
            String formatMonth = String.format("%02d", month);
            String date2 = year + ("-") + formatMonth + ("-") + formatDay;
            System.out.println(date2);
        }
    }
}