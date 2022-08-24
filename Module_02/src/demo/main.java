package demo;

import utils.exception.InvalidAgeException;
import utils.exception.InvalidStringException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh: ");
                dateOfBirth = scanner.nextLine();
                if (dateOfBirth.equals("")) {
                    throw new InvalidStringException("Vui lòng nhập dữ liệu vào!");
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false); // kiểm tra chặt chẽ hơn
                Date DateOfBirthToDate = formatter.parse(dateOfBirth);//được dụng để phân tích string thành date trong java.

                String dateNowString = formatter.format(new Date());//được dụng để phân tích date nơ thành String trong java.
                int yearNow = Integer.parseInt(dateNowString.substring(dateNowString.length() - 4));
                int yearOfBirth = Integer.parseInt(dateOfBirth.substring(dateOfBirth.length() - 4));
                System.out.println(yearNow);
                System.out.println(yearOfBirth);
                int age = yearNow - yearOfBirth;
                if (age < 18 || age > 100) {
                    throw new InvalidAgeException("Tuổi phải lớn hơn hoặc bằng 18 và nhỏ hơn hoặc bằng 100");
                }
                System.out.println(dateOfBirth);
            } catch (NumberFormatException | ParseException e) {
                System.out.println("Ngày sinh chưa đúng định dạng dd/MM/yyyy. Nhập lại: ");
            } catch (InvalidAgeException | InvalidStringException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
