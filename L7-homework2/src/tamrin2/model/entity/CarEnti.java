package tamrin2.model.entity;

public class CarEnti {

    private long id , salary;
    private String name;



    public long getId() {
        return id;
    }

    public CarEnti setId(long id) {
        this.id = id;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public CarEnti setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public String getName() {
        return name;
    }

    public CarEnti setName(String name) {
        this.name = name;
        return this;
    }

}
