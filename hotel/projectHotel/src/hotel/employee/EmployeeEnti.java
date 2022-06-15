package hotel.employee;

public class EmployeeEnti {

    //state
    private int idNumber;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String place;
    private static String uname;
    private String pword;
    private int salary;

    public EmployeeEnti(){}
    public EmployeeEnti(String checkUname){
        this.uname = checkUname;
    }

    //getter/setter

    public int getIdNumber() {
        return idNumber;
    }

    public EmployeeEnti setIdNumber(int idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public EmployeeEnti setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EmployeeEnti setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeEnti setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public EmployeeEnti setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getUname() {
        return uname;
    }

    public EmployeeEnti setUname(String uname) {
        this.uname = uname;
        return this;
    }

    public String getPword() {
        return pword;
    }

    public EmployeeEnti setPword(String pword) {
        this.pword = pword;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeeEnti setSalary(int salary) {
        this.salary = salary;
        return this;
    }

}
