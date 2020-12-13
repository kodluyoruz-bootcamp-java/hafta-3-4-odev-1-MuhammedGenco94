package com.kodluyoruz.homework3.utils.basemodels;

import com.kodluyoruz.homework3.interfaces.Clock;
import com.kodluyoruz.homework3.utils.enums.CityCode;
import com.kodluyoruz.homework3.utils.models.LocalKeyListener;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class City implements Clock, Comparable<City> {

    private String name;
    private CityCode cityCode;
    private Integer gmtDiff;


    public City(String name, CityCode cityCode, Integer gmtDiff) {
        this.name = name;
        this.cityCode = cityCode;
        this.gmtDiff = gmtDiff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityCode getCityCode() {
        return cityCode;
    }

    public void setCityCode(CityCode cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getGmtDiff() {
        return gmtDiff;
    }

    public void setGmtDiff(Integer gmtDiff) {
        this.gmtDiff = gmtDiff;
    }

    @Override
    public void showTime() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalKeyListener keyListener = new LocalKeyListener();

        while (!keyListener.isPressed()) {
            LocalTime time = LocalTime.now().minusHours(3);
            time = time.plusHours(this.getCityCode().getId());

            System.out.printf("%s : %s\r", this.getName(), time.format(dateTimeFormatter));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            keyListener.getFrame().setVisible(true);
        }
    }

    @Override
    public int compareTo(City o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", cityCode=" + cityCode +
                ", gmtDiffType=" + gmtDiff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && cityCode == city.cityCode && gmtDiff == city.gmtDiff;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cityCode, gmtDiff);
    }
}
