import Customer.*;
import gasBooking.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    static int bcount = 0, ccount = 0, dcount = 0, pcount = 0;

    public static void main(String[] args) {
        System.out.println("*********************************************************************");
        System.out.println("                      Indian GAS Agency                              ");
        System.out.println("*********************************************************************");

        Delivery[] deliveryObject = new Delivery[4];
        deliveryObject[0] = new Delivery("Rahul", "4th Avenue", "Sector-2", "410210", "9994987779", 1);
        deliveryObject[1] = new Delivery("Malay", "Panvel Road", "Sector-13", "410210", "9995556668", 2);
        deliveryObject[2] = new Delivery("Rushikesh", "Belapur Road", "Sector-12", "410210", "7776666889", 3);
        deliveryObject[3] = new Delivery("Rushi", "Amey Sco", "Sector-12", "410210", "9854777777", 2);

        for (Delivery delivery : deliveryObject) {
            delivery.setDelPersonName();
            delivery.getLastDate();
            delivery.getDates();
            delivery.validate();
            delivery.amountCalc();
            delivery.verifyOtp();
        }

        System.out.println();
        cylinderCount(deliveryObject);
        checkLateDel(deliveryObject);
        numOfSingleCylinders(deliveryObject);
        deliveryDetails(deliveryObject);
        printReport(deliveryObject);
        printInvoice(deliveryObject);
    }

    public static void cylinderCount(Delivery[] obj) {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        for (Delivery delivery : obj) {
            if (delivery != null && delivery.dt_2 != null && "D".equals(delivery.status)) {
                int month = delivery.dt_2.getMonth(); // deprecated, for simple output
                System.out.println("In the month of " + months[month] + " : ");
                System.out.println("* In " + delivery.area);
                System.out.println("- " + delivery.numOfCylinders + " cylinders delivered");
            }
        }
        System.out.println();
    }

    public static void checkLateDel(Delivery[] obj) {
        int[] monthCounts = new int[12];

        for (Delivery delivery : obj) {
            if (delivery != null && "D".equals(delivery.status) && delivery.refund > 0.0 && delivery.dt_2 != null) {
                int month = delivery.dt_2.getMonth();
                monthCounts[month]++;
            }
        }

        System.out.println("--------------Late Deliveries--------------");
        String[] months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < monthCounts.length; i++) {
            if (monthCounts[i] > 0) {
                System.out.println("* In " + months[i] + ": " + monthCounts[i] + " late deliveries");
            }
        }
        System.out.println();
    }

    public static void numOfSingleCylinders(Delivery[] obj) {
        System.out.println("----------Single Cylinder Holders----------");
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null && obj[i].numOfCylinders == 1) {
                System.out.println("* Customer Name: " + obj[i].name);
                System.out.println("* Mobile No.: " + obj[i].mobile);
                System.out.println("* Gas Connection No.: " + (i + 101));
            }
        }
        System.out.println();
    }

    public static void deliveryDetails(Delivery[] obj) {
        System.out.println("--------------Delivery Details--------------");
        System.out.print("Enter the name of delivery person: ");
        Scanner sc = new Scanner(System.in);
        String dpname = sc.nextLine();

        for (Delivery delivery : obj) {
            if (delivery != null && "D".equals(delivery.status) && dpname.equalsIgnoreCase(delivery.delPersonName)) {
                System.out.println("* Customer Name: " + delivery.name);
                System.out.println(" - " + delivery.street + ", " + delivery.area + ", " + delivery.pincode);
            }
        }
        System.out.println();
    }

    public static void printReport(Delivery[] obj) {
        for (Delivery d : obj) {
            if (d == null || d.status == null) continue;
            switch (d.status) {
                case "B":
                    bcount++;
                case "D":
                    dcount++;
                case "C":
                    ccount++;
                case "P":
                    pcount++;
            }
        }

        System.out.println("-------------Delivery Report-------------");
        System.out.println("* Booked    : " + bcount);
        System.out.println("* Delivered : " + dcount);
        System.out.println("* Cancelled : " + ccount);
        System.out.println("* Pending   : " + pcount);
        System.out.println();
    }

    public static void printInvoice(Delivery[] obj) {
        System.out.println("-------------INVOICES-------------");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate = sdf.format(new Date());

        for (int i = 0; i < obj.length; i++) {
            Delivery d = obj[i];
            if (d != null && "D".equals(d.status)) {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println(" INVOICE ");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Gas Agency Code: 1234\t\t\t Date of Invoice: " + invoiceDate);
                System.out.println("Gas Agency Name: Indian Gas\t\t Agency Phone No: 12345");
                System.out.println("Gas Connection No.: " + (i + 101) + "\t\t\t Customer Name: " + d.name);
                System.out.println("Booking Date: " + sdf.format(d.dt_1) + "\t Customer Mobile: " + d.mobile);
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Amount: " + (d.amt + d.refund));
                System.out.println("Refund: " + d.refund);
                System.out.println("Total Amount: " + d.amt);
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Delivery Person: " + d.delPersonName + "\t Delivery Mobile: " + d.DelMobile);
                System.out.println("Delivery Date: " + sdf.format(d.dt_2));
                System.out.println("-------------------------------------------------------------------------------\n");
            }
        }
    }
}
