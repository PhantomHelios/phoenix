public class Department {
    static class Instructor{
        private String title, name;
        private int id;
        private static int uniqueID = 1;

        public Instructor(String title, String name){
            this.name = name;
            this.title = title;
            id = uniqueID;
            uniqueID++;
        }

        public String getTitle() {
            return title;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    static class Training{
        private String type;
        private int week;

        public Training(String type, int week){
            this.type = type;
            this.week = week;
        }

        public String getType() {
            return type;
        }

        public int getWeek() {
            return week;
        }
    }

    private String code, name;
    private Instructor[] instructors = new Instructor[3];
    private Training[] trainings = new Training[3];

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void addInstructors(String title_1, String instructor_1,String title_2, String instructor_2,String title_3, String instructor_3){
        instructors[0] = new Instructor(title_1, instructor_1);
        instructors[1] = new Instructor(title_2,instructor_2);
        instructors[2] = new Instructor(title_3,instructor_3);
    }

    public void writeInstructors(){
        System.out.println("Department: " + this.name);
        for (int i = 0; i < 3 ; i++)
            System.out.println("ID:" + instructors[i].getId() + " " + instructors[i].getTitle() + " " + instructors[i].getName());
        System.out.println();
    }

    public void addTrainings(String training_1, String week_1,String training_2, String week_2,String training_3, String week_3){
        trainings[0] = new Training(training_1,Integer.parseInt(week_1));
        trainings[1] = new Training(training_2,Integer.parseInt(week_2));
        trainings[2] = new Training(training_3,Integer.parseInt(week_3));
    }

    public void writeTrainings(){
        for (int i = 0; i < 3 ; i++)
            System.out.println(trainings[i].getType() + " : " + trainings[i].getWeek() + " weeks");
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
