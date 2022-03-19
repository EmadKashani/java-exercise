package tamrinkelasi1;

public class Books {
    String name;
    String subject;
    int pages;



    public void giveback(){
        System.out.println(name +" book with " + subject +" subject and "+ pages +"pages just returne");
    }


    public void take(){
        System.out.println(name +" book with " + subject +" subject and "+ pages +"pages just took");
    }

}
