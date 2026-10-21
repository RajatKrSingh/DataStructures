package structural.composite.organization;

public class Department extends OrganizationEntity
{
    private String department_name;
    public Department(String name, int department_id)
    {
        super(department_id);
        this.department_name = name;
    }
    @Override
    public void show()
    {
        System.out.print(" ".repeat(5)+this.department_name);
    }
}