package com.honorsociety;

/**
 * This class represents a graduate student and extends the Student class.
 * This class ensures only people pursing masters are eligible for honor society membership.
 */
public class Graduate extends Student{
    private final String degree;


    /**
     * Construct a Graduate object with specified parameters.
     *
     * @param name  The name of the student
     * @param credit credits taken by the student
     * @param points quality points earned by student
     * @param degree Type of degree student is pursuing.
     */
    public Graduate(String name, double credit, int points, String degree) {
        super(name, credit, points);
        this.degree = degree.toLowerCase();
    }


    /**
     * determines whether a student is eligible for honor student membership or not.
     *
     * @return student's eligibility for honor society membership
     */
    @Override
    public boolean eligibleForHonorSociety() {
        return degree.equals("masters") && super.eligibleForHonorSociety();
    }

    /**
     * Returns student's information and degree
     *
     * @return String representation of Graduate student class
     */
    @Override
    public String toString() {
        return super.toString() + " degree: " + degree;
    }
}
