package com.gridnine.testing.flightFilter;

import com.gridnine.testing.model.Flight;

import java.util.List;

public class FlightProcessor {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();

        List<Flight> pastSegmentFilteredFlights = flightFilter.excludePastSegments(flights);
        System.out.println("Filtered Flights (Exclude Past Segments): " + pastSegmentFilteredFlights.size());
        pastSegmentFilteredFlights.forEach(FlightProcessor::printFlight);

        List<Flight> invalidDepartureFilteredFlights = flightFilter.excludePasDepartureSegments(flights);
        System.out.println("Filtered Flights (Exclude Invalid Departure Segments): " + invalidDepartureFilteredFlights.size());
        invalidDepartureFilteredFlights.forEach(FlightProcessor::printFlight);

        List<Flight> groundTimeFilteredFlights = flightFilter.totalGroundTimeLessThen(flights);
        System.out.println("Filtered Flights (Total Ground Time Less Than 2 Hours): " + groundTimeFilteredFlights.size());
        groundTimeFilteredFlights.forEach(FlightProcessor::printFlight);

    }

    private static void printFlight(Flight flight) {
        System.out.println("Flight:");
        flight.getSegments().forEach(segment -> {
            System.out.println("  Segment: " + segment.getDepartureDate() + " -> " + segment.getArrivalDate());
        });
    }
}