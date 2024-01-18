package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentMomentTime implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime currentTime = LocalDateTime.now();

        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isAfter(currentTime)))
                .collect(Collectors.toList());
    }

    @Override
    public String filterText() {
        return "\n Вылет до текущего момента времени. ";
    }
}