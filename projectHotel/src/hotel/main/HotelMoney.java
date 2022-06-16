package hotel.main;

public class HotelMoney {

    private static long income;

    public HotelMoney(){}
    public HotelMoney(long hotelmoney){
        this.income = hotelmoney;
    }

    public long getIncome() {
        return income;
    }

    public HotelMoney setIncome(long income) {
        this.income = income;
        return this;
    }

}
