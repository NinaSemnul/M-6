package DTO;

import java.time.LocalDate;

public class YoungestEldestWorkers {
    private String Type;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorkers(String Type, String name, LocalDate birthday){
        this.Type = Type;
        this.name = name;
        this.birthday = birthday;
    }


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
