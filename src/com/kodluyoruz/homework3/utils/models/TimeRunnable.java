package com.kodluyoruz.homework3.utils.models;

import com.kodluyoruz.homework3.utils.baseModels.City;

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
