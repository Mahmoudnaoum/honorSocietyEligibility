package org.honorSociety.model;

import org.honorSociety.model.common.Degree;

public class Graduate extends Student{
    private final Degree degree;

    public Graduate(String name, Double creditHoursEarned, Double qualityPoints, Degree degree) {
        super(name, creditHoursEarned, qualityPoints);
        this.degree = degree;
    }

    @Override
    public boolean isEligibleForHonorSociety() {
        if( degree == Degree.DOCTORATE || degree == Degree.MASTERS ) {
            return super.isEligibleForHonorSociety();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + degree.toString();
    }
}
