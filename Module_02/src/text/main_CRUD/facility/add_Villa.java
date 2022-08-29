package text.main_CRUD.facility;

import casestudy_furama_resort_module_02.service.impl.facility.FacilityServiceImpl;

public class add_Villa {
    public static void main(String[] args) {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.addVilla();
    }
}
