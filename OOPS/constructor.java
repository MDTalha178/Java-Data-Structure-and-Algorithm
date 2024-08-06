public class constructor {
    public static void main(String args[]){

        // object
        School sc = new School("St. Xavier's High School", "Ailwal Azamagarh",120);
        sc.get_details();

        // copy constructor
        School sc1 = new School(sc);
        sc1.get_details();
        sc.school_name = "Joyti";
        System.out.println(sc1.school_name);
        System.out.println(sc.school_name);


    }
}

class School{
    String school_name;
    String school_address;
    int school_rank;
    private int total_student = 1200;

    // not paramitarized constructor
    School(){
        System.out.println("Here are the school details");
    }

    // paramaterized constructory
    School(String school_name, String school_address, int school_rank){
        this.school_address = school_address;
        this.school_name = school_name;
        this.school_rank = school_rank;
    }

    // copy constructor
    School(School sc){
        this.school_name = sc.school_name;
        this.school_address = sc.school_address;
        this.school_rank = sc.school_rank;
    }

    void get_details(){
        // System.out.println("Here are the school details");
        System.out.println("School name is: " + school_name);
        System.out.println("School Address is : " + school_address);
        System.out.println("School rank is: " + school_rank);
        System.out.println("Total Student in the School: " + total_student);
    }
}
