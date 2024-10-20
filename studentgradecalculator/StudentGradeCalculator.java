
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        double[] scores = new double[numSubjects];
        
        // Input scores for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }
        
        // Calculate average score
        double average = calculateAverage(scores);
        
        // Determine grade
        char grade = determineGrade(average);
        
        // Output results
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
    
    // Method to calculate average
    private static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
    
    // Method to determine grade based on average
    private static char determineGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

