package Data.Lib;

public class Date {
    private int day;
    private int month;
    private int year;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY= 5;
    private static final int JUNE = 6;
    private static final int JUNLY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMPER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public Date(String date) { // date must like 1/1/2021 or 1-1-2021 (dd/mm/yyyy)
        String arrDate[] = date.split("[/-]");
        int day = Integer.parseInt(arrDate[0]);
        int month = Integer.parseInt(arrDate[1]);
        int year = Integer.parseInt(arrDate[2]);
    
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return this.month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return this.day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    @Override 
    public String toString(){
        return this.day + "/" + this.month + "/" + this.year;
    }
    public static boolean isLeapYear(int year){
        if ((year % 4 == 0 && year % 100 == 0) || (year % 400 == 0)) return true;
        return false;
    }
    public static boolean isTrue(int day, int month, int year){
        if (day <= 0 && (month <= 0 || month > 12) && year < 0) return false;
        if (dayOfMonth(month, year) < day) return false;
        return true;
    }
    public static boolean isTrue(String date){
        String arrDate[] = date.split("[/-]");
        try {
            arrDate[4] = null;
            return false;
        } catch (Exception e) {}
        try {
            int day = Integer.parseInt(arrDate[0]);
            int month = Integer.parseInt(arrDate[1]);
            int year = Integer.parseInt(arrDate[2]);
            return isTrue(day, month, year);
        } catch (Exception e) {
            return false;
        }
        
    }
    private static int dayOfMonth(int month, int year){
        try {
            switch (month){
                case JANUARY:
                case MARCH:
                case MAY:
                case JUNLY:
                case AUGUST:
                case OCTOBER:
                case DECEMBER:
                    return 31;
                case APRIL:
                case JUNE:
                case SEPTEMPER:
                case NOVEMBER:
                    return 30;
                case FEBRUARY:
                    if (isLeapYear(year)) return 29;
                    return 28;
                default: throw new Error();
            }
        } catch (Error e) {
            System.out.println("Wrong month!");
            return 0;
        }
        
    }
}
