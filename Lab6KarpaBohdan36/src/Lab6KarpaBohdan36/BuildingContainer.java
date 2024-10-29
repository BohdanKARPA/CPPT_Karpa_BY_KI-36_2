package Lab6KarpaBohdan36;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BuildingContainer<T extends Building> {
    private final List<T> buildings; // Список будівель

    // Конструктор
    public BuildingContainer() {
        buildings = new ArrayList<>();
    }

    // Метод для додавання будівлі
    public void addBuilding(T building) {
        buildings.add(building);
    }

    // Пошук будівлі з максимальною висотою
    public Optional<T> findMaxHeight() {
        return buildings.stream().max(Comparator.comparingDouble(Building::getHeight));
    }

    // Пошук будівлі з максимальною площею
    public Optional<T> findMaxArea() {
        return buildings.stream().max(Comparator.comparingDouble(Building::getArea));
    }

    // Пошук будівлі з максимальною кількістю поверхів
    public Optional<T> findBuildingWithMaxFloors() {
        return buildings.stream().max(Comparator.comparingInt(Building::getFloors));
    }

    // Пошук найстарішої будівлі
    public Optional<T> findOldestBuilding() {
        return buildings.stream().min(Comparator.comparingInt(Building::getYearBuilt));
    }

    // Видалення будівлі, якщо вона відповідає певній умові
    public void removeBuildingWithCondition(BuildingContainer<? super Building> container, Building building) {
        container.buildings.remove(building);
    }

    // Отримання всіх будівель
    public List<T> getAllBuildings() {
        return new ArrayList<>(buildings);
    }

    // Сортування будівель за роком побудови (від новіших до старіших)
    public List<T> sortByYearBuilt() {
        List<T> sortedList = new ArrayList<>(buildings);
        sortedList.sort(Comparator.comparingInt(Building::getYearBuilt).reversed());
        return sortedList;
    }
}
