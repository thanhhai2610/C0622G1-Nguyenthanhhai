package utils;

import casestudy_furama_resort_module_02.model.Booking;
import utils.exception.check.task6.ValidateDate;

import java.time.LocalDate;
import java.util.Comparator;

public class BookingCompare  implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        LocalDate startDate1 = ValidateDate.validateDateFormat(o1.getStartDate());
        LocalDate startDate2 = ValidateDate.validateDateFormat(o2.getStartDate());
        LocalDate endDate1 = ValidateDate.validateDateFormat(o1.getEndDate());
        LocalDate endDate2 = ValidateDate.validateDateFormat(o2.getEndDate());
        if (startDate1.compareTo(startDate2) != 0) {
            return startDate1.compareTo(startDate2);
        } else if(endDate1.compareTo(endDate2)!=0){
            return o1.getEndDate().compareTo(o2.getEndDate());
        }else {
            return o1.getBookingCode().compareTo(o2.getBookingCode());
        }
    }
}
