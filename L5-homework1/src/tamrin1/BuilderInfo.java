package tamrin1;

import java.util.Scanner;

public class BuilderInfo {

    private String name;
    private int age;
    private String address;
    private  int number;
    private String education;
    private String username;
    private String password;

    Scanner scanner = new Scanner(System.in);


    public BuilderInfo setName(String name) {
        this.name = name;
        return this;
    }

    public BuilderInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public BuilderInfo setNumber(int number) {
        this.number = number;
        return this;
    }

    public BuilderInfo setEducation(String education) {
        this.education = education;
        return this;
    }

    public BuilderInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public BuilderInfo setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public String getEducation() {
        return education;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    //end
}
