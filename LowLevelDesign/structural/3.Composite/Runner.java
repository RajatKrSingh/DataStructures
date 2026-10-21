package structural.composite.runner;

import structural.composite.organization.*;

public class Runner
{
    public static void main(String args[])
    {
        OrganizationEntity entity1 = new Department("Department1", 23), entity2 = new Employee("Employee1", 11);
        CompositeOrganization entity3 = new CompositeOrganization("Organization1");
        entity3.addOrganization(entity1);
        entity3.addOrganization(entity2);
        entity3.show();
    }
}