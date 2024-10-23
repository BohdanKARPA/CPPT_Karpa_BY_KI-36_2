package Lab6KarpaBohdan36;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Створення екземплярів будівель
        BuildingContainer<Building> container = getBuildingContainer();

        // Виведення всіх будівель
        System.out.println("Усі будівлі:");
        for (Building building : container.getAllBuildings()) {
            System.out.println(building);
        }

        // Пошук будівлі з найбільшою висотою
        Optional<Building> tallestBuilding = container.findMaxHeight();
        tallestBuilding.ifPresent(building ->
                System.out.println("\nНайвища будівля: " + building));

        // Пошук будівлі з найбільшою площею
        Optional<Building> largestBuilding = container.findMaxArea();
        largestBuilding.ifPresent(building ->
                System.out.println("\nБудівля з найбільшою площею: " + building));

        // Пошук будівлі з найбільшою кількістю поверхів
        Optional<Building> tallestByFloors = container.findMaxFloors();
        tallestByFloors.ifPresent(building ->
                System.out.println("\nБудівля з найбільшою кількістю поверхів: " + building));

        // Пошук найстарішої будівлі
        Optional<Building> oldestBuilding = container.findOldestBuilding();
        oldestBuilding.ifPresent(building ->
                System.out.println("\nНайстаріша будівля: " + building));

        // Сортування за роком побудови
        System.out.println("\nБудівлі відсортовані за роком побудови (від новіших до старіших):");
        for (Building building : container.sortByYearBuilt()) {
            System.out.println(building);
        }

        // Приклад видалення будівлі
        System.out.println("\nВидалення найстарішої будівлі 'House'...");
        container.removeBuilding(oldestBuilding.orElse(null)); // Видалення найстарішої будівлі

        // Виведення всіх будівель після видалення
        System.out.println("Усі будівлі після видалення:");
        for (Building building : container.getAllBuildings()) {
            System.out.println(building);
        }
    }

    // Метод для створення контейнера з будівлями
    private static BuildingContainer<Building> getBuildingContainer() {
        Building building1 = new Building("Skyscraper", 300.5, 50000, 60, "Комерційний", 1995);
        Building building2 = new Building("Apartment", 100.2, 2000, 15, "Житловий", 1980);
        Building building3 = new Building("House", 15.7, 300, 2, "Житловий", 1920);

        // Створення екземпляра контейнера
        BuildingContainer<Building> container = new BuildingContainer<>();

        // Додавання будівель до контейнера
        container.addBuilding(building1);
        container.addBuilding(building2);
        container.addBuilding(building3);

        return container;
    }
}
