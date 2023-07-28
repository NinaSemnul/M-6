package DTO;

public class MaxProjectsClient {
    private String name;
    private String PROJECT_COUNT;

    public MaxProjectsClient(String name, String PROJECT_COUNT ){
        this.name = name;
        this.PROJECT_COUNT = PROJECT_COUNT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPROJECT_COUNT() {
        return PROJECT_COUNT;
    }

    public void setPROJECT_COUNT(String PROJECT_COUNT) {
        this.PROJECT_COUNT = PROJECT_COUNT;
    }
}
