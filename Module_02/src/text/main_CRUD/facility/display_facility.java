package text.main_CRUD.facility;

import casestudy_furama_resort_module_02.service.impl.facility.FacilityServiceImpl;

public class display_facility {
    public static void main(String[] args) {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.displayFacility();
    }
}
