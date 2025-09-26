package gasBooking;

import Customer.GasConnection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {
    public double otp = 2727, amt = 850.0, refund = 0.0;
    public String delDate, status = "", DelMobile = "947823982", dt;
    public Date dt_1 = null, dt_2 = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Booking(String name, String street, String area, String pincode, String mobile, int numOfCylinders) {
        super(name, street, area, pincode, mobile, numOfCylinders);
    }

    public void getDates() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Booking Date (dd/MM/yyyy): ");
        dt = sc.next();
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println("Error parsing booking date: " + e.getMessage());
        }

        System.out.print("Enter Delivery Date (dd/MM/yyyy): ");
        delDate = sc.next();
        try {
            dt_2 = dateFormat.parse(delDate);
        } catch (Exception e) {
            System.out.println("Error parsing delivery date: " + e.getMessage());
        }

        if (dt_1 != null && dt_2 != null) {
            long diff = dt_2.getTime() - dt_1.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (days > 7) status = "P"; // pending
        }
    }

    public void validate() {
        if (dt_1 == null || lastDate == null) {
            System.out.println("Missing dates for validation.");
            status = "C";
            return;
        }

        long elapsedms = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

        if (numOfCylinders == 1 && diff < 30 || numOfCylinders == 2 && diff < 50) {
            System.out.println("Booking cannot be done");
            status = "C";
        } else {
            status = "B";
            lastDate = dt_1;
        }
    }
}
