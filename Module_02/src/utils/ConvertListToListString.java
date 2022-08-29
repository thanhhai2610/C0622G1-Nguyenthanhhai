package utils;

import casestudy_furama_resort_module_02.model.facility.Facility;
import casestudy_furama_resort_module_02.model.facility.House;
import casestudy_furama_resort_module_02.model.facility.Room;
import casestudy_furama_resort_module_02.model.facility.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConvertListToListString {

    /**
     * chuyển mảng Facility thành mảng Facility   String
     *
     * @param facilityIntegerMap mảng Facility
     * @return mảng  String
     */
    public List<String> listFacilityToString(Map<Facility, Integer> facilityIntegerMap) {
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        List<String> stringFacilityList = new ArrayList<>();
        for (Facility facility : facilitySet) {
            stringFacilityList.add(facility.toString() + facilityIntegerMap.get(facility));
        }
        return stringFacilityList;
    }

    /**
     * chuyển mảng House thành mảng House   String
     *
     * @param houseIntegerMap mảng House
     * @return mảng  String
     */
    public List<String> listHouseToListString(Map<House, Integer> houseIntegerMap) {
        Set<House> houseSet = houseIntegerMap.keySet();
        List<String> stringHouseList = new ArrayList<>();
        for (House house : houseSet) {
            stringHouseList.add(house.toString() + houseIntegerMap.get(house));
        }
        return stringHouseList;
    }

    public List<String> listRoomToListString(Map<Room, Integer> roomIntegerMap) {
        Set<Room> roomSet = roomIntegerMap.keySet();
        List<String> stringRoomList = new ArrayList<>();

        for (Room room : roomSet) {
            stringRoomList.add(room.toString() + roomIntegerMap.get(room));
        }
        return stringRoomList;
    }

    public List<String> listVillaToListString(Map<Villa, Integer> villaIntegerMap) {
        Set<Villa> villaSet = villaIntegerMap.keySet();
        List<String> stringVillaList = new ArrayList<>();

        for (Villa villa : villaSet) {
            stringVillaList.add(villa.toString() + villaIntegerMap.get(villa));
        }
        return stringVillaList;
    }

}
