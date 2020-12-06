package com.kodluyoruz.homework3.utils.enums;

public enum CityCode {
    MOW(3, "Moscow"),      //UTC+3
    NYC(-4, "New York"),    //UTC-4
    LON(0, "London"),      //UTC+0
    BER(1, "Berlin"),      //UTC+1
    DEL(5, "New Delhi");   //UTC+5

    private final Integer id;
    private final String nameDescription;

    CityCode(Integer id, String nameDescription) {
        this.id = id;
        this.nameDescription = nameDescription;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public Integer getId() {
        return id;
    }

    public String getNameDescription() {
        return nameDescription;
    }
}
