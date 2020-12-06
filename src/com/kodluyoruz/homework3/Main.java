package com.kodluyoruz.homework3;

import com.kodluyoruz.homework3.utils.baseModels.City;
import com.kodluyoruz.homework3.utils.enums.CityCode;
import com.kodluyoruz.homework3.utils.models.TimeRunnable;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        createCities(cities);

        Map<CityCode, City> codeCityHashMap = new HashMap<>();
        putCitiesInMap(codeCityHashMap, cities);

        List<City> sortedCitiesByName = sortCities(codeCityHashMap.values());

        printSortedCities(sortedCitiesByName);

        try {
            Scanner scanner = new Scanner(System.in);
            ExecutorService executorService = Executors.newFixedThreadPool(5);

            int total;
            do {
                System.out.print("Enter number of the Cities between '3' and '5': ");
                total = scanner.nextInt();
            }
            while (!(total >= 3 && total <= 5));

            scanner.nextLine();
            List<String> cityCodes = new ArrayList<>();
            String code;
            for (int i = 0; i < total; i++) {
                do {
                    System.out.print("Enter one of the cities codes: ");
                    code = scanner.nextLine();
                }
                while (!code.matches("BER|DEL|LON|MOW|NYC"));
                cityCodes.add(code);
                System.out.println("OK.");
            }

            for (int i = 0; i < cityCodes.size(); i++) {
                City city = getMapValueByKey(codeCityHashMap, cityCodes.get(i));
                Runnable runnable = new TimeRunnable(city);
                executorService.execute(runnable);
                System.out.println(".\r");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry, you had to enter a number!!");
        }
    }


    /**
     * Create Cities
     */
    public static void createCities(List<City> cities) {

        City moscow = new City("Moscow", CityCode.MOW, CityCode.MOW.getId());
        City newYork = new City("New York", CityCode.NYC, CityCode.NYC.getId());
        City london = new City("London", CityCode.LON, CityCode.LON.getId());
        City berlin = new City("Berlin", CityCode.BER, CityCode.BER.getId());
        City newDelhi = new City("New Delhi", CityCode.DEL, CityCode.DEL.getId());

        Collections.addAll(cities, moscow, newYork, london, berlin, newDelhi);
    }

    /**
     * Put Cities In Map
     */
    public static void putCitiesInMap(Map<CityCode, City> codeCityHashMap, List<City> cities) {

        for (City city : cities) {
            codeCityHashMap.put(city.getCityCode(), city);
        }
    }

    /**
     * Sort Cities By Name
     */
    private static List<City> sortCities(Collection<City> values) {

        List<City> sortedCitiesByName = new ArrayList<>(values);
        Collections.sort(sortedCitiesByName);

        return sortedCitiesByName;
    }

    /**
     * Print Cities
     */
    private static void printSortedCities(List<City> sortedCitiesByName) {
        int i = 0;
        for (City city : sortedCitiesByName) {
            System.out.printf("%s) (%s - %s)\n", ++i, city.getCityCode().name(), city.getName());
        }
    }

    public static City getMapValueByKey(Map<CityCode, City> map, String key) {
        for (Map.Entry<CityCode, City> entry : map.entrySet()) {
            if (Objects.equals(key, entry.getKey().toString())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
