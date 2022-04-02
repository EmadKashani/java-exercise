package tamrinkelasi;

public class Takelasi {

    public static void main(String[] args) {

        Person human = new Person();

        human.setName("emad");
        human.setFamily("kashani");
        human.setAge(19);
        human.setJob("student");
        human.setUsername("user e.k");
        human.setPassword(12345);

        System.out.println("name= "+ human.getName());
        System.out.println("family name= "+ human.getFamily());
        System.out.println("age= "+ human.getAge());
        System.out.println("job= "+ human.getJob());
        System.out.println("username= "+ human.getUsername());
        System.out.println("password= "+ human.getPassword());



    }

}
