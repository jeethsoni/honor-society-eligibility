import com.honorsociety.Graduate;
import com.honorsociety.Student;
import com.honorsociety.Undergraduate;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Read student data from a file
 * Computes the GPA threshold
 * prints the students that are eligible for the honor membership
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        double gpaTotal = 0.0;
        double threshold;
        double avgGpa;
        Student gradStudent, undergradStudent;

        try {
            // Create a file object and scanner for reading the file
            File file = new File("students.txt");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                // store file content in a list
                String data = scanner.nextLine();
                String[] values = data.split(" ");

                // parsing the file content
                String name = values[0];
                int credit = Integer.parseInt(values[1]);
                int points = Integer.parseInt(values[2]);
                String schoolYear = values[3];

                // Creating appropriate student object and storing it in arraylist
                if (schoolYear.equals("Masters") || schoolYear.equals("Doctorate")) {
                    gradStudent = new Graduate(name, credit, points, schoolYear);
                    students.add(gradStudent);
                }else{
                    undergradStudent = new Undergraduate(name, credit, points, schoolYear);
                    students.add(undergradStudent);
                }
            }

            // adding each student gpa to gpaTotal
            for (Student value: students){
                gpaTotal += value.gpa();
            }

            // calculating average gpa and threshold
            avgGpa = (gpaTotal / students.size());
            threshold = (avgGpa + 4.0) / 2.0;

            // two numbers after decimal point
            DecimalFormat df = new DecimalFormat("#.##");
            double roundedThreshold = Double.parseDouble(df.format(threshold));

            // Setting the gpa threshold
            double eligibleGpa = Student.setGpaThreshold(roundedThreshold);
            System.out.println("GPA threshold for membership is " + eligibleGpa);

            // Printing student that are eligible for honor society
            for (Student stu: students){
                if(stu.eligibleForHonorSociety()){
                    System.out.println(stu);
                }
            }

            scanner.close();

        }catch (FileNotFoundException e){
            System.out.println("No file found");  // print if no file found
        }
    }

}
