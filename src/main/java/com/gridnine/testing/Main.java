package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        List<Filter> filterList = Arrays.asList(
                new ArrivalBeforeDeparture(),
                new CurrentMomentTime(),
                new TimeOnEarth()
        );

        System.out.println("Весь список рейсов:");
        System.out.println(flights);

      //применение фильтров
        filterList.forEach(flightFilter -> {
            List<Flight> filteredFlights = flightFilter.filter(flights);
            System.out.println(flightFilter.filterText());
            System.out.println(filteredFlights);
        });
    }
}