package Lab3KarpaBohdan36;

/**
 * Абстрактний клас, що представляє рослину.
 */
public abstract class Plant {
    private Root root;
    private Stem stem;
    private Leaves leaves;

    /**
     * Конструктор для ініціалізації частин рослини.
     * @param root Корінь рослини.
     * @param stem Стебло рослини.
     * @param leaves Листя рослини.
     */
    public Plant(Root root, Stem stem, Leaves leaves) {
        this.root = root;
        this.stem = stem;
        this.leaves = leaves;
    }

    // Абстрактний метод для опису рослини
    /**
     * Абстрактний метод, що повертає опис рослини.
     * @return Опис рослини.
     */
    public abstract String getDescription();

    /**
     * Метод для отримання кореня рослини.
     * @return Корінь рослини.
     */
    public Root getRoot() {
        return root;
    }

    /**
     * Метод для зміни кореня рослини.
     * @param root Новий корінь рослини.
     */
    public void setRoot(Root root) {
        this.root = root;
    }

    /**
     * Метод для отримання стебла рослини.
     * @return Стебло рослини.
     */
    public Stem getStem() {
        return stem;
    }

    /**
     * Метод для зміни стебла рослини.
     * @param stem Нове стебло рослини.
     */
    public void setStem(Stem stem) {
        this.stem = stem;
    }

    /**
     * Метод для отримання листя рослини.
     * @return Листя рослини.
     */
    public Leaves getLeaves() {
        return leaves;
    }

    /**
     * Метод для зміни листя рослини.
     * @param leaves Нове листя рослини.
     */
    public void setLeaves(Leaves leaves) {
        this.leaves = leaves;
    }
}