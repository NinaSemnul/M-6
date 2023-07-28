package DTO;

import java.time.LocalDate;

public class Worker {
    private String ID;
    private String name;
    private String LEVEL;
    private LocalDate birthday;
    private String SALARY;

    public Worker(String ID, String name, String LEVEL, LocalDate birthday, String SALARY){
        this.ID = ID;
        this.name = name;
        this.LEVEL = LEVEL;
        this.birthday = birthday;
        this.SALARY = SALARY;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(String LEVEL) {
        this.LEVEL = LEVEL;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSALARY() {
        return SALARY;
    }

    public void setSALARY(String SALARY) {
        this.SALARY = SALARY;
    }
}
