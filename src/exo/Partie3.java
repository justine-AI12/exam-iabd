package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Partie3 {

    public static final Comparator<Trip> byPrice =
            Comparator.comparingDouble(Trip::price);

    public static final Comparator<Trip> byRating =
            Comparator.comparingDouble(Trip::rating);

    public List<Trip> top10ExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .sorted(byPrice.reversed())
                .limit(10)
                .toList();
    }

    public Optional<Trip> bestTrip(List<Trip> trips) {
        return trips.stream()
                .max(byRating);
    }
}
