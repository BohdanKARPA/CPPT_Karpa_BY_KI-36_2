package Lab3KarpaBohdan36;

/**
 * Клас, що представляє стебло рослини.
 */
public class Stem {
    private double height;

    /**
     * Конструктор, що ініціалізує висоту стебла.
     *
     * @param height Висота стебла в сантиметрах.
     */
    public Stem(double height) {
        this.height = height;
    }

    /**
     * Метод для отримання висоти стебла.
     *
     * @return Висота стебла.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Метод для зміни висоти стебла.
     *
     * @param height Нова висота стебла.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Метод для отримання рядкового представлення об'єкта Stem.
     * @return Рядкове представлення висоти стебла.
     */
    @Override
    public String toString() {
        return "Висота стебла: " + height + " см";
    }
}