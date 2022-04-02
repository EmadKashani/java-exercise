package tamrin3;

public class MyStudent<NUMBER,NAME,FATHER> {

    private NUMBER number ;
    private NAME name ;
    private FATHER fatherName ;

    public NUMBER getNumber() {
        return number;
    }

    public void setNumber(NUMBER number) {
        this.number = number;
    }

    public NAME getName() {
        return name;
    }

    public void setName(NAME name) {
        this.name = name;
    }

    public FATHER getFatherName() {
        return fatherName;
    }

    public void setFatherName(FATHER fatherName) {
        this.fatherName = fatherName;
    }

}
