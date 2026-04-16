import java.util.*;

public class StudentService {

    public static void addStudents() {
        List<Student> students = FileHandler.readStudents();

        students.add(new Student(103, "Arjun", "ECE", 70, 65, 60, 0, 0));
        students.add(new Student(104, "Neha", "MECH", 88, 77, 66, 0, 0));
        students.add(new Student(105, "Karan", "CIVIL", 90, 85, 80, 0, 0));

        FileHandler.writeStudents(students);
        System.out.println("3 students added.");
    }

    public static void updateStudents() {
        List<Student> students = FileHandler.readStudents();

        for (Student s : students) {
            if (s.m4 == 0 && s.m5 == 0) {
                s.m4 = 75;
                s.m5 = 80;
            }
            s.calculatePercentage();
        }

        FileHandler.writeStudents(students);
        System.out.println("Students updated.");
    }

    public static void deleteStudent(int id) {
        List<Student> students = FileHandler.readStudents();

        students.removeIf(s -> s.studentId == id);

        FileHandler.writeStudents(students);
        System.out.println("Student deleted: " + id);
    }
}