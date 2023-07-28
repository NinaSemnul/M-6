package DTO;

public class LongestProject {
    private String ID;
    private String MONTH_COUNT;

    public LongestProject(String ID, String MONTH_COUNT){
        this.ID = ID;
        this.MONTH_COUNT = MONTH_COUNT;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMONTH_COUNT() {
        return MONTH_COUNT;
    }

    public void setMONTH_COUNT(String MONTH_COUNT) {
        this.MONTH_COUNT = MONTH_COUNT;
    }
}
