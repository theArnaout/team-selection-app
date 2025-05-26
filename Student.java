//  Student.java
//
//  Mohamad Arnaout
//  T00765395
//  COMP 1231 Assignment 4
//  Thursday, April 24, 2025.
//
//  This class represents a Student with a name and cumulative GPA.
//  It implements Comparable to allow sorting by cumulative GPA.
//*********************************************************************

public class Student implements Comparable<Student>{
    private String name;
    private double cGPA;

    // Initialize a Student with name and cumulative GPA
    public Student(String name, double cGPA) {
        this.name = name;
        this.cGPA = cGPA;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cGPA;
    }

    // Implementation of compareTo for sorting by cGPA
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.cGPA, other.cGPA);
    }

    // String representation of student
    @Override
    public String toString() {
        return "Name=" + name + "; Cumulative GPA=" + String.format("%.2f", cGPA);
    }
}
