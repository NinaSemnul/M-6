package DTO;

import java.time.LocalDate;

public class ProjectWorker {
    private String PROJECT_ID;
    private String WORKER_ID;


    public ProjectWorker(String PROJECT_ID, String WORKER_ID ){
        this.PROJECT_ID = PROJECT_ID;
        this.WORKER_ID = WORKER_ID;
    }

    public String getPROJECT_ID() {
        return PROJECT_ID;
    }

    public void setPROJECT_ID(String PROJECT_ID) {
        this.PROJECT_ID = PROJECT_ID;
    }



    public String getWORKER_ID() {
        return WORKER_ID;
    }

    public void setWORKER_ID(String CLIENT_ID) {
        this.WORKER_ID = WORKER_ID;
    }
}
