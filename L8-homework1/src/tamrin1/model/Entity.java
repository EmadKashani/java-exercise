package tamrin1.model;

public class Entity {
    private long id;
    private String firstName,lastName,university,education;


    public long getId() {
        return id;
    }

    public Entity setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Entity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Entity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUniversity() {
        return university;
    }

    public Entity setUniversity(String university) {
        this.university = university;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public Entity setEducation(String education) {
        this.education = education;
        return this;
    }

}
