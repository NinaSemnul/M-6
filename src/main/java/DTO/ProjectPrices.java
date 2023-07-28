package DTO;

public class ProjectPrices {
    private  String ID;
    private String PRICE;

    public ProjectPrices(String ID, String PRICE){
        this.ID = ID;
        this.PRICE = PRICE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }
}
