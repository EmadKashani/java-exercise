package hotel.rooms;

public class RoomEnti {
    private long id;// id otagh
    private  int salary;// gheymat otagh
    private int code;//room code
    private  static int number;//zarfiat otagh
    private static String type;// vip or normal
    private static String facilities;// room view

    public RoomEnti(){}
    public RoomEnti(String chtype,String chFacil,int chnum){
        this.type = chtype;
        this.facilities = chFacil;
        this.number = chnum;
    }


    public long getId() {
        return id;
    }

    public RoomEnti setId(long id) {
        this.id = id;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public RoomEnti setNumber(int number) {
        this.number = number;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public RoomEnti setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RoomEnti setCode(int code) {
        this.code = code;
        return this;
    }

    public String getType() {
        return type;
    }

    public RoomEnti setType(String type) {
        this.type = type;
        return this;
    }

    public String getFacilities() {
        return facilities;
    }

    public RoomEnti setFacilities(String facilities) {
        this.facilities = facilities;
        return this;
    }

}
