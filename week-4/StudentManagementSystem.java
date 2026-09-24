import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        if (marks < 0 || marks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            break;
                        }

                        Student student =
                                new Student(id, name, course, marks);

                        dao.addStudent(student);

                        break;

                    case 2:

                        dao.viewStudents();

                        break;

                    case 3:

                        System.out.print("Enter Student ID to update: ");
                        int updateId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks =
                                Double.parseDouble(sc.nextLine());

                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            break;
                        }

                        Student updatedStudent =
                                new Student(
                                        updateId,
                                        newName,
                                        newCourse,
                                        newMarks
                                );

                        dao.updateStudent(updatedStudent);

                        break;

                    case 4:

                        System.out.print("Enter Student ID to delete: ");
                        int deleteId =
                                Integer.parseInt(sc.nextLine());

                        dao.deleteStudent(deleteId);

                        break;

                    case 5:

                        System.out.println(
                            "Thank you for using Student Management System!"
                        );

                        sc.close();
                        return;

                    default:

                        System.out.println(
                            "Invalid choice. Please enter 1-5."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input! Please enter the correct data."
                );

            } catch (Exception e) {

                System.out.println(
                    "Something went wrong: " + e.getMessage()
                );
            }
        }
    }
}