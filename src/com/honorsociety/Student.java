package com.honorsociety;

/**
 * Represents a student with academic records
 * It includes students name, credits and quality points
 *
 */
public class Student {
    private String name;
    private double credit;
    private int points;
    static double gpaThreshold;

    /**
     * Constructor for Student class
     *
     * @param name  The name of the student
     * @param credit The credits students have taken
     * @param points The quality points students have earned
     */
    public Student(String name, double credit, int points) {
        this.name = name;
        this.credit = credit;
        this.points = points;
    }

    /**
     * Calculates the GPA of the student
     *
     * @return The GPA of a student
     */
    public double gpa(){
        return points / credit;
    }

    /**
     * determines whether a student is eligible for honor student membership or not.
     *
     * @return student's eligibility for honor society membership
     */
    public boolean eligibleForHonorSociety(){
        return gpa() > gpaThreshold;
    }

    /**
     * Sets the GPA threshold for honor society eligibility.
     *
     * @param gpaThreshold GPA threshold to be set
     * @return The set GPA threshold
     */
    public static double setGpaThreshold(double gpaThreshold){
        Student.gpaThreshold = gpaThreshold;
        return Student.gpaThreshold;
    }

    /**
     * String representation of Student class
     *
     * @return student's name and GPA
     */
    @Override
    public String toString() {
        return "name: " + name +
                " GPA: " + String.format("%.2f", gpa());
    }
}
