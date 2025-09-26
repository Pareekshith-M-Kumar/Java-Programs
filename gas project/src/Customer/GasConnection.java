package Customer;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer {
    public int numOfCylinders;
    public Date lastDate = null;
    public String date;
    static int connectionNumber = 100;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String pincode, String mobile, int numOfCylinders) {
        super(name, street, area, pincode, mobile);
        this.numOfCylinders = numOfCylinders;
        connectionNumber++;
    }

    public void getLastDate() {
        System.out.println("Enter the last date (dd/MM/yyyy): ");
        Scanner sc = new Scanner(System.in);
        date = sc.next();
        try {
            lastDate = dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("Error parsing last date: " + e.getMessage());
            lastDate = new Date(); // fallback to current
        }
    }
}
