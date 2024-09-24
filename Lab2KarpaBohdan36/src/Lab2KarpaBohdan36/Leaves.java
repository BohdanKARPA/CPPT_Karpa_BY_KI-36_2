package Lab2KarpaBohdan36;

/**
 * Клас, що представляє листя рослини.
 */
public class Leaves {
    private String leafShape;

    public Leaves(String leafShape) {
        this.leafShape = leafShape;
    }

    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    @Override
    public String toString() {
        return "Форма листя: " + leafShape;
    }
}
