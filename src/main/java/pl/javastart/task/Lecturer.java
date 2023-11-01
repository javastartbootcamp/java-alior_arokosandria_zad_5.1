package pl.javastart.task;

public class Lecturer {
    private int id;
    private String degree;
    private String fistName;
    private String lastName;

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", degree='" + degree + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getDegree() {
        return degree;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public Lecturer(int id, String degree, String fistName, String lastName) {
        this.id = id;
        this.degree = degree;
        this.fistName = fistName;
        this.lastName = lastName;
    }

    }


