import java.io.*;

public class MainApp {

    public static void main(String[] args) {

        FileHandler.createFile();      // CREATE
        FileHandler.display();

        StudentService.addStudents();  // INSERT
        FileHandler.display();

        StudentService.updateStudents(); // UPDATE
        FileHandler.display();

        StudentService.deleteStudent(104); // DELETE
        FileHandler.display();

        // Exception demonstration
        try {
            BufferedReader br = new BufferedReader(new FileReader("WrongFile.csv"));
        } catch (IOException e) {
            System.out.println("\nException caught: " + e);
        }
    }
}