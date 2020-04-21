public class Student {
    private int number, s_class;
    private String name, gender, department_code;
    Date birthday;
    Phone phone;

    public Student(String department_code, String number, String s_class, String name, String gender, Date birthday, Phone phone) {
        this.department_code = department_code;
        this.number = Integer.parseInt(number);
        this.s_class = Integer.parseInt(s_class);
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
    }
    //Second constructor to compare and prevent NullPointer error
    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAllInfo(){
        return "Department Code: "+department_code+" - Class: "+s_class+" - Gender: "+gender+"\n"+
                "Name: "+name+" - Student No: "+number+"\n" +
                "Birthday: "+ birthday.getAll()+" - Phone: "+phone.getPhoneNumber();
    }
}
