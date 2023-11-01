package pl.javastart.task;

public class Group {

    private String groupCode;
    private String name;
    private int lecturerId;

    public Group(String groupCode, String name, int lecturerId) {
        this.groupCode = groupCode;
        this.name = name;
        this.lecturerId = lecturerId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getName() {
        return name;
    }

    public int getLecturerId() {
        return lecturerId;
    }

}


