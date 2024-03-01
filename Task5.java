import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String toString() {
        return "Course Code: " + code + ", Title: " + title + ", Description: " + description + ", Capacity: " + capacity + ", Schedule: " + schedule;
    }
}

class Student {
    String id;
    String name;
    List<String> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Registered Courses: " + registeredCourses;
    }
}

public class Task5{
    static Map<String, Course> courseDatabase = new HashMap<>();
    static Map<String, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Add some sample courses
        courseDatabase.put("CSCI101", new Course("CSCI101", "Introduction to Programming", "Learn basic programming concepts", 50, "Mon/Wed/Fri 10:00-11:30"));
        courseDatabase.put("MATH202", new Course("MATH202", "Calculus II", "Advanced calculus course", 40, "Tue/Thu 13:00-14:30"));
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Course Registration System ===");
            System.out.println("1. List Courses");
            System.out.println("2. Register Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    removeStudent(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void listCourses() {
        System.out.println("\n=== Available Courses ===");
        for (Course course : courseDatabase.values()) {
            System.out.println(course);
        }
    }

    static void registerStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        Student student = new Student(id, name);
        
        System.out.println("\n=== Available Courses ===");
        for (Course course : courseDatabase.values()) {
            System.out.println(course);
        }
        
        System.out.print("Enter course code to register (or type 'done' to finish): ");
        String courseCode;
        while (!(courseCode = scanner.nextLine()).equals("done")) {
            if (courseDatabase.containsKey(courseCode)) {
                Course course = courseDatabase.get(courseCode);
                if (course.capacity > 0) {
                    course.capacity--;
                    student.registeredCourses.add(courseCode);
                    System.out.println("Registered for course: " + course.title);
                } else {
                    System.out.println("Sorry, course is full.");
                }
            } else {
                System.out.println("Invalid course code. Please try again.");
            }
            System.out.print("Enter course code to register (or type 'done' to finish): ");
        }
        
        studentDatabase.put(id, student);
    }

    static void removeStudent(Scanner scanner) {
        System.out.print("Enter student ID to remove: ");
        String id = scanner.nextLine();
        
        if (studentDatabase.containsKey(id)) {
            Student student = studentDatabase.get(id);
            for (String courseCode : student.registeredCourses) {
                courseDatabase.get(courseCode).capacity++;
            }
            studentDatabase.remove(id);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
