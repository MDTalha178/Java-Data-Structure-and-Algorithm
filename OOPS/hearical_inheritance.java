public class hearical_inheritance {
    public static void main(String args[]){
        StudenDetails st = new StudenDetails("Md Talha", "Okhla Delhi", 21, 70812, 122, "Aksah Library", "Sukhdev vihar", 89976, 123);
        st.get_student_details(124);
        st.set_student_pin(1234);
        st.get_student_details(124);
        st.get_student_details(1234);
        st.set_student_pin(1234);
        st.get_librarty_details();
    }
}

class Libraries{
    String name;
    String Address;
    int contact;
    int number_of_seats;

    Libraries(String name, String address, int contact, int number_of_seats){
        this.name = name;
        this.Address = address;
        this.contact = contact;
        this.number_of_seats = number_of_seats;
    }

    void get_librarty_details(){
        System.out.println("Library name is: " + this.name);
        System.out.println("Library Address is: " + this.Address);
        System.out.println("Library Contact number is: " + this.contact);
        System.out.println("Library number of seats is: " + this.number_of_seats);
    }
}

class LibrariesAssets extends Libraries{
    int number_of_book_blocks;
    int number_of_chair;
    int timing;

    LibrariesAssets(int number_of_book_blocks, int number_of_chair, int timing, String name, String address, int contact, String nnumber_of_chair){
        super(name, address, contact, number_of_chair);
        this.number_of_book_blocks = number_of_book_blocks;
        this.number_of_chair = number_of_chair;
        this.timing = timing;
    }
}


class StudenDetails extends Libraries{
    String student_name;
    String student_address;
    int age;
    int student_phone_number;
    int seat_allot_number;
    private int student_pin =0;

    StudenDetails(String student_name, String student_address, int age, int student_phone_number, int seat_allot_number, String name, String address, int contact, int number_of_seats){
        super(name, address, contact, number_of_seats);
        this.student_name =  name;
        this.student_address = student_address;
        this.student_phone_number = student_phone_number;
        this.seat_allot_number = seat_allot_number;
    }

    void get_student_details(int student_pin){
        if(this.student_pin == 0){
            System.out.println("First Please set your pin to access your details");
        }
        else{
            if(this.student_pin == student_pin){
                System.out.println("Student name is: " + this.student_name);
                System.out.println("Student address is: " + this.student_address);
                System.out.println("Student Age is: " + this.age);
                System.out.println("Student student phone number is: " + this.student_phone_number);
                System.out.println("Student seat Allot number is: " + this.student_phone_number);
            }
            else{
                System.out.println("OOPS... Pin is Invalid");
            }
        }
        
    }
    void set_student_pin(int student_pin){
        if(this.student_pin == 0){
            this.student_pin = student_pin;
        }
        else{
            System.out.println("Opps Your Pin have been already set!");
        }
    }
}
