package entities;

public class LongestProjects {
    private int id;
    private long lengthInMonths;


    public long getLengthInMonths() {
        return lengthInMonths;
    }

    public void setLengthInMonths(long lengthInMonth) {
        this.lengthInMonths = lengthInMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
