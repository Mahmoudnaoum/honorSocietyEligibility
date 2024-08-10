package org.honorSociety.model;

import org.honorSociety.model.common.StudentYear;

public class Undergraduate extends Student{
    private final StudentYear year;
    public Undergraduate(String name, Double creditHoursEarned, Double qualityPoints, StudentYear year) {
        super(name, creditHoursEarned, qualityPoints);
        this.year = year;

    }

    @Override
    public boolean isEligibleForHonorSociety() {
        if( year == StudentYear.JUNIOR || year == StudentYear.SENIOR ) {
            return super.isEligibleForHonorSociety();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + year.toString();
    }

}
