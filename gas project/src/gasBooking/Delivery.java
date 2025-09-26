package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking {
    public String delPersonName;
    public int customerOtp;

    public Delivery(String name, String street, String area, String pincode, String mobile, int numOfCylinders) {
        super(name, street, area, pincode, mobile, numOfCylinders);
    }

    public void amountCalc() {
        if (dt_1 != null && dt_2 != null) {
            long dayDiff = dt_2.getTime() - dt_1.getTime();
            long days = TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);
            if (days > 7) {
                refund = 41.25;
                amt -= refund;
            }
        }
    }

    public void verifyOtp() {
        if (!"B".equals(status)) {
            System.out.println("No valid booking found.");
            return;
        }

        System.out.print("Enter OTP: ");
        Scanner sc = new Scanner(System.in);
        customerOtp = sc.nextInt();

        if (customerOtp != otp) {
            status = "C";
            System.out.println("OTP Incorrect. Booking Cancelled.");
        } else {
            status = "D";
            System.out.println("OTP Verified. Delivered.");
        }
    }

    public void setDelPersonName() {
        System.out.print("Enter delivery person name: ");
        delPersonName = new Scanner(System.in).nextLine();
    }
}
