package hotel.reserveRooms;

public class RREntity {

    private  int roomNo;//extra added
    private String nationalCode;//meli code
    private  String pFullName;//passenger's full name
    private  String mobileNo;
    private int initialPay;
    private int reservationDays;
    private  String reservationDateTime;

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
