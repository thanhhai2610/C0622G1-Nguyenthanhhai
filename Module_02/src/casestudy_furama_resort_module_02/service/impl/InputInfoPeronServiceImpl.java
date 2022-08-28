package casestudy_furama_resort_module_02.service.impl;

import utils.exception.check.ValidateInfo.*;
import utils.exception.exception.InvalidAgeException;
import utils.exception.exception.InvalidStringException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputInfoPeronServiceImpl {
    Scanner scanner = new Scanner(System.in);


    /**
     * nhập thông tin họ và tên
     *
     * @return name
     */

    public String infoName() {
        ValidateName validateName = new ValidateName();
        String name;
        while (true) {
            name = inputString("name");
            if (name.equals("")) {
                continue;
            }
            if (validateName.validate(name)) {
                return name;
            } else {
                System.out.println("Tên không đúng định dạng, vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập thông tin ngày sinh
     *
     * @return ngày sinh
     */
    public String infoDateOfBirth() {
        String dateBirth;
        SimpleDateFormat formatter;
        Date DateOfBirthToDate;
        String dateNowString;
        int yearNow;
        int yearOfBirth;
        int age;

        while (true) {
            try {
                dateBirth = inputString("date birth");
                if (dateBirth.equals("")) {
                    continue;
                }
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                DateOfBirthToDate = formatter.parse(dateBirth);
                dateNowString = formatter.format(new Date());
                yearNow = Integer.parseInt(dateNowString.substring(dateNowString.length() - 4));
                yearOfBirth = Integer.parseInt(dateBirth.substring(dateBirth.length() - 4));
                age = yearNow - yearOfBirth;
                if (age < 18 || age > 100) {
                    throw new InvalidAgeException("Tuổi phải lớn hơn hoặc bằng 18 và nhỏ hơn hoặc bằng 100");
                }
                return dateBirth;
            } catch (NumberFormatException e) {
                System.out.println("Ngày sinh chưa đúng định dạng dd/MM/yyyy. Nhập lại: ");
            } catch (ParseException e) {
                System.out.println("Bạn cần nhập đúng ngày tháng năm sinh . Nhập lại: ");
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * nhập thông tin giới tính
     *
     * @return giới tính
     */
    public String infoGender() {
        ValidateGender validateGender = new ValidateGender();
        String gender;
        while (true) {
            gender = inputString("gender");
            if (gender.equals("")) {
                continue;
            }
            if (validateGender.validate(gender)) {
                return gender;
            } else {
                System.out.println("Bạn cần nhập (Nam,Nữ or Khác), vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập số CMND
     *
     * @return Số CMND
     */
    public String infoNumberIdentity() {
        ValidateIdentity validateIdentity = new ValidateIdentity();
        String numberIdentity;
        while (true) {
            numberIdentity = inputString("numberIdentity");
            if (numberIdentity.equals("")) {
                continue;
            }
            if (validateIdentity.validate(numberIdentity)) {
                return numberIdentity;
            } else {
                System.out.println("Bạn cần nhập đủ 9 sô CMND, vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập số phone
     *
     * @return số phone
     */
    public String infoNumberPhone() {
        ValidateNumberPhone validateNumberPhone = new ValidateNumberPhone();
        String numberPhone;
        while (true) {
            numberPhone = inputString("numberPhone");
            if (numberPhone.equals("")) {
                continue;
            }
            if (validateNumberPhone.validate(numberPhone)) {
                return numberPhone;
            } else {
                System.out.println("Bạn cần nhập đủ số phone, vui lòng nhập lại!");
            }
        }
    }

    /**
     * Nhập thông tin mail
     *
     * @return mail
     */
    public String infoEmail() {
        ValidateMail validateMail = new ValidateMail();
        String email;
        while (true) {
            email = inputString("Email");
            if (email.equals("")) {
                continue;
            }
            if (validateMail.validate(email)) {
                return email;
            } else {
                System.out.println("Bạn cần nhập đúng định dạng Email, vui lòng nhập lại!");
            }
        }
    }

    /**
     * check giá trị nhập (inputValue) vào không đc để rỗng
     *
     * @param inputString có thể là ID, name ,,, bất kì cái nào nhập vào là chuỗi
     * @return tả về giá trị nhập vào cho các thuộc tính
     */
    public String inputString(String inputString) {
        String inputValue;
        while (true) {
            System.out.print("Mời bạn nhập " + inputString + " : ");
            inputValue = scanner.nextLine();
            if (inputValue.equals("")) {
                try {
                    throw new InvalidStringException("Vui lòng nhập lại ,bạn chưa nhập dữ liệu vào!");
                } catch (InvalidStringException e) {
                    System.out.println(e.getMessage());
                }
            }
            return inputValue;
        }
    }

}
