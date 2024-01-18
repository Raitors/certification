package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


// общее время, проведенное на земле между сегментами, превышает два часа.
public class TimeOnEarth implements Filter {


    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calcTotalTime(flight) <= 2)
                .collect(Collectors.toList());
    }


    //общее время на земле между сегментами.
    private long calcTotalTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long totalTime = 0;

        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime currentArrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();

            totalTime += currentArrival.until(nextDeparture, ChronoUnit.HOURS);
        }
        return totalTime;
    }


    @Override
    public String filterText() {
        return "\n Перелеты, где общее время, проведённое на земле, превышает два часа: ";
    }
}
