package casestudy_furama_resort_module_02.service.impl.facility;

import casestudy_furama_resort_module_02.model.facility.Facility;
import casestudy_furama_resort_module_02.model.facility.House;
import casestudy_furama_resort_module_02.model.facility.Room;
import casestudy_furama_resort_module_02.model.facility.Villa;
import casestudy_furama_resort_module_02.service.IFacilityService;
import utils.exception.exception.InvalidException;
import utils.exception.exception.InvalidStringException;

import java.util.*;

import static utils.read_write_file.WriteFileUtil.writeFile;

public class FacilityServiceImpl implements IFacilityService {
    public static final String VILLA_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\villa.csv";
    public static final String HOUSE_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\house.csv";
    public static final String ROOM_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\room.csv";
    Scanner scanner = new Scanner(System.in);
    InputInfoFacitily inputInfoFacitily = new InputInfoFacitily();
    Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
    Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
    Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();

    @Override
    public void addHouse() {
        House house = this.infoFacilityHouse();
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        houseIntegerMap.put(house, 1);
        writeFile(HOUSE_CSV, true, convertListHouseToListString(houseIntegerMap));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void addRoom() {
        Room room = this.infoFacilityRoom();
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        roomIntegerMap.put(room, 1);
        writeFile(ROOM_CSV, true, convertListRoomToListString(roomIntegerMap));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void addVilla() {
        Villa villa = this.infoFacilityVilla();
        Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
        villaIntegerMap.put(villa, 1);
        writeFile(VILLA_CSV, true, convertListVillaToListString(villaIntegerMap));
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayFacility() {

    }

    @Override
    public void displayFacilityMaintenance() {

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

    /**
     * @param houseIntegerMap
     * @return
     */
    public List<String> convertListHouseToListString(Map<House, Integer> houseIntegerMap) {
        Set<House> houseSet = houseIntegerMap.keySet();
        List<String> stringHouseList = new ArrayList<>();

        for (House house : houseSet) {
            stringHouseList.add(house.toString() + houseIntegerMap.get(house));
        }
        return stringHouseList;
    }

    public List<String> convertListRoomToListString(Map<Room, Integer> roomIntegerMap) {
        Set<Room> roomSet = roomIntegerMap.keySet();
        List<String> stringRoomList = new ArrayList<>();

        for (Room room : roomSet) {
            stringRoomList.add(room.toString() + roomIntegerMap.get(room));
        }
        return stringRoomList;
    }

    public List<String> convertListVillaToListString(Map<Villa, Integer> villaIntegerMap) {
        Set<Villa> villaSet = villaIntegerMap.keySet();
        List<String> stringVillaList = new ArrayList<>();

        for (Villa villa : villaSet) {
            stringVillaList.add(villa.toString() + villaIntegerMap.get(villa));
        }
        return stringVillaList;
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
            facilityArrString = utils.read_write.ReadFile.readFile(HOUSE_CSV);
            if (facilityArrString.size() == 0) {
                System.out.println("Dữ liệu trong file không có");
            }
        } catch (NullPointerException e) {
            System.out.println("Dữ liệu trong file không có");
        }
        for (int i = 0; i < facilityArrString.size(); i++) {
            String[] infoHouse = facilityArrString.get(i).split("=");
            House house = new House(infoHouse[0], infoHouse[1], Double.parseDouble(infoHouse[2]), Integer.parseInt(infoHouse[3]), Integer.parseInt(infoHouse[4]),
                    (infoHouse[5]), infoHouse[6], Integer.parseInt(infoHouse[7]));
            facilityIntegerMap.put(house, Integer.parseInt(infoHouse[9]));
        }
        return facilityIntegerMap;
    }


}
