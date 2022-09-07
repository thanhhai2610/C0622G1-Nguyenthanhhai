package casestudy_furama_resort_module_02.service.impl.facility;

import casestudy_furama_resort_module_02.model.facility.Facility;
import casestudy_furama_resort_module_02.model.facility.House;
import casestudy_furama_resort_module_02.model.facility.Room;
import casestudy_furama_resort_module_02.model.facility.Villa;
import casestudy_furama_resort_module_02.service.IFacilityService;
import utils.ConvertListToListString;
import utils.exception.exception.InvalidException;
import utils.exception.exception.InvalidStringException;

import java.util.*;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class FacilityServiceImpl implements IFacilityService {
    public static final String VILLA_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\villa.csv";
    public static final String HOUSE_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\house.csv";
    public static final String ROOM_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\room.csv";
    public static final String FACILITY_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\facility.csv";
    Scanner scanner = new Scanner(System.in);
    private InputInfoFacitily inputInfoFacitily = new InputInfoFacitily();
    private Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private ConvertListToListString convertListToListString = new ConvertListToListString();


    @Override
    public void addHouse() {
        House house = this.infoFacilityHouse();
        this.facilityIntegerMap.put(house, 4);
        writeFile(FACILITY_CSV, true, convertListToListString.listFacilityToString(this.facilityIntegerMap));
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        houseIntegerMap.put(house, 1);
        writeFile(HOUSE_CSV, true, convertListToListString.listHouseToListString(houseIntegerMap));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void addRoom() {
        Room room = this.infoFacilityRoom();
        this.facilityIntegerMap.put(room, 4);
        writeFile(FACILITY_CSV, true, convertListToListString.listFacilityToString(this.facilityIntegerMap));
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        roomIntegerMap.put(room, 1);
        writeFile(ROOM_CSV, true, convertListToListString.listRoomToListString(roomIntegerMap));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void addVilla() {
        Villa villa = this.infoFacilityVilla();
        this.facilityIntegerMap.put(villa, 4);
        writeFile(FACILITY_CSV, true, convertListToListString.listFacilityToString(this.facilityIntegerMap));
        Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
        villaIntegerMap.put(villa, 1);
        writeFile(VILLA_CSV, true, convertListToListString.listVillaToListString(villaIntegerMap));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayFacility() {
        Map<Facility, Integer> facilityInteger = this.readFileFacility();
        Set<Facility> facilitySet = facilityInteger.keySet();
        for (Facility facility : facilitySet) {
            System.out.println(facility + "" + facilityInteger.get(facility));
        }
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> maintainList = this.readFileFacility();
        Map<Facility, Integer> maintainingList = new LinkedHashMap<>();

        Set<Facility> facilitySet = maintainList.keySet();
        for (Facility facility : facilitySet) {
            if (maintainList.get(facility) >= 5) {
                maintainingList.put(facility, maintainList.get(facility));
            }
        }
        if (maintainingList.size() == 0) {
            System.out.println("No facilities are under maintenance");
        } else {
            System.out.print("Facilities under maintenance: " + maintainingList);
        }
    }

    public House infoFacilityHouse() {
        String infoRoomStandard = infoRoomStandard();
        int infoNumberFloors = infoNumberFloors();
        return new House(inputInfoFacitily.infoId("House", "ID House"),
                inputInfoFacitily.infoName(),
                inputInfoFacitily.infoUsableArea(),
                inputInfoFacitily.infoCost(),
                inputInfoFacitily.infoMaximumPeople(),
                inputInfoFacitily.infoRentType(),
                infoRoomStandard, infoNumberFloors);
    }

    public Room infoFacilityRoom() {
        String infoFreeServiceIncluded = infoFreeServiceIncluded();
        return new Room(inputInfoFacitily.infoId("Room", "ID Room"),
                inputInfoFacitily.infoName(),
                inputInfoFacitily.infoUsableArea(),
                inputInfoFacitily.infoCost(),
                inputInfoFacitily.infoMaximumPeople(),
                inputInfoFacitily.infoRentType(),
                infoFreeServiceIncluded);
    }

    public Villa infoFacilityVilla() {
        String infoRoomStandard = infoRoomStandard();
        int infoPoolArea = infoPoolArea();
        int infoNumberFloors = infoNumberFloors();
        return new Villa(inputInfoFacitily.infoId("Villa", "ID Villa"),
                inputInfoFacitily.infoName(),
                inputInfoFacitily.infoUsableArea(),
                inputInfoFacitily.infoCost(),
                inputInfoFacitily.infoMaximumPeople(),
                inputInfoFacitily.infoRentType(),
                infoRoomStandard, infoPoolArea, infoNumberFloors);
    }

    public int infoPoolArea() {
        int poolArea;
        while (true) {
            try {
                System.out.print("Mời bạn nhập Pool Area : ");
                poolArea = Integer.parseInt(scanner.nextLine());
                if (poolArea <= 30) {
                    throw new InvalidException("Diện tích sử dụng  phải là số thực lớn hơn 30m2");
                }
                return poolArea;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int infoNumberFloors() {
        int numberFloor;
        while (true) {
            try {
                System.out.print("Mời bạn nhập numberFloor : ");
                numberFloor = Integer.parseInt(scanner.nextLine());
                if (numberFloor < 0) {
                    throw new InvalidException(" Sô tầng phải là số nguyên dương");
                }
                return numberFloor;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (InvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String infoRoomStandard() {
        return inputString("Room Standard");

    }

    public String infoFreeServiceIncluded() {
        return inputString("free Service Included");

    }

    /**
     * check giá trị nhập (inputValue) vào không đc để rỗng
     *
     * @param inputString có thể là ID, name ,,, bất kì cái nào nhập vào là chuỗi
     * @return tả về giá trị nhập vào cho các thuộc tính
     */
    private String inputString(String inputString) {
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

    /**
     * đọc file danh sách Facility
     *
     * @return mảng có các phần tử là các đối tượng Facility là key  và     là value
     */
    public Map<Facility, Integer> readFileFacility() {
        List<String> facilityArrString = null;
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        try {
            facilityArrString = utils.read_write.ReadFile.readFile(FACILITY_CSV);
            if (facilityArrString.size() == 0) {
                System.out.println("Dữ liệu trong file không có");
            }
            for (int i = 0; i < facilityArrString.size(); i++) {
                String[] strings = facilityArrString.get(i).split("=");
                if (strings[0].contains("SVHO")) {
                    facilityIntegerMap.put(new House(strings[0], strings[1], Double.parseDouble(strings[2]),
                                    Double.parseDouble(strings[3]), Integer.parseInt(strings[4]), strings[5],
                                    strings[6], Integer.parseInt(strings[7])),
                            Integer.parseInt(strings[strings.length - 1]));
                } else if (strings[0].contains("SVRO")) {
                    facilityIntegerMap.put(new Room(strings[0], strings[1], Double.parseDouble(strings[2]),
                                    Double.parseDouble(strings[3]), Integer.parseInt(strings[4]), strings[5],
                                    strings[6]),
                            Integer.parseInt(strings[strings.length - 1]));
                } else if (strings[0].contains("SVVL")) {
                    facilityIntegerMap.put(new Villa(strings[0], strings[1], Double.parseDouble(strings[2]),
                                    Double.parseDouble(strings[3]), Integer.parseInt(strings[4]), strings[5],
                                    strings[6], Double.parseDouble(strings[7]), Integer.parseInt(strings[8])),
                            Integer.parseInt(strings[strings.length - 1]));
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Dữ liệu trong file không có");
        }
        return facilityIntegerMap;
    }


}
