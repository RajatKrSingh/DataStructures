package structural.flyweight.tree;
import java.util.*;

public class Forest
{   
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int pos_x, int pos_y, String name, String color, String treetexturedata) {
        TreeType type = TreeTypeFactory.getTreeType(name, color, treetexturedata);
        Tree tree = new Tree(pos_x, pos_y, type);
        trees.add(tree);
    }
}