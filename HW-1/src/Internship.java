public class Internship {
    private int id, student_number, week;
    private String department_code, internship_type, company_name;
    private Date start_date, end_date;
    private static int internshipID = 1;

    public Internship(String student_number, String department_code, String internship_type, String company_name, Date start_date, Date end_date) {
        this.student_number = Integer.parseInt(student_number);
        this.company_name = company_name;
        this.department_code = department_code;
        this.internship_type = internship_type;
        this.start_date = start_date;
        this.end_date = end_date;
        week = start_date.getWeek(end_date); //Calculate week
        id = internshipID;
        internshipID++;
    }

    public String getInternshipInformation(){
        return "Internship ID: "+id+"\n"+
                "Department: "+department_code+" - "+"Student No: "+student_number+
                "\nCompany: "+company_name+" - Internship Type: "+internship_type+
                "\nStart: "+start_date.getAll()+" - Finish: "+end_date.getAll()+" - "+week+" weeks";
    }
}
