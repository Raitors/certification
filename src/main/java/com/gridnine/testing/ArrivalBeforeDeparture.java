package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;


 // исключения перелетов, у которых время прибытия раньше времени вылета.
public class ArrivalBeforeDeparture implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

    @Override
    public String filterText() {
        return "\n Прибытия перед вылетом: ";
    }
}
