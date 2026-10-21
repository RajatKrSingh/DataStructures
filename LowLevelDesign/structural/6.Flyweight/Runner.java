package structural.flyweight.runner;

import structural.flyweight.tree.*;

public class Runner
{
    public static void main(String args[])
    {

        int TREES_TO_DRAW = 100000, TREE_TYPES = 2, CANVAS_SIZE = 10000;
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", "green", "Oak texture stub".repeat(1000));
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", "orange", "Autumn Oak texture stub".repeat(1000));
        }

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total allocated memory: "
                + totalMemory / (1024 * 1024) + " MB");

        System.out.println("Free memory in allocated heap: "
                + freeMemory / (1024 * 1024) + " MB");

        System.out.println("Used heap memory: "
                + usedMemory / (1024 * 1024) + " MB");
    }

    private static int random(int min, int max) 
    {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}