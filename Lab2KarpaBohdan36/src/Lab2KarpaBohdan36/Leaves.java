package Lab2KarpaBohdan36;

/**
 * Клас, що представляє листя рослини.
 */
public class Leaves {
    private String leafShape;

    /**
     * Конструктор, що ініціалізує форму листя.
     * @param leafShape Форма листя.
     */
    public Leaves(String leafShape) {
        this.leafShape = leafShape;
    }

    /**
     * Метод для отримання форми листя.
     * @return Форма листя.
     */
    public String getLeafShape() {
        return leafShape;
    }

    /**
     * Метод для зміни форми листя.
     * @param leafShape Нова форма листя.
     */
    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    @Override
    public String toString() {
        return "Форма листя: " + leafShape;
    }
}