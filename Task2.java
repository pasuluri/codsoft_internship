import java.util.Scanner;

class Task2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter marks obtained (out of 100) in each subject:");
    System.out.print("Subject 1: ");
    float subject1 = scanner.nextFloat();
    System.out.print("Subject 2: ");
    float subject2 = scanner.nextFloat();
    System.out.print("Subject 3: ");
    float subject3 = scanner.nextFloat();
    System.out.print("Subject 4: ");
    float subject4 = scanner.nextFloat();
    System.out.print("Subject 5: ");
    float subject5 = scanner.nextFloat();
    scanner.close();

    float totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
    float averagePercentage = (float) ((totalMarks / 500.0) * 100);
    String grade;

    if (averagePercentage >= 90) {
      grade = "A";
    } else if (averagePercentage >= 80) {
      grade = "B";
    } else if (averagePercentage >= 70) {
      grade = "C";
    } else if (averagePercentage >= 60) {
      grade = "D";
    } else {
      grade = "F";
    }

    System.out.println("Total marks: " + totalMarks);
    System.out.println("Average percentage: " + averagePercentage + "%");
    System.out.println("Grade: " + grade);
  }
}
