public class Date {
    private int day, month, year;
    private final static int[] daysOfMonths ={31,28,31,30,31,30,31,31,30,31,30,31};

    public Date(String date, String month, String year) {
        this.day = Integer.parseInt(date);
        this.month = Integer.parseInt(month);
        this.year = Integer.parseInt(year);
    }
    //A function to calculate week
    public int getWeek(Date date){
        if (this.month == date.getMonth()) //Months equal
            return Math.abs((this.day - date.getDate()) / 7);
        else //Finish month is bigger
            return Math.abs((date.day + daysOfMonths[this.month - 1] - this.day) / 7);
    }

    public int getDate() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getAll(){
        return day+"/"+month+"/"+year;
    }
    //A function to check dates if they are valid
    public boolean checkDate(){
        if (month > 12) return false;
        else if (month == 2 && year % 4 != 0 && day > 28) return false; //Check leap year
        else if (day > daysOfMonths[month - 1] && month != 2) return false;
        else return true;
    }
}
