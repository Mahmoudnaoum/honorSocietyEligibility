import org.honorSociety.model.Graduate;
import org.honorSociety.model.Student;
import org.honorSociety.model.Undergraduate;
import org.honorSociety.model.common.Degree;
import org.honorSociety.model.common.StudentYear;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class Project2Test {

    @Test
    void testGpaCalculation() {
        Student student = new Student("John Doe", 30.0, 90.0);
        assertEquals(3.0, student.getGPA(), 0.01);
    }

    @Test
    void testUndergraduateEligibility() {
        Undergraduate student = new Undergraduate("Jane Smith", 60.0, 180.0, StudentYear.JUNIOR);
        Student.setGpaThreshold(3.0);
        assertTrue(student.isEligibleForHonorSociety());
    }

    @Test
    void testUndergraduateNonEligibilityDueToYear() {
        Undergraduate student = new Undergraduate("Sam Lee", 60.0, 180.0, StudentYear.SOPHOMORE);
        Student.setGpaThreshold(3.0);
        assertFalse(student.isEligibleForHonorSociety());
    }

    @Test
    void testGraduateEligibility() {
        Graduate student = new Graduate("Emily Davis", 40.0, 160.0, Degree.MASTERS);
        Student.setGpaThreshold(3.0);
        assertTrue(student.isEligibleForHonorSociety());
    }

    @Test
    void testGraduateNonEligibilityDueToDegree() {
        Graduate student = new Graduate("Mike Brown", 40.0, 100.0, Degree.DOCTORATE);
        Student.setGpaThreshold(3.0);
        assertFalse(student.isEligibleForHonorSociety());
    }

}
