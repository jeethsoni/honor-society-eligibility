package com.honorsociety;

/**
 * This class represents a undergraduate student and extends the Student class.
 * This class ensures only people who are juniors and seniors are eligible for honor society membership.
 */
public class Undergraduate extends Student{
    private final String year;

    /**
     * Construct a UnderGraduate object with specified parameters.
     *
     * @param name  The name of the student
     * @param credit credits taken by the student
     * @param points quality points earned by student
     * @param year The current year student's in
     */
    public Undergraduate(String name, double credit, int points, String year) {
        super(name, credit, points);
        this.year = year.toLowerCase();
    }

    /**
     * determines whether a student is eligible for honor student membership or not.
     *
     * @return student's eligibility for honor society membership
     */
    @Override
    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() && (year.equals("junior") || year.equals("senior"));
    }

    /**
     * Returns student's information and year
     *
     * @return String representation of undergraduate student class
     */
    @Override
    public String toString() {
        return super.toString() + " year: " + year;
    }
}
