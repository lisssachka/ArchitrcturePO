public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String course;

    public Student(int studentId, String lastName, String firstName, String course) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "studentId: " + studentId +
                ", lastName: " + lastName +
                ", firstName: " + firstName +
                ", course: " + course;
    }
}
