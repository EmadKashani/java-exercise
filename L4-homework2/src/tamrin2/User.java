package tamrin2;

import java.util.Scanner;

public class User<Person> implements Cloneable{

    private Person name,family,age;

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }


    public Person getName() {
        return name;
    }

    public void setName(Person name) {
        this.name = name;
    }

    public Person getFamily() {
        return family;
    }

    public void setFamily(Person family) {
        this.family = family;
    }

    public Person getAge() {
        return age;
    }

    public void setAge(Person age) {
        this.age = age;
    }
}
