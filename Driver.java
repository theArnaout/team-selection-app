//  Driver.java
//
//  Mohamad Arnaout
//  T00765395
//  COMP 1231 Assignment 4
//  Thursday, April 24, 2025.
//
//  This driver class tests the student selection process for the competition team.
//  It creates a team, adds students, filters by standard cGPA, removes the last
//  applicant and sorts the remaining candidates by cumulative GPA in descending
//  order.


import java.util.Comparator;

public class Driver {
    public static void main(String[] args) {
        // Create first team that will store students
        Team<Student> studentList1 = new Team<>();

        // Create standard student with minimum cumulative GPA
        Student standard = new Student("Standard", 3.67);

        // Scenario 1 - Create 10 student objects and add to the list
        studentList1.addToTeam(new Student("Ali", 3.7));
        studentList1.addToTeam(new Student("Bob", 2.5));
        studentList1.addToTeam(new Student("Maryam", 4.2));
        studentList1.addToTeam(new Student("Mohamad", 3.9));
        studentList1.addToTeam(new Student("Lina", 3.5));
        studentList1.addToTeam(new Student("Ashley", 3.7));
        studentList1.addToTeam(new Student("Mustafa", 4.0));
        studentList1.addToTeam(new Student("Shefaly", 4.0));
        studentList1.addToTeam(new Student("George", 3.0));
        studentList1.addToTeam(new Student("Tilda", 3.1));

        System.out.println("\n===========================================");
        System.out.println("Scenario 1");
        System.out.println("===========================================\n");
        runSelection(studentList1, standard);

        // Scenario 2 - Create 3 student objects and add to the list
        Team<Student> studentList2 = new Team<>();  // Second team
        studentList2.addToTeam(new Student("Jancy", 3.66));
        studentList2.addToTeam(new Student("Peter", 3.00));
        studentList2.addToTeam(new Student("Tracy", 3.33));


        System.out.println("\n===========================================");
        System.out.println("Scenario 2");
        System.out.println("===========================================\n");
        runSelection(studentList2, standard);

    }


    private static void runSelection(Team<Student> studentList, Student standard) {
        // Print initial list of students that want to join
        System.out.println("The following students want to join the competition team:");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("\nTotal number of students = " + studentList.getNumberOfMembers() + "\n");

        // Filter out students below standard GPA requirement
        System.out.println("Students who do not fulfill cumulative GPA requirement (3.67): ");
        Team<Student> qualified = new Team<>();
        for (Student student : studentList) {
            if (student.compareTo(standard) < 0) {
                System.out.println("Remove: " + student);
            } else {
                qualified.addToTeam(student);
            }
        }
        System.out.println();

        // List of students above standard cumulative GPA
        System.out.println("Candidates who have fulfilled cumulative GPA requirement (3.67): ");
        if (qualified.hasNoMembers()) {
            System.out.println("No candidate has been selected!");
        } else {
            for (Student candidate : qualified) {
                System.out.println(candidate);
            }
        }
        System.out.println();

        // Remove last applicant
        System.out.println("The following students who submitted the application last has been removed from the list: ");
        if (qualified.hasNoMembers()) {
            System.out.println("No candidates in the list.");
        } else {
            Student lastCandidate = null;
            for (Student candidate : qualified) {
                lastCandidate = candidate;
            }
            System.out.println("Remove: " + lastCandidate);
            qualified.removeFromTeam();
        }
        System.out.println();

        // sort in descending and display list
        System.out.println("The candidates are sorted in a descending order based on their cumulative GPA: ");
        if (qualified.hasNoMembers()) {
            System.out.println("No candidates in the list.");
        } else {
            qualified.sort(Comparator.comparingDouble(Student::getCGPA).reversed());
            for (Student candidate : qualified) {
                System.out.println(candidate);
            }
        }
    }
}
