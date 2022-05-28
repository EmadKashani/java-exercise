package rooms;

public class RoomEnti {

    private long id,number,salary,code;
    private String type,facilities;


    public long getId() {
        return id;
    }

    public RoomEnti setId(long id) {
        this.id = id;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public RoomEnti setNumber(long number) {
        this.number = number;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public RoomEnti setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public long getCode() {
        return code;
    }

    public RoomEnti setCode(long code) {
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
