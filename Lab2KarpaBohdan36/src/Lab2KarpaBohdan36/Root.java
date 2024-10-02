package Lab2KarpaBohdan36;

/**
 * Клас, що представляє корінь рослини.
 */
public class Root {
    private String rootType;

    /**
     * Конструктор, що ініціалізує тип кореня.
     * @param rootType Тип кореня (мочкуватий або стрижневий).
     */
    public Root(String rootType) {
        this.rootType = rootType;
    }

    /**
     * Метод для отримання типу кореня.
     * @return Тип кореня.
     */
    public String getRootType() {
        return rootType;
    }

    /**
     * Метод для зміни типу кореня.
     * @param rootType Новий тип кореня.
     */
    public void setRootType(String rootType) {
        this.rootType = rootType;
    }

    @Override
    public String toString() {
        return "Тип кореня: " + rootType;
    }
}