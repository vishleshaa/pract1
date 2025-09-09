import java.util.*;

class Student {
    private int rollNo;
    private String name;
    private boolean isPresent;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.isPresent = false;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void markPresent() {
        isPresent = true;
    }

    public void markAbsent() {
        isPresent = false;
    }
}

public class StudentAttendance {
    private List<Student> students;

    public StudentAttendance() {
        students = new ArrayList<>();
    }

    public void addStudent(int rollNo, String name) {
        students.add(new Student(rollNo, name));
    }

    public void markAttendance(int rollNo, boolean present) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                if (present) {
                    s.markPresent();
                } else {
                    s.markAbsent();
                }
                return;
            }
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void showAttendance() {
        System.out.println("\nAttendance List:");
        for (Student s : students) {
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getName() + ", Present: " + (s.isPresent() ? "Yes" : "No"));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentAttendance attendance = new StudentAttendance();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll number for student " + (i + 1) + ": ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            attendance.addStudent(rollNo, name);
        }

        System.out.println("\nMark attendance (Y for present, N for absent):");
        for (int i = 0; i < n; i++) {
            Student s = attendance.students.get(i);
            System.out.print("Is " + s.getName() + " (Roll No: " + s.getRollNo() + ") present? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            attendance.markAttendance(s.getRollNo(), input.equals("Y"));
        }

        attendance.showAttendance();
        scanner.close();
    }
}