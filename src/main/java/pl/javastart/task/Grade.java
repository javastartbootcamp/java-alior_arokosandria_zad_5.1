package pl.javastart.task;

public class Grade {
         private int studentIndex;
    private String groupCode;
     private double grade;

    public Grade(int studentIndex, String groupCode, double grade) {
        this.studentIndex = studentIndex;
        this.groupCode = groupCode;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentIndex=" + studentIndex +
                ", groupCode='" + groupCode + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getStudentIndex() {
        return studentIndex;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public double getGrade() {
        return grade;
    }
}
