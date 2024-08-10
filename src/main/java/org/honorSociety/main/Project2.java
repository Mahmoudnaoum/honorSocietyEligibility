package org.honorSociety.main;


import org.honorSociety.model.Graduate;
import org.honorSociety.model.Student;
import org.honorSociety.model.Undergraduate;
import org.honorSociety.model.common.Degree;
import org.honorSociety.model.common.StudentYear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Project2 {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<Student>();

            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(Project2.class.getClassLoader().getResourceAsStream("students.txt"))))) {
                String line;
                Student newStudent;
                double totalGpa = 0;
                while ((line = reader.readLine()) != null) {
                    newStudent = readStudent(line);
                    totalGpa += newStudent.getGPA();
                    students.add(newStudent);
                }

                double averageGpa = totalGpa / students.size();

                double gpaThreshold = (averageGpa + 4.0) / 2.0;

                Student.setGpaThreshold(gpaThreshold);

                System.out.println("Honor Society GPA Threshold: " + String.format("%.2f", gpaThreshold));

                System.out.println("Eligible Students For Honor Society Membership:");

                for (Student student : students) {
                    if (student.isEligibleForHonorSociety()) {
                        System.out.println(student);
                    }
                }

            } catch (IOException e) {

                System.err.println("Error reading the students.txt file");
                System.exit(1);
            }

    }

    private static Student parseStudent(String name, double creditHours, double qualityPoints, String stateOrDegree) {
        StudentYear year = null;
        Degree degree = null;
        for( StudentYear yearValue : StudentYear.values()) {
            if (stateOrDegree.equalsIgnoreCase(yearValue.toString())) {
                year = yearValue;
                return  new Undergraduate(name, creditHours, qualityPoints, year);
            }
        }
        for( Degree degreeValue : Degree.values()) {
            if (stateOrDegree.equalsIgnoreCase(degreeValue.toString())) {
                degree = degreeValue;
                return new Graduate(name, creditHours, qualityPoints, degree);
            }
        }

        return null;

    }

    private static String parseName(String namePart) {
        String[] nameParts = namePart.split(",");
        return nameParts[1] + " " + nameParts[0];
    }

    private static Student readStudent(String studentLine) {
        String[] studentInfo = studentLine.split(" ");
        String studentName = parseName(studentInfo[0]);
        double creditHoursEarned = Double.parseDouble(studentInfo[1]);
        double qualityPoints = Double.parseDouble(studentInfo[2]);
        String stateOrDegree = studentInfo[3].toUpperCase();
        return parseStudent(studentName, creditHoursEarned, qualityPoints, stateOrDegree);
    }



}