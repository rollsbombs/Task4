package Task4;

import java.util.Scanner;

public class Task4_3 {
    private static String addZero(String number) {
        if (number.length() == 1) {
            return "0".concat(number);
        }
        return number;
    }

    private static boolean isNumber(String str) {
        if (str == null || str.isEmpty())
            return false;
        String numbers = "0123456789";
        for (int i = 0; i < str.length(); i++) {
            String symbol = str.substring(i, i + 1);
            if (!numbers.contains(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMonth(String month) {
        if (!isNumber(month))
            return false;
        String validMonths = "01 02 03 04 05 06 07 08 09 10 11 12";
        String mothA = addZero(month).concat(" ");
        return validMonths.contains(mothA);
    }

    private static boolean isDay(String day, String month, String year) {
        if (!isNumber(day) || !isNumber(month) || !isNumber(year))
            return false;
        String dayZ = addZero(day);
        String monthZ = addZero(month);
        int DayInt = Integer.parseInt(day);
        int yearInt = Integer.parseInt(year);
        String month31 = "01 03 05 07 08 10 12";
        if (month31.contains(monthZ.concat(" "))) {
            String validDay31 = "01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31";
            return validDay31.contains(dayZ.concat(" "));
        }
        String month30 = "04 06 09 11";
        if (month30.contains(monthZ.concat(" "))) {
            String validDay30 = "01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30";
            return validDay30.contains(dayZ.concat(" "));
        }
        if (monthZ.equals("02")) {
            boolean visYear = (yearInt % 4 == 0) && (yearInt % 100 !=0) || (yearInt % 400 == 0);
            if (visYear) {
                String validDayFebVis = "01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29";
                return validDayFebVis.contains(dayZ.concat(" "));
            } else {
                String validDayFeb = "01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28";
                return validDayFeb.contains(dayZ.concat(" "));
            }
        }
        return false;
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
            String day = addZero(parts[0]);
            String month = addZero(parts[1]);
            String year = parts[2];
            if (year.length() != 4) {
                System.err.println("Ошибка: год должен содержать 4 цифры");
                return;
            }
            if (!(isNumber(day) && isNumber(month) && isNumber(year))) {
                System.err.println("Ошибка: дата должна содержать только цифры");
                return;
            }
            if (!isMonth(month)) {
                System.err.println("Ошибка: месяц должен быть от 1 до 12");
                return;
            }
            if (!isDay(day, month, year)) {
                System.err.println("Ошибка: неверное количество дней в месяце");
                return;
            }
            String date2 = year.concat("-").concat(month).concat("-").concat(day);
            System.out.println(date2);
        }
    }
}