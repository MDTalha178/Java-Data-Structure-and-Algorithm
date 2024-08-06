public class multilevel_inheritance {

    /*
+     * This is the main function of the multilevel_inheritance class.
+     * It is the entry point of the program.
+     * 
+     * This function creates an instance of the Student class and initializes it with various parameters.
+     * It then calls various methods on the Student instance to display the student's details, collage details,
+     * courses offered, and affilation details.
+     * 
+     * @param args - an array of strings that contains command line arguments
+     */
    public static void main(String args[]){
        // Define an array of strings to store the courses offered
        String course[] = {"Computer Science", "Mechanical Eng", "Electrical Eng.."};
        // Create an instance of the Student class and initialize it with various parameters
        Student s = new Student("MD Talha", "Delhi Freinds Colony", 24, 1222, 2022, "CSE", "Galgogias University", "Noida", course, 1222);
       // Call the get_student_details method to display the student's details
        s.get_student_details();
       
        // Call the get_collage_details method to display the student's collage details
        s.get_collage_details();
        
        // Call the courses method to display the courses offered
        s.courses();
        
        // Call the affilation_details method to display the affilation details
        s.affilation_details();
     }
}


/**
+ * This class represents a college affiliation. It contains the details of the college that is affiliated with
+ * another university.
+ */
class CollageAffilation{
    /**
+     * The name of the university that the college is affiliated with.
+     */
    String universiy_affilation;
    /**
+     * The address of the university that the college is affiliated with.
+     */
     String affilation_university_address;
 
    /**
+     * Constructs a new instance of the CollageAffilation class.
+     *
+     * @param universiy_affilation The name of the university that the college is affiliated with.
+     * @param affilation_university_address The address of the university that the college is affiliated with.
+     */
     CollageAffilation(String universiy_affilation, String affilation_university_address){
        this.universiy_affilation = universiy_affilation;
        this.affilation_university_address = affilation_university_address;
 
     }
 
    /**
+     * Displays the details of the college affiliation.
+     */
     void affilation_details(){
         System.out.println("Collage is Affilated to: " + this.universiy_affilation);
         System.out.println("Collage affilation address is: " + this.affilation_university_address);
     }
}


/**
+ * This class represents a college. It extends the CollageAffilation class and contains the details of the college.
+ * It also contains the details of the university that the college is affiliated with.
+ */
 class Collage extends CollageAffilation{
    // The name of the college
     String collage_name;
    // The address of the college
     String collage_address;
    // The courses offered by the college
     String courses[];
    // The number of the college
     protected int collage_number;
 
    /**
+     * Constructs a new instance of the Collage class.
+     *
+     * @param collage_name The name of the college.
+     * @param collage_address The address of the college.
+     * @param courses The courses offered by the college.
+     * @param collage_number The number of the college.
+     * @param universiy_affilation The name of the university that the college is affiliated with.
+     * @param affilation_university_address The address of the university that the college is affiliated with.
+     */
     Collage(String collage_name, String collage_address, String courses[], int collage_number, String universiy_affilation, String affilation_university_address){
         super(universiy_affilation, affilation_university_address);
         this.collage_name = collage_name;
         this.collage_address = collage_address;
         this.collage_number = collage_number;
         this.courses = new String[3];
         for(int i = 0; i<3; i++){
             this.courses[i] = courses[i];
         }
     }
 
    /**
+     * Displays the details of the college.
+     */
     void get_collage_details(){
         System.out.println("Collage name is: "+ this.collage_name);
         System.out.println("Collage Address is: "+ this.collage_address);
         System.out.println("Collage Number is: "+ this.collage_number);
     }
    /**
+     * Displays the courses offered by the college.
+     */
     void courses(){
         for(int i=0; i<3; i++){
             System.out.println(i+1 + ": " + this.courses[i]);
         }
     }
 }


/**
+ * This class represents a student. It extends the Collage class and contains the details of the student.
+ * It also contains the details of the college that the student is enrolled in.
+ */
 class Student extends Collage{
     String student_name;
     String address;
     int age;
     int roll_number;
     int batch;
     String branch;
 
 
    /**
+     * Constructs a new instance of the Student class.
+     *
+     * @param student_name The name of the student.
+     * @param address The address of the student.
+     * @param age The age of the student.
+     * @param roll The roll number of the student.
+     * @param batch The batch number of the student.
+     * @param branch The branch of the student.
+     * @param collage_name The name of the college.
+     * @param collage_address The address of the college.
+     * @param courses The courses offered by the college.
+     * @param collage_number The number of the college.
+     */
     Student(String student_name, String address, int age, int roll, int batch, String branch, String collage_name, String collage_address, String courses[], int collage_number){
        super(collage_name, collage_address, courses, collage_number, "Galgotias University", "Lucknow");
        this.student_name = student_name;
        this.address = address;
        this.age = age;
        this.batch = batch;
        this.branch = branch;
        this.roll_number = roll;
     }
   /**
+     * Displays the details of the student.
+     */
     void get_student_details(){
        System.out.println("Student name is: "+ this.student_name);
        System.out.println("Studen Address is: "+ this.address);
        System.out.println("Student age is: "+ this.age);
        System.out.println("Student Batch is: "+ this.batch);
        System.out.println("Student Roll Number is: "+ this.roll_number);
        System.out.println("Student Branch is: "+ this.branch);
 
    }   
}


