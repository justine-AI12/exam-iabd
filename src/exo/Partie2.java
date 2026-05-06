package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    private static final Function<Trip, String> cityExtractor = Trip::city;

    private static final Function<Trip, String> driverExtractor = Trip::driverId;

    private static final ToDoubleFunction<Trip> priceExtractor = Trip::price;

    private static final ToDoubleFunction<Trip> durationExtractor = Trip::durationMin;

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(cityExtractor, Collectors.counting()));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(driverExtractor, Collectors.summingDouble(priceExtractor)));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(cityExtractor, Collectors.averagingDouble(durationExtractor)));
    }
}
