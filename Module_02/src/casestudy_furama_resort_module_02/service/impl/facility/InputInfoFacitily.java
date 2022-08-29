package casestudy_furama_resort_module_02.service.impl.facility;

import utils.exception.check.Facitily.ValidateInfoFacitily.ValidateId;
import utils.exception.check.Facitily.ValidateInfoFacitily.ValidateNameFacility;
import utils.exception.exception.InvalidException;
import utils.exception.exception.InvalidStringException;

import java.util.Scanner;

public class InputInfoFacitily {
    Scanner scanner = new Scanner(System.in);

    public String infoId(String facility, String idType) {
        ValidateId validateId = new ValidateId();
        String iD;
        while (true) {
            iD = inputString(idType);
            if (iD.equals("")) {
                continue;
            }
            if (facility.equals("House") && validateId.validateHouse(iD)) {
                return iD;
            } else if (facility.equals("Villa") && validateId.validateVilla(iD)) {
                return iD;
            } else if (facility.equals("Room") && validateId.validateRoom(iD)) {
                return iD;
            } else {
                System.out.println("ID không đúng định dạng, vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập thông tin  tên dịch vụ
     *
     * @return tee dịch vụ
     */

    public String infoName() {
        ValidateNameFacility validateNameFacility = new ValidateNameFacility();
        String name;
        while (true) {
            name = inputString("name");
            if (name.equals("")) {
                continue;
            }
            if (validateNameFacility.validate(name)) {
                return name;
            } else {
                System.out.println("Tên không đúng định dạng, vui lòng nhập lại!");
            }
        }
    }

    /**
     * nhập thông tin diện tích sử dụng
     *
     * @return thông tin diện tích sử dụng
     */
    public double infoUsableArea() {
        double usableArea;
        while (true) {
            try {
                System.out.print("Mời bạn nhập Usable Area : ");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea <= 30) {
                    throw new InvalidException("Diện tích sử dụng  phải là số thực lớn hơn 30m2");
                }
                return usableArea;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * nhập thông tin chi phí
     *
     * @return chi phí
     */
    public double infoCost() {
        double cost;
        while (true) {
            try {
                System.out.print("Mời bạn nhập cost : ");
                cost = Double.parseDouble(scanner.nextLine());
                if (cost < 0) {
                    throw new InvalidException("Chi phí phải là số dương");
                }
                return cost;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * nhập thông tin  Lượng người tối đa
     *
     * @return Lượng người tối đa
     */
    public int infoMaximumPeople() {
        int maximumPeople;
        while (true) {
            try {
                System.out.print("Mời bạn nhập maximumPeople : ");
                maximumPeople = Integer.parseInt(scanner.nextLine());
                if (!(maximumPeople > 0 && maximumPeople < 20)) {
                    throw new InvalidException(" Lượng người tối đa phải >0 và nhỏ hơn <20");
                }
                return maximumPeople;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String infoRentType() {
        return inputString("rent type");
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
