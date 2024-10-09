package Lab3KarpaBohdan36;

/**
 * Інтерфейс Growable містить метод для зростання.
 */
interface Growable {
    /**
     * Метод для зростання рослини на задане значення.
     * @param increment Значення, на яке рослина зросте.
     */
    void grow(double increment); // Метод для зростання рослини
}

/**
 * Інтерфейс FruitBearing розширює Growable, додаючи нові методи.
 */
interface FruitBearing extends Growable {
    /**
     * Метод для плодоношення рослини.
     */
    void bearFruit(); // Метод для плодоношення

    /**
     * Метод для отримання кількості плодів на рослині.
     * @return Кількість плодів.
     */
    int getFruitCount(); // Метод для отримання кількості плодів
}

/**
 * Клас Tree реалізує інтерфейси Growable і FruitBearing.
 */
public class Tree extends Plant implements FruitBearing {
    private String treeType;
    private int fruitCount;

    /**
     * Конструктор для ініціалізації дерева.
     * @param root Корінь дерева.
     * @param stem Стебло дерева.
     * @param leaves Листя дерева.
     * @param treeType Тип дерева.
     */
    public Tree(Root root, Stem stem, Leaves leaves, String treeType) {
        super(root, stem, leaves);
        this.treeType = treeType;
        this.fruitCount = 0; // Кількість плодів спочатку 0
    }

    /**
     * Метод для отримання типу дерева.
     * @return Тип дерева.
     */
    public String getTreeType() {
        return treeType;
    }

    /**
     * Метод для зміни типу дерева.
     * @param treeType Новий тип дерева.
     */
    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    /**
     * Метод для отримання опису дерева, включаючи його частини та кількість плодів.
     * @return Опис дерева.
     */
    @Override
    public String getDescription() {
        return "Дерево типу: " + treeType + "\n" +
                getRoot().toString() + "\n" +
                getStem().toString() + "\n" +
                getLeaves().toString() + "\n" +
                "Кількість плодів: " + fruitCount; // Додано опис для кількості плодів
    }

    /**
     * Метод для зростання дерева.
     * @param increment Значення, на яке дерево зросте.
     */
    @Override
    public void grow(double increment) {
        double newHeight = getStem().getHeight() + increment;
        getStem().setHeight(newHeight);
        System.out.println("Дерево виросло на " + increment + " см, нова висота: " + newHeight + " см.");
        bearFruit(); // Викликаємо метод bearFruit() при зростанні дерева
    }

    /**
     * Метод для плодоношення дерева, збільшує кількість плодів на 10.
     */
    @Override
    public void bearFruit() {
        fruitCount += 10; // Наприклад, після кожного зростання з'являється 10 нових плодів
        System.out.println("Дерево принесло 10 нових плодів. Загальна кількість плодів: " + fruitCount);
    }

    /**
     * Метод для отримання кількості плодів на дереві.
     * @return Кількість плодів.
     */
    @Override
    public int getFruitCount() {
        return fruitCount;
    }
}
