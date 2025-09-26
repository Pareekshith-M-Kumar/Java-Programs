package gasSupplier;

public interface gasAgency {
    String agencyName = "Indian Gas";
    int agencyCode = 1234;
    int phno = 12345;
    int pinCode = 234567;

    default void agencyDisplay() {
        System.out.println("The agency name is: " + agencyName);
        System.out.println("The agency code is: " + agencyCode);
        System.out.println("The agency phone number is: " + phno);
    }
}
