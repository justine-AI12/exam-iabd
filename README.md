# Exam IABD - Lambdas & Streams

## Description

Ce projet est un TP Java sur l'analyse de trajets pour une application de mobilite.

L'objectif est de manipuler un grand volume de trajets avec :

- les streams Java ;
- les lambdas ;
- les `Predicate` ;
- les `Function` ;
- les `Comparator` ;
- les `parallelStream`.

Les donnees sont generees automatiquement par `TripFactory`.

## Structure du projet

```text
src/
+-- Main.java
+-- exo/
|   +-- Partie1.java
|   +-- Partie2.java
|   +-- Partie3.java
|   +-- Partie4.java
+-- factory/
|   +-- TripFactory.java
+-- models/
    +-- Trip.java
```

## Exercices

### Partie 1 - Filtrage

- trajets longs et chers ;
- mauvais trajets ;
- trajets recents.

### Partie 2 - Analyse et statistiques

- nombre de trajets par ville ;
- revenu total par chauffeur ;
- duree moyenne par ville.

### Partie 3 - Tri et recherche

- top 10 des trajets les plus chers ;
- meilleur trajet ;
- comparators par prix et par note.

### Partie 4 - Traitement parallele

- revenu total en stream sequentiel ;
- revenu total en stream parallele ;
- nombre de trajets par ville en parallele ;
- trajets premium en parallele.

## Execution

Depuis la racine du projet :

```powershell
javac -d out src\models\Trip.java src\factory\TripFactory.java src\exo\Partie1.java src\exo\Partie2.java src\exo\Partie3.java src\exo\Partie4.java src\Main.java

java -cp out Main
```

## Donnees

Les trajets sont generes avec :

```java
TripFactory.generateTrips(100)
```

Le nombre de trajets peut etre modifie dans `Main.java`.

## Remarque

Les lambdas sont declarees en haut des fichiers d'exercices puis reutilisees dans les streams, conformement aux consignes du sujet.
