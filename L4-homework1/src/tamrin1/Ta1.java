package tamrin1;

import java.util.*;

public class Ta1 {

    public static void main(String[] args) {


        Student st1 = new Student();
        st1.setName("emad");
        st1.setNumber(12345);
        st1.setScore(17);


        Map map = new TreeMap();
        map.put("name",st1.getName());
        map.put("number",st1.getNumber());
        map.put("score",st1.getScore());

        System.out.println("your result (name,number,score) :");
        Collection result = map.values();
        for (Object t : result){
            System.out.println(t);
        }

    }
}
