package com.kodluyoruz.homework3.utils.models;

import com.kodluyoruz.homework3.utils.basemodels.City;

import java.io.IOException;

public class TimeRunnable implements Runnable {
    private City city;

    public TimeRunnable(City city) {
        this.city = city;
    }

    @Override
    public void run() {
        city.showTime();
    }
}
