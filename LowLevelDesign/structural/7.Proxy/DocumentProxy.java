package structural.proxy.proxy;

import structural.proxy.document.*;

public class DocumentProxy implements Document
{
    private String fileName, userRole;
    public DocumentProxy(String fileName, String userRole)
    {
        this.fileName = fileName;
        this.userRole = userRole;
    }
    
    @Override
    public void read()
    {
        if(userRole!="Admin")
        {
            System.out.println("Access Denied");
            return;
        }
        Document mydoc = new RealDocument(fileName);
        mydoc.read(); 
    }
}