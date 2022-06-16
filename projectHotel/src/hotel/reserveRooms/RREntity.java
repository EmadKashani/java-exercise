package hotel.reserveRooms;

public class RREntity {

    private static int roomNo;// code otagh
    private static String nationalCode;
    private static String pFullName;
    private static String mobileNo;
    private static int initialPay;// pardakht avalie
    private static int reservationDays;//room days
    private  String reservationDateTime;// set reservetime ba tarikh laptop

    public RREntity(){}
    public RREntity(int roomcode , String codenation , String name , String phone , int firstpay , int resday)
    {
        this.roomNo=roomcode;
        this.nationalCode=codenation;
        this.pFullName=name;
        this.mobileNo=phone;
        this.initialPay=firstpay;
        this.reservationDays=resday;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public RREntity setRoomNo(int roomNo) {
        this.roomNo = roomNo;
        return  this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public RREntity setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return  this;
    }

    public String getpFullName() {
        return pFullName;
    }

    public RREntity setpFullName(String pFullName) {
        this.pFullName = pFullName;
        return this;

    }

    public String getMobileNo() {
        return mobileNo;
    }

    public RREntity setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this ;
    }

    public int getInitialPay() {
        return initialPay;
    }

    public RREntity setInitialPay(int initialPay) {
        this.initialPay = initialPay;
        return  this;
    }

    public int getReservationDays() {
        return reservationDays;
    }

    public RREntity setReservationDays(int reservationDays) {
        this.reservationDays = reservationDays;
        return this;
    }

    public String getReservationDateTime() {
        return reservationDateTime;
    }

    public RREntity setReservationDateTime(String reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
        return  this;
    }
}
