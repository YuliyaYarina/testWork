package com.gridnine.testing.flightFilter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilter {

    /**
     * Фильтр, исключающий полеты с сегментами в прошлом
     */
public List<Flight> excludePastSegments (List<Flight> flights) {
    return flights.stream()
            .filter(flight -> flight.getSegments().stream()
                    .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())))
            .collect(Collectors.toList());
}

    /**
     * Фильтр, исключающий полеты с датой прилёта раньше даты вылета.
     * @param flights полеты
     */
    public List<Flight> excludePasDepartureSegments(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

    /**
     * Фильтр, исключающий перелеты, где общее время, проведённое на земле, превышает два часа
     * @param flights перелеты
     * @return отфильтрованные перелеты
     */
    public List<Flight> totalGroundTimeLessThen(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    long groundTime = 0;
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime arrival = segments.get(i).getArrivalDate();
                        LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                        groundTime += java.time.Duration.between(arrival, nextDeparture).toMinutes();
                    }
                    return groundTime <= 120;
                })
                .collect(Collectors.toList());
    }


}
