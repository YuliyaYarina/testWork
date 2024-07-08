package com.gridnine.testing.flightFilter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FlightFilterTest {

    private List<Flight> flights;
    private FlightFilter filter;

    @BeforeEach
    void setUp() {
        flights = FlightBuilder.createFlights();
        filter = new FlightFilter();
    }
    @Test
    void excludePastSegments() {
        List<Flight> result = filter.excludePastSegments(flights);
        assertTrue(result.stream().allMatch(flight ->
                flight.getSegments().stream().allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))
        ));
    }

    @Test
    void excludePasDepartureSegments() {
        List<Flight> result = filter.excludePasDepartureSegments(flights);
        assertTrue(result.stream().allMatch(flight ->
                flight.getSegments().stream().allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()))
        ));
    }

    @Test
    void totalGroundTimeLessThen() {
        List<Flight> result = filter.totalGroundTimeLessThen(flights);
        assertTrue(result.stream().allMatch(flight -> {
            List<Segment> segments = flight.getSegments();
            long groundTime = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                groundTime += java.time.Duration.between(arrival, nextDeparture).toMinutes();
            }
            return groundTime <= 120;
        }));
    }
}