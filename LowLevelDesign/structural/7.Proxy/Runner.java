package structural.proxy.runner;

import structural.proxy.document.*;
import structural.proxy.proxy.*;

public class Runner
{
    public static void main(String args[])
    {
        String filename = "confidential.pdf";
        System.out.println("*".repeat(15)+"ACCESS 1"+ "*".repeat(15));
        Document mydocument = new DocumentProxy(filename, "Analyst");
        mydocument.read();

        System.out.println("*".repeat(15)+ "ACCESS 2"+ "*".repeat(15));
        mydocument = new DocumentProxy(filename, "Admin");
        mydocument.read();
    }
}