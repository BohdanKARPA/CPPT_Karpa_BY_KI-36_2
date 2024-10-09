package Lab3KarpaBohdan36;

/**
 * Інтерфейс Growable містить метод для зростання.
 */
interface Growable {
    void grow(double increment); // Метод для зростання рослини
}

/**
 * Інтерфейс FruitBearing розширює Growable, додаючи нові методи.
 */
interface FruitBearing extends Growable {
    void bearFruit(); // Метод для плодоношення
    int getFruitCount(); // Метод для отримання кількості плодів
}

/**
 * Клас Tree реалізує інтерфейси Growable і FruitBearing.
 */
public class Tree extends Plant implements FruitBearing {
    private String treeType;
    private int fruitCount;

    public Tree(Root root, Stem stem, Leaves leaves, String treeType) {
        super(root, stem, leaves);
        this.treeType = treeType;
        this.fruitCount = 0; // Кількість плодів спочатку 0
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    @Override
    public String getDescription() {
        return "Дерево типу: " + treeType + "\n" +
                getRoot().toString() + "\n" +
                getStem().toString() + "\n" +
                getLeaves().toString() + "\n" +
                "Кількість плодів: " + fruitCount; // Додано опис для кількості плодів
    }

    @Override
    public void grow(double increment) {
        double newHeight = getStem().getHeight() + increment;
        getStem().setHeight(newHeight);
        System.out.println("Дерево виросло на " + increment + " см, нова висота: " + newHeight + " см.");
        bearFruit(); // Викликаємо метод bearFruit() при зростанні дерева
    }

    @Override
    public void bearFruit() {
        fruitCount += 10; // Наприклад, після кожного зростання з'являється 10 нових плодів
        System.out.println("Дерево принесло 10 нових плодів. Загальна кількість плодів: " + fruitCount);
    }

    @Override
    public int getFruitCount() {
        return fruitCount;
    }
}
