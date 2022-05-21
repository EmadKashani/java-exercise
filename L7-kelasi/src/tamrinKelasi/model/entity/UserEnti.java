package tamrinKelasi.model.entity;

public class UserEnti {

    private long id;
    private String username,password,name,email;

    public UserEnti(){}


    public long getId() {
        return id;
    }

    public UserEnti setId(long id) {
        this.id = id;
        return this;
    }

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

    public String getName() {
        return name;
    }

    public UserEnti setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEnti setEmail(String email) {
        this.email = email;
        return this;
    }


}
