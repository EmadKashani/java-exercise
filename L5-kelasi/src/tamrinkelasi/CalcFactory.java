package tamrinkelasi;

public class CalcFactory {

    public static Calculation getCalc(char a){
        switch (a)
        {
            case '+':
                return new CalcPlus();
            case '-':
                return new CalcMinus();
            default:
                return null;
        }

    }

}
