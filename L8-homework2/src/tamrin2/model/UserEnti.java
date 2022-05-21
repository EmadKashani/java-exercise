package tamrin2.model;

public class UserEnti {

    private long id,age;
    private String name,username,password;


    public String getUsername() {
        return username;
    }

    public UserEnti setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEnti setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getId() {
        return id;
    }

    public UserEnti setId(long id) {
        this.id = id;
        return this;
    }

    public long getAge() {
        return age;
    }

    public UserEnti setAge(long age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEnti setName(String name) {
        this.name = name;
        return this;
    }

}
