package Lab6KarpaBohdan36;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BuildingContainer<T extends Building> {
    private final List<T> buildings; // List of buildings

    // Constructor
    public BuildingContainer() {
        buildings = new ArrayList<>();
    }

    // Add a building
    public void addBuilding(T building) {
        buildings.add(building);
    }

    // Find building with maximum height
    public Optional<T> findMaxHeight() {
        return buildings.stream().max(Comparator.comparingDouble(Building::getHeight));
    }

    // Find building with maximum area
    public Optional<T> findMaxArea() {
        return buildings.stream().max(Comparator.comparingDouble(Building::getArea));
    }

    // Find building with the maximum number of floors
    public Optional<T> findBuildingWithMaxFloors() {
        return buildings.stream().max(Comparator.comparingInt(Building::getFloors));
    }

    // Find the oldest building
    public Optional<T> findOldestBuilding() {
        return buildings.stream().min(Comparator.comparingInt(Building::getYearBuilt));
    }

    // Remove a building if it matches the condition
    public void removeBuildingWithCondition(BuildingContainer<? super Building> container, Building building) {
        container.buildings.remove(building);
    }

    // Get all buildings
    public List<T> getAllBuildings() {
        return new ArrayList<>(buildings);
    }

    // Sort buildings by year built (from newest to oldest)
    public List<T> sortByYearBuilt() {
        List<T> sortedList = new ArrayList<>(buildings);
        sortedList.sort(Comparator.comparingInt(Building::getYearBuilt).reversed());
        return sortedList;
    }
}
