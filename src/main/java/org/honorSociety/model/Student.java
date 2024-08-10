package org.honorSociety.model;

public class Student {
    private static Double minimumGPAThreshold = 2.0;
    private final String name;
    private final Double creditHoursEarned;
    private final Double qualityPoints;
    public Student(String name, Double creditHoursEarned, Double qualityPoints) {
        this.name = name;
        this.creditHoursEarned = creditHoursEarned;
        this.qualityPoints = qualityPoints;
    }
    public Double getGPA() {
        return this.qualityPoints / this.creditHoursEarned;
    }

    public boolean isEligibleForHonorSociety () {
        return this.getGPA() >= Student.minimumGPAThreshold;
    }

    @Override
    public String toString() {
        return name + " "  + String.format("%.2f", this.getGPA());
    }
    public static void setGpaThreshold(Double minimumGPAThreshold) {
        Student.minimumGPAThreshold = minimumGPAThreshold;
    }
}
