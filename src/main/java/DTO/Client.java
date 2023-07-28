package DTO;

public class Client {

    private String ID;
    private String name;


    public Client(String ID, String name ){

        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setPROJECT_COUNT(String ID) {
        this.ID = ID;
    }
}
