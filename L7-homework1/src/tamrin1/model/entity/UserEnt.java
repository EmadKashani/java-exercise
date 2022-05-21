package tamrin1.model.entity;

public class UserEnt {

    private long id,salary,data;
    private String username;
    private String password;


    public long getId() {
        return id;
    }

    public UserEnt setId(long id) {
        this.id = id;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public UserEnt setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public long getData() {
        return data;
    }

    public UserEnt setData(long data) {
        this.data = data;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEnt setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEnt setPassword(String password) {
        this.password = password;
        return this;
    }

}
