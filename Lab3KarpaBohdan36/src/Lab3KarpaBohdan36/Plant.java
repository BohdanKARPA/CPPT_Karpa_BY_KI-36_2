package Lab3KarpaBohdan36;


public abstract class Plant {
    private Root root;
    private Stem stem;
    private Leaves leaves;

    public Plant(Root root, Stem stem, Leaves leaves) {
        this.root = root;
        this.stem = stem;
        this.leaves = leaves;
    }

    // Абстрактний метод для опису рослини
    public abstract String getDescription();

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Stem getStem() {
        return stem;
    }

    public void setStem(Stem stem) {
        this.stem = stem;
    }

    public Leaves getLeaves() {
        return leaves;
    }

    public void setLeaves(Leaves leaves) {
        this.leaves = leaves;
    }
}
