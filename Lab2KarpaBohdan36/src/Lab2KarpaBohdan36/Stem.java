package Lab2KarpaBohdan36;

/**
 * Клас, що представляє стебло рослини.
 */
public class Stem {
    private double height;

    public Stem(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Висота стебла: " + height + " см";
    }
}
