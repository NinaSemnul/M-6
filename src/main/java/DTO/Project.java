package DTO;

import java.time.LocalDate;

public class Project {
    private String ID;
    private String CLIENT_ID;
    private LocalDate START_DATE;
    private LocalDate FINISH_DATE;

    public Project(String ID, String CLIENT_ID,LocalDate START_DATE, LocalDate FINISH_DATE ){
        this.ID = ID;
        this.CLIENT_ID = CLIENT_ID;
        this.START_DATE = START_DATE;
        this.FINISH_DATE = FINISH_DATE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDate getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(LocalDate START_DATE) {
        this.START_DATE = START_DATE;
    }

    public LocalDate getFINISH_DATE() {
        return FINISH_DATE;
    }

    public void setFINISH_DATE(LocalDate FINISH_DATE) {
        this.FINISH_DATE = FINISH_DATE;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(String CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }
}
