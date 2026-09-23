class Student {
    String name;
    int rollNo;
    String course;

    void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
    }
}

public class StudentDemo {
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Vedika";
        s1.rollNo = 101;
        s1.course = "IT Engineering";

        s1.displayInfo();
    }
}