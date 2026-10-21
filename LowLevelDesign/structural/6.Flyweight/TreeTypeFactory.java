package structural.flyweight.tree;
import java.util.*;

public class TreeTypeFactory
{
    static HashMap<String, TreeType> hmap = new HashMap<>();
    static boolean useCache = true;

    public static TreeType getTreeType(String name, String color, String texture_value)
    {
        TreeType result;
        if(!useCache)
            return new TreeType(name, color, texture_value);
        if(!hmap.containsKey(name+"|"+color))
        {
            result = new TreeType(name, color, texture_value);
            hmap.put(name+"|"+color, result);
        }
        else
            result = hmap.get(name+"|"+color);

        return result;
    }
}