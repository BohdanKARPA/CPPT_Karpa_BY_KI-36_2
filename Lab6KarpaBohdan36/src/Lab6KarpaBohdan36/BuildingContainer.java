package Lab6KarpaBohdan36;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BuildingContainer<T extends Building> {
    private final List<T> buildings; // Список будівель

    // Конструктор, що ініціалізує контейнер
    public BuildingContainer() {
        buildings = new ArrayList<>();
    }

    // Метод додавання елемента до контейнера
    public void addBuilding(T building) {
        buildings.add(building);
    }

    // Метод видалення елемента з контейнера (залишено для використання в майбутньому)
    public void removeBuilding(T building) {
        buildings.remove(building);
    }

    // Пошук будівлі з найбільшою висотою
    public Optional<T> findMaxHeight() {
        return buildings.stream().max(Comparator.comparingDouble(Building::getHeight));
    }

    // Пошук будівлі з найбільшою площею
    public Optional<T> findMaxArea() {
        return buildings.stream().max(Comparator.comparingDouble(Building::getArea));
    }

    // Пошук будівлі з найбільшою кількістю поверхів
    public Optional<T> findMaxFloors() {
        return buildings.stream().max(Comparator.comparingInt(Building::getFloors));
    }

    // Пошук найстарішої будівлі
    public Optional<T> findOldestBuilding() {
        return buildings.stream().min(Comparator.comparingInt(Building::getYearBuilt));
    }

    // Метод для отримання всіх будівель
    public List<T> getAllBuildings() {
        return new ArrayList<>(buildings);
    }

    // Сортування будівель за роком побудови (від новішого до старішого)
    public List<T> sortByYearBuilt() {
        List<T> sortedList = new ArrayList<>(buildings);
        sortedList.sort(Comparator.comparingInt(Building::getYearBuilt).reversed());
        return sortedList;
    }
}
