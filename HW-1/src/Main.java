import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/C:/Users/ikrhn/Desktop/hwtest.txt");
        Scanner file_scanner = new Scanner(file);
        //Flags to check if there exist a object or a wrong entry
        boolean company = false, student = false, internship = false;

        Company[] companies;
        Department[] departments;
        Student[] students;
        Internship[] internships;
        //integers to change indexes and define arrays
        int department_number = 0, internship_number = 0, company_index = 0, student_index = 0;
        //Count internships and departments
        while (file_scanner.hasNextLine()){
            String[] read = file_scanner.nextLine().split(",");
            if (read[0].equals("Department")) department_number++;
            else if (read[0].equals("Internship")) internship_number++;
        }
        //Read file again
        file_scanner = new Scanner(file);
        //Create object arrays
        departments = new Department[department_number];
        companies = new Company[internship_number]; //Create companies and students arrays by using internship number
        students = new Student[internship_number]; //to prevent memory occupation
        internships = new Internship[internship_number];
        //Create objects to compare and prevent error
        for (int i = 0; i < companies.length ; i++) {
            companies[i] = new Company("0");
            students[i] = new Student("0");
        }

        department_number = internship_number = 0;

        while (file_scanner.hasNextLine()) {
            String[] read = file_scanner.nextLine().split(",");
            //Add departments
            if (read[0].equals("Department")){
                departments[department_number] = new Department(read[1],read[2]);
                departments[department_number].addInstructors(read[3],read[4],read[5],read[6],read[7],read[8]);
                departments[department_number].addTrainings(read[9],read[10],read[11],read[12],read[13],read[14]);
                department_number++;
            }
            else if (read[0].equals("Internship")){
                //Check if there is department in  given internship in data
                for (int i = 0; i < departments.length ; i++)
                    if (departments[i].getCode().equals(read[1])){
                        internship = true;
                        break;
                    }
                //Crate dates to check
                        //internship start and finish dates                                          birthday
                String[] start = read[11].split("\\."), finish = read[12].split("\\."), date = read[4].split("\\.");
                Date start_date = new Date(start[0],start[1],start[2]), finish_date = new Date(finish[0],finish[1],finish[2]);
                Date birthday = new Date(date[0],date[1],date[2]);

                if (!internship) //Check internship flag
                    System.out.println("Department not found in data! Please check your entry " + read[3] + "\n");
                else if (!(start_date.checkDate() && finish_date.checkDate() && birthday.checkDate())) //Check given dates
                    System.out.println("Wrong date in entry for " + read[3] + "\n");
                else{
                    //Check if company is there in data
                    for (int i = 0; i < companies.length; i++)
                        if (companies[i].getName().equals(read[13])) {
                            companies[i].increaseInternships();

                            company = true;
                            break;
                        }
                    //Create company if it doesn't exist in data
                    if (!company) {
                        Company.Address address = new Company.Address(read[14], read[15], read[16], read[17], read[18]);
                        Phone phone = new Phone(read[19], read[20], read[21]);

                        companies[company_index] = new Company(read[13], read[22], read[23], address, phone);
                        companies[company_index].increaseInternships();

                        company_index++;
                        company = false;
                    }
                    //Check if student is there in data
                    for (int i = 0; i < students.length; i++)
                        if (students[i].getName().equals(read[3]))
                            student = true;
                    //Create student if he/she doesn't exist in data
                    if (!student) {
                        students[student_index] = new Student(read[1], read[2], read[6], read[3], read[5], birthday, new Phone(read[7], read[8], read[9]));
                        student_index++;
                        student = false;
                    }
                    //Finally create internship
                    internships[internship_number] = new Internship(read[2], read[1], read[10], read[13], start_date, finish_date);

                    internship_number++;
                    internship = false;
                }

            }
        }

        System.out.println("List of the Departments:");
        for (int i = 0; i < department_number ; i++) {
            System.out.println(departments[i].getCode() + " - " + departments[i].getName());
            departments[i].writeTrainings();
            System.out.println();
        }

        System.out.println("List of the Instructors:");
        for (int i = 0; i < department_number; i++)
            departments[i].writeInstructors();

        System.out.println("List of the Students:");
        for (int i = 0; i < student_index ; i++)
            System.out.println(students[i].getAllInfo()+"\n");

        System.out.println("List of the Companies:");
        for (int i = 0; i < company_index; i++)
            System.out.println(companies[i].getAllInfo()+"\n");

        System.out.println("List of the Internships:");
        for (int i = 0; i < internship_number; i++)
            System.out.println(internships[i].getInternshipInformation()+"\n");

        System.out.println("Top Company:");
        int top_index = 0, top_int = 0;
        for (int i = 0; i < 2 ; i++) {  //turn 2 times if there is two top company
            for (int j = 0; j < company_index; j++) {
                if (companies[j].getInternship_number() > top_int) {
                    top_int = companies[j].getInternship_number();
                    top_index = j;
                }
                else if(i == 1 && companies[j].getInternship_number() == top_int && j != top_index){ //in second time find second top company
                    top_int = companies[j].getInternship_number();
                    top_index = j;
                    System.out.println(companies[top_index].getName()+" - "+companies[top_index].getInternship_number()+" Internships");
                }
            }
            if(i == 0) System.out.println(companies[top_index].getName()+" - "+companies[top_index].getInternship_number()+" Internships"); //write first one
        }
    }
}
