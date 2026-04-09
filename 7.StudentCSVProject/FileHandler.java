import java.io.*;
import java.util.*;

public class FileHandler {

    static String fileName = "Students.csv";

    public static void createFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");
            bw.write("101,Amit,CSE,80,75,70,85,90,0\n");
            bw.write("102,Riya,IT,78,82,88,76,80,0\n");

            System.out.println("File created successfully.");

        } catch (IOException e) {
            System.out.println("Error creating file: " + e);
        }
    }

    public static void writeStudents(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");

            for (Student s : students) {
                bw.write(s.toCSV() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e);
        }
    }

    public static List<Student> readStudents() {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                Student s = new Student(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Integer.parseInt(d[3]),
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5]),
                        Integer.parseInt(d[6]),
                        Integer.parseInt(d[7])
                );

                s.percentage = Double.parseDouble(d[8]);
                list.add(s);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }

        return list;
    }

    public static void display() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            System.out.println("\n--- File Content ---");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error displaying file: " + e);
        }
    }
}