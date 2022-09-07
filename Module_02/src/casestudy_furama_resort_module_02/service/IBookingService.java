package casestudy_furama_resort_module_02.service;

import casestudy_furama_resort_module_02.model.Booking;

public interface IBookingService {
    void addBooking();

    void displayBooking();

    void createContract();

    void displayContract();

    void editContract();

    Booking getInfoBooking();

    String getBookingCode();
}
