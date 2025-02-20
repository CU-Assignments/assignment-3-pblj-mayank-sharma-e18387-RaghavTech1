import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom exception for course full
class CourseFullException extends Exception {
	public CourseFullException(String message) {
		super(message);
	}
}

// Custom exception for prerequisite not met
class PrerequisiteNotMetException extends Exception {
	public PrerequisiteNotMetException(String message) {
		super(message);
	}
}

// Course class
class Course {
	private String name;
	private int maxEnrollment;
	private List<String> prerequisites;
	private List<String> enrolledStudents;

	// Constructor
	public Course(String name, int maxEnrollment, List<String> prerequisites) {
		this.name = name;
		this.maxEnrollment = maxEnrollment;
		this.prerequisites = prerequisites;
		this.enrolledStudents = new ArrayList<>();
	}

	// Method to enroll a student
	public void enrollStudent(String studentName, List<String> completedCourses)
			throws CourseFullException, PrerequisiteNotMetException {
		if (enrolledStudents.size() >= maxEnrollment) {
			throw new CourseFullException("Error: CourseFullException - " + name + " is full.");
		}
		for (String prerequisite : prerequisites) {
			if (!completedCourses.contains(prerequisite)) {
				throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisite
						+ " before enrolling in " + name + ".");
			}
		}
		enrolledStudents.add(studentName);
		System.out.println("Enrolled " + studentName + " in " + name + ".");
	}

	// Method to display enrolled students
	public void displayEnrolledStudents() {
		System.out.println("Enrolled students in " + name + ": " + enrolledStudents);
	}
}

public class Exp3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Create a list of prerequisites
		List<String> advancedJavaPrerequisites = new ArrayList<>();
		advancedJavaPrerequisites.add("Core Java");

		// Create a course
		Course advancedJava = new Course("Advanced Java", 2, advancedJavaPrerequisites);

		try {
			// Enroll a student
			System.out.println("Enroll in Course: Advanced Java");
			System.out.print("Student Name: ");
			String studentName = scanner.nextLine();
			System.out.print("Completed Courses (comma-separated): ");
			String[] courses = scanner.nextLine().split(",");
			List<String> completedCourses = new ArrayList<>();
			for (String course : courses) {
				completedCourses.add(course.trim());
			}
			advancedJava.enrollStudent(studentName, completedCourses);
		} catch (CourseFullException | PrerequisiteNotMetException e) {
			System.out.println(e.getMessage());
		} finally {
			// Always show the enrolled students
			advancedJava.displayEnrolledStudents();
		}

		scanner.close();
	}
}
