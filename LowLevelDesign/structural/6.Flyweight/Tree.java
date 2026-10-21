package structural.flyweight.tree;

public class Tree
{
    int pos_x, pos_y;
    TreeType treetype;

    public Tree(int pos_x, int pos_y, TreeType treetype)
    {
        // System.out.println("Creting tree");
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.treetype = treetype;

    }
    public void render()
    {
        System.out.println("Rendering tree");
    }
}