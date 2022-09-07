package casestudy_furama_resort_module_02.service.impl.facility;

import casestudy_furama_resort_module_02.model.Booking;
import casestudy_furama_resort_module_02.model.Contract;
import casestudy_furama_resort_module_02.model.facility.Facility;
import casestudy_furama_resort_module_02.model.person.Customer;
import casestudy_furama_resort_module_02.service.IBookingService;
import casestudy_furama_resort_module_02.service.impl.person.CustomerServiceImpl;
import utils.BookingCompare;
import utils.exception.check.task6.ValidateCommonInfo;
import utils.exception.check.task6.ValidateDate;
import utils.exception.exception.task6.*;
import utils.read_write_nhi_phan.WriteFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingServiceImpl implements IBookingService {

    public static final String BOOKING_LIST_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\booking.csv";
    public static final String CONTRACT_LIST_CSV = "Module_02\\src\\casestudy_furama_resort_module_02\\data\\contract.csv";
    public static BookingCompare bookingCompare = new BookingCompare();
    private static Scanner scanner = new Scanner(System.in);
    public static TreeSet<Booking> bookings = new TreeSet<>(bookingCompare);
    public static Queue<Booking> bookingQueue = new PriorityQueue<>();
    public static List<Contract> contracts = new ArrayList<>();
    LinkedHashMap<String, Integer> serviceUse = new LinkedHashMap<>();

    @Override
    public void addBooking() {
        bookings = readFileBooking();
        Booking booking = this.getInfoBooking();
        bookings.add(booking);
        bookingQueue.add(booking);
        System.out.println("New booking is successfully added!");
        WriteFile.writeFile(BOOKING_LIST_CSV, convertListBookingToListString(bookings));
    }

    @Override
    public void displayBooking() {
        bookings = readFileBooking();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    @Override
    public void createContract() {
        contracts = readFileContract();
        if (bookingQueue.size() == 0) {
            System.out.println("No booking data exists.");
            return;
        }
        String bookingCode = bookingQueue.poll().getBookingCode();

        double totalPayment;
        while (true) {
            try {
                System.out.println("Enter total payment: ");
                totalPayment = Double.parseDouble(scanner.nextLine());
                if (!ValidateCommonInfo.validateMoney(totalPayment)) {
                    throw new InvalidMoneyException("Valid amount of total payment must be in range of [0;2^63-1]");
                }
                break;
            } catch (InvalidMoneyException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        //getContractCode
        String contractCode;
        if (contracts.size() == 0) {
            contractCode = "CT-1";
        } else {
            String[] code = contracts.get(contracts.size() - 1).getContractCode().split("-");
            int number = Integer.parseInt(code[1]);
            contractCode = "CT-" + number;
        }

        double deposit;
        while (true) {
            try {
                System.out.println("Enter deposit: ");
                deposit = Double.parseDouble(scanner.nextLine());
                if ((!ValidateCommonInfo.validateMoney(deposit)) && (deposit <= totalPayment)) {
                    throw new InvalidMoneyException("Valid amount of deposit must be in range of [0;2^63-1], " +
                            "and must be not larger than the total payment");
                }
                break;
            } catch (InvalidMoneyException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        // getCustomerCode
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        List<Customer> customerList = customerServiceImpl.readFileCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(i + 1 + "," + customerList.get(i));
        }


        int choiceCustomerCode;
        String customerCode;
        while (true) {
            System.out.println("Enter 1-" + customerList.size());
            choiceCustomerCode = Integer.parseInt(scanner.nextLine());
            if (choiceCustomerCode < 0 || choiceCustomerCode > customerList.size()) {
                System.out.println("Invalid choice! Please choose again!");
            } else {
                customerCode = customerList.get(choiceCustomerCode - 1).getId();
                break;
            }
        }

        Contract contract = new Contract(contractCode, bookingCode, deposit, totalPayment, customerCode);
        contracts.add(contract);
        System.out.println("New contract is successfully added!");
        WriteFile.writeFile(CONTRACT_LIST_CSV, convertListContractToListString(contracts));
    }

    @Override
    public void displayContract() {
        contracts = readFileContract();
        for(Contract contract:contracts){
            System.out.println(contract);
        }

    }

    @Override
    public void editContract() {

    }

    @Override
    public Booking getInfoBooking() {
        String bookingCode = this.getBookingCode();

        //getServiceCode
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        List<Facility> facilities = (List<Facility>) facilityService.readFileFacility();
        for (int i = 0; i < facilities.size(); i++) {
            System.out.println(i + 1 + "," + facilities.get(i));
        }
        int choiceFacilityCode;

        String serviceCode;
        while (true) {
            System.out.println("Enter 1-" + facilities.size());
            choiceFacilityCode = Integer.parseInt(scanner.nextLine());
            if (choiceFacilityCode < 0 || choiceFacilityCode > facilities.size()) {
                System.out.println("Invalid choice! Please choose again!");
            } else {
                serviceCode = facilities.get(choiceFacilityCode - 1).getIdService();
                break;
            }
        }

        //getStartDate
        String startDate;
        while (true) {
            try {
                System.out.println("Enter start date: ");
                startDate = scanner.nextLine();
                LocalDate lcStartDate = ValidateDate.validateDateFormat(startDate);
                if (lcStartDate == null) {
                    throw new InvalidDateException("Invalid date. Please check the date and its format!");
                } else if (!ValidateDate.validateStartDate(lcStartDate)) {
                    throw new InvalidStartDateException("Invalid start date. Start date must be after today: " + (LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                } else {
                    for (Booking booking : bookings) {
                        if (serviceCode.equals(booking.getServiceCode())) {
                            if (!ValidateDate.validateDate(lcStartDate, booking.getStartDate(), booking.getEndDate())) {
                                throw new OverlappingPeriodException("The facility you chose is not available at this time!");
                            }
                        }
                    }
                }

                break;
            } catch (InvalidDateException e) {
                System.err.println(e.getMessage());
            } catch (InvalidStartDateException e) {
                System.err.println(e.getMessage());
            } catch (OverlappingPeriodException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        //getEndDate
        String endDate;
        while (true) {
            try {
                System.out.println("Enter end date: ");
                endDate = scanner.nextLine();
                LocalDate lcEndDate = ValidateDate.validateDateFormat(endDate);
                if (lcEndDate == null) {
                    throw new InvalidDateException("Invalid date. Please check the date and its format!");
                } else if (!ValidateDate.validateEndDate(startDate, lcEndDate)) {
                    throw new InvalidEndDateException("Invalid end date. End date must be after start date!");
                } else {
                    for (Booking booking : bookings) {
                        if (serviceCode.equals(booking.getServiceCode())) {
                            if (!ValidateDate.validateDate(lcEndDate, booking.getStartDate(), booking.getEndDate())) {
                                throw new OverlappingPeriodException("The facility you chose is not available at this time!");
                            }
                        }

                    }
                }

                break;
            } catch (InvalidDateException e) {
                System.err.println(e.getMessage());
            } catch (InvalidEndDateException e) {
                System.err.println(e.getMessage());
            } catch (OverlappingPeriodException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        // getCustomerCode
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        List<Customer> customers = customerService.readFileCustomer();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + 1 + "," + customers.get(i));
        }
        int choiceCustomerCode;
        String customerCode;
        while (true) {
            System.out.println("Enter 1-" + customers.size());
            choiceCustomerCode = Integer.parseInt(scanner.nextLine());
            if (choiceCustomerCode < 0 || choiceCustomerCode > customers.size()) {
                System.out.println("Invalid choice! Please choose again!");
            } else {
                customerCode = customers.get(choiceCustomerCode - 1).getId();
                break;
            }
        }

        //getServiceType
        int choice;
        String serviceType;
        loopServiceType:
        while (true) {
            try {
                System.out.println("1. Hourly rental\n2. Daily rental\n3. Weekly rental\n4. Monthly rental");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        serviceType = "Hourly rental";
                        break loopServiceType;
                    case 2:
                        serviceType = "Daily rental";
                        break loopServiceType;
                    case 3:
                        serviceType = "Weekly rental";
                        break loopServiceType;
                    case 4:
                        serviceType = "Monthly rental";
                        break loopServiceType;
                    default:
                        System.out.println("Invalid choice! Please choose again!");
                }
            } catch (NumberFormatException e) {
                e.getStackTrace();

            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return new Booking(bookingCode, startDate, endDate, customerCode, serviceCode, serviceType);
    }

    @Override
    public String getBookingCode() {
        bookings = readFileBooking();
        if (bookings.size() == 0) {
            return "BK-1";
        } else {
            TreeSet<String> codes = new TreeSet<>();
            for (Booking booking : bookings) {
                codes.add(booking.getBookingCode());
            }
            String[] codeArray = codes.last().split("-");
            int number = Integer.parseInt(codeArray[1]);
            number += 1;
            return "BK-" + number;
        }
    }

    private TreeSet<Booking> readFileBooking() {
        List<String> bookingList = utils.read_write.ReadFile.readFile(BOOKING_LIST_CSV);
        TreeSet<Booking> bookings = new TreeSet<>(bookingCompare);
        if (bookingList.size() == 0) {
            System.out.println("No data exists! Please add some information!");
        } else {
            String[] propertiesOfBooking;
            Booking booking;
            for (int i = 0; i < bookingList.size(); i++) {
                propertiesOfBooking = bookingList.get(i).split(",");
                booking = new Booking(propertiesOfBooking[0], propertiesOfBooking[1], propertiesOfBooking[2], propertiesOfBooking[3], propertiesOfBooking[4], propertiesOfBooking[5]);
                bookings.add(booking);
            }
        }
        return bookings;
    }

    private List<Contract> readFileContract() {
        List<String> contractList = utils.read_write.ReadFile.readFile(CONTRACT_LIST_CSV);
        List<Contract> contracts = new ArrayList<>();
        if (contractList.size() == 0) {
            System.out.println("No data exists! Please add some information!");
        } else {
            String[] propertiesOfContract;
            Contract contract;
            for (int i = 0; i < contractList.size(); i++) {
                propertiesOfContract = contractList.get(i).split(",");
                contract = new Contract(propertiesOfContract[0], propertiesOfContract[1], Double.parseDouble(propertiesOfContract[2]), Double.parseDouble(propertiesOfContract[3]), propertiesOfContract[4]);
                contracts.add(contract);
            }
        }
        return contracts;
    }


    private List<String> convertListBookingToListString(TreeSet<Booking> bookings) {
        List<String> strings = new ArrayList<>();
        for (Booking booking : bookings) {
            strings.add(booking.getInfo());
        }
        return strings;
    }

    private List<String> convertListContractToListString(List<Contract> contracts) {
        List<String> strings = new ArrayList<>();
        for (Contract contract : contracts) {
            strings.add(contract.getInfo());
        }
        return strings;
    }
}

