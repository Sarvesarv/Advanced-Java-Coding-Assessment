import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fetch student details from user input (View responsibility)
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        scanner.close();
        Student model = new Student();
        StudentController controller = new StudentController(model);
        controller.setStudentId(id);
        controller.setStudentName(name);
        controller.setStudentCourse(course);
        controller.updateView();
    }
}