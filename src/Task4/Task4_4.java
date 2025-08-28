package Task4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task4_4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите дату в формате 'дд.мм.гггг'");
            String date1 = scanner.nextLine();

            try {
                SimpleDateFormat date1Format = new SimpleDateFormat("dd.MM.yyyy");
                Date date = date1Format.parse(date1);
                SimpleDateFormat date2Format = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = date2Format.format(date);
                System.out.println(date2);
            } catch (ParseException e) {
                System.out.println("Ошибка: Неверный формат даты. Используйте формат 'дд.мм.гггг'");
            }
        }
    }
}
