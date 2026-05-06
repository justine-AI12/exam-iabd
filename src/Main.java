import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

void main() {
    List<Trip> trips = TripFactory.generateTrips(100);

    Partie1 partie1 = new Partie1();
    Partie2 partie2 = new Partie2();
    Partie3 partie3 = new Partie3();
    Partie4 partie4 = new Partie4();

    printSection("Donnees generees");
    printTrips(trips);

    printSection("Partie 1 - Filtrage");
    printTrips("Trajets longs et chers", partie1.longAndExpensiveTrips(trips));
    printTrips("Mauvais trajets", partie1.badTrips(trips));
    printTrips("Trajets recents", partie1.recentTrips(trips));

    printSection("Partie 2 - Analyse et statistiques");
    printMap("Nombre de trajets par ville", partie2.countByCity(trips), "");
    printMap("Revenu par chauffeur", partie2.revenueByDriver(trips), " euros");
    printMap("Duree moyenne par ville", partie2.avgDurationByCity(trips), " min");

    printSection("Partie 3 - Tri et recherche");
    printTrips("Top 10 trajets les plus chers", partie3.top10ExpensiveTrips(trips));
    printOptionalTrip("Meilleur trajet", partie3.bestTrip(trips));
    printComparatorChecks(trips);

    printSection("Partie 4 - Traitement parallele");
    System.out.printf("Revenu total sequentiel : %.2f euros%n", partie4.totalRevenueSequential(trips));
    System.out.printf("Revenu total parallele  : %.2f euros%n", partie4.totalRevenueParallel(trips));
    printMap("Nombre de trajets par ville en parallele", partie4.countByCityParallel(trips), "");
    printTrips("Trajets premium en parallele", partie4.premiumTripsParallel(trips));
}

void printSection(String title) {
    System.out.println();
    System.out.println("=== " + title + " ===");
}

void printTrips(String title, List<Trip> trips) {
    System.out.println();
    System.out.println(title + " (" + trips.size() + ")");
    printTrips(trips);
}

void printTrips(List<Trip> trips) {
    if (trips.isEmpty()) {
        System.out.println("  Aucun trajet");
        return;
    }

    trips.forEach(trip -> System.out.printf(
            "  #%d | %-9s | chauffeur %-9s | %.1f km | %.1f min | %.2f euros | note %.2f | %s%n",
            trip.id(),
            trip.city(),
            trip.driverId(),
            trip.distanceKm(),
            trip.durationMin(),
            trip.price(),
            trip.rating(),
            trip.startTime().toLocalDate()
    ));
}

void printOptionalTrip(String title, Optional<Trip> trip) {
    System.out.println();
    System.out.println(title);
    trip.ifPresentOrElse(
            value -> printTrips(List.of(value)),
            () -> System.out.println("  Aucun trajet")
    );
}

void printComparatorChecks(List<Trip> trips) {
    System.out.println();
    System.out.println("Verification des comparators");
    printOptionalTrip("Comparator byPrice - trajet le plus cher", trips.stream().max(Partie3.byPrice));
    printOptionalTrip("Comparator byRating - trajet le mieux note", trips.stream().max(Partie3.byRating));
}

void printMap(String title, Map<String, ? extends Number> values, String unit) {
    System.out.println();
    System.out.println(title);
    new TreeMap<>(values).forEach((key, value) -> {
        if (value instanceof Double doubleValue) {
            System.out.printf("  %-12s : %.2f%s%n", key, doubleValue, unit);
        } else {
            System.out.printf("  %-12s : %s%s%n", key, value, unit);
        }
    });
}
