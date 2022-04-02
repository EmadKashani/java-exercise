package tamrin3;

import java.util.ArrayList;
import java.util.List;

public class Ta3 {

    public static void main(String[] args) {

        MyStudent st = new MyStudent();
        st.setName("emad");
        st.setNumber(12345);
        st.setFatherName("kamran");

        List<String> list = new ArrayList<>();
        list.add("14");
        list.add("18");
        list.add("17");
        list.add("20");
        list.add("19");

        System.out.println("result :");

        System.out.println("the student's name= "+ st.getName());
        System.out.println("the student's number= "+ st.getNumber());
        System.out.println("the student's father name= "+ st.getFatherName());

        System.out.println("scores=");
        for (String m : list){
            System.out.println(m);
        }

    }
}
