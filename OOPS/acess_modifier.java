public class acess_modifier {
    public static void main(String args[]){
        Student s1 = new Student();
        s1.name = "talha";
        s1.branch ="CSE";
        s1.roll = 12;
        s1.registrationNumber = 12345;
        s1.setPassword();
        System.out.println(s1.roll);
        System.out.println(s1.getPasswrod());

    }
}

class Student{
    String name;
    String branch;
    protected int roll;
    int registrationNumber;
    private String password;

    void setPassword(){
        this.password = this.name + this.branch + "1231";
    }

    String getPasswrod(){
        return this.password;
    }


}
