package Lab6KarpaBohdan36;

public class Main {
    public static void main(String[] args) {
        // Створюємо кілька об'єктів класу Building
        Building skyscraper = new Building("Skyscraper", 300);
        Building cottage = new Building("Cottage", 12);
        Building tower = new Building("Tower", 50);

        // Створюємо контейнер для зберігання споруд
        BuildingContainer<Building> buildingContainer = new BuildingContainer<>();

        // Додаємо споруди до контейнера
        buildingContainer.addBuilding(skyscraper);
        buildingContainer.addBuilding(cottage);
        buildingContainer.addBuilding(tower);

        // Виводимо всі споруди
        System.out.println("All buildings:");
        buildingContainer.displayBuildings();

        // Шукаємо споруду з максимальною висотою
        Building maxBuilding = buildingContainer.getMaxHeightBuilding();
        System.out.println("\nBuilding with the maximum height:");
        if (maxBuilding != null) {
            System.out.println(maxBuilding);
        } else {
            System.out.println("No buildings found.");
        }
    }
}


