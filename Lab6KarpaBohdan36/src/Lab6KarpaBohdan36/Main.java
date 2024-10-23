package Lab6KarpaBohdan36;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Створення екземплярів будівель
        BuildingContainer<Building> container = getBuildingContainer();

        // Виведення всіх будівель
        StringBuilder output = new StringBuilder("=== Усі будівлі ===\n");
        for (Building building : container.getAllBuildings()) {
            output.append(building).append('\n');
        }
        System.out.print(output.toString());

        // Пошук будівлі з найбільшою висотою
        Optional<Building> tallestBuilding = container.findMaxHeight();
        tallestBuilding.ifPresent(building -> {
            output.setLength(0); // Очищення StringBuilder
            output.append("\n=== Найвища будівля ===\n").append(building);
            System.out.println(output);
        });

        // Пошук будівлі з найбільшою площею
        Optional<Building> largestBuilding = container.findMaxArea();
        largestBuilding.ifPresent(building -> {
            output.setLength(0); // Очищення StringBuilder
            output.append("\n=== Будівля з найбільшою площею ===\n").append(building);
            System.out.println(output);
        });

        // Пошук будівлі з найбільшою кількістю поверхів
        Optional<Building> tallestByFloors = container.findMaxFloors();
        tallestByFloors.ifPresent(building -> {
            output.setLength(0); // Очищення StringBuilder
            output.append("\n=== Будівля з найбільшою кількістю поверхів ===\n").append(building);
            System.out.println(output);
        });

        // Пошук найстарішої будівлі
        Optional<Building> oldestBuilding = container.findOldestBuilding();
        oldestBuilding.ifPresent(building -> {
            output.setLength(0); // Очищення StringBuilder
            output.append("\n=== Найстаріша будівля ===\n").append(building);
            System.out.println(output);
        });

        // Сортування за роком побудови
        output.setLength(0); // Очищення StringBuilder
        output.append("\n=== Будівлі відсортовані за роком побудови (від новіших до старіших) ===\n");
        for (Building building : container.sortByYearBuilt()) {
            output.append(building).append('\n');
        }
        System.out.print(output.toString());

        // Приклад видалення будівлі
        System.out.println("\nВидалення найстарішої будівлі 'House'...");
        container.removeBuilding(oldestBuilding.orElse(null)); // Видалення найстарішої будівлі

        // Виведення всіх будівель після видалення
        output.setLength(0); // Очищення StringBuilder
        output.append("=== Усі будівлі після видалення ===\n");
        for (Building building : container.getAllBuildings()) {
            output.append(building).append('\n');
        }
        System.out.print(output.toString());
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
