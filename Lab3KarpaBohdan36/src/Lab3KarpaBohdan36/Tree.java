package Lab3KarpaBohdan36;

public class Tree extends Plant implements Growable {
    private String treeType;

    public Tree(Root root, Stem stem, Leaves leaves, String treeType) {
        super(root, stem, leaves);
        this.treeType = treeType;
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
                getLeaves().toString();
    }

    @Override
    public void grow(double increment) {
        double newHeight = getStem().getHeight() + increment;
        getStem().setHeight(newHeight);
        System.out.println("Дерево виросло на " + increment + " см, нова висота: " + newHeight + " см.");
    }
}
