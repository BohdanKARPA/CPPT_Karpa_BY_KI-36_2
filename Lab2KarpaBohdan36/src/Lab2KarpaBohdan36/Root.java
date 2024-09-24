package Lab2KarpaBohdan36;

/**
 * Клас, що представляє корінь рослини.
 */
public class Root {
    private String rootType;

    public Root(String rootType) {
        this.rootType = rootType;
    }

    public String getRootType() {
        return rootType;
    }

    public void setRootType(String rootType) {
        this.rootType = rootType;
    }

    @Override
    public String toString() {
        return "Тип кореня: " + rootType;
    }
}
