package pl.javastart.task;

public class Students {
    private int index;
    private String groupCode;
    private String firstName;
    private String lastName;

    public Students(int index, String groupCode, String firstName, String lastName) {
        this.index = index;
        this.groupCode = groupCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIndex() {
        return index;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
