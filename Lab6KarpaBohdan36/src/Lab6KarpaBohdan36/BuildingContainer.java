package Lab6KarpaBohdan36;

import java.util.ArrayList;
import java.util.List;

public class BuildingContainer<T extends Building> {
    private List<T> buildings = new ArrayList<>();

    // Метод для додавання елементу
    public void addBuilding(T building) {
        buildings.add(building);
    }

    // Метод для вилучення елементу
    public void removeBuilding(T building) {
        buildings.remove(building);
    }

    // Метод для пошуку максимального елементу (за висотою)
    public T getMaxHeightBuilding() {
        if (buildings.isEmpty()) {
            return null;
        }
        T maxBuilding = buildings.get(0);
        for (T building : buildings) {
            if (building.getHeight() > maxBuilding.getHeight()) {
                maxBuilding = building;
            }
        }
        return maxBuilding;
    }

    // Метод для виведення всіх споруд
    public void displayBuildings() {
        for (T building : buildings) {
            System.out.println(building);
        }
    }
}
