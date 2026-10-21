package structural.composite.organization;

public class Employee extends OrganizationEntity
{
    private String employee_name;
    public Employee(String name, int employee_id)
    {
        super(employee_id);
        this.employee_name = name;
    }
    @Override
    public void show()
    {
        System.out.print(" ".repeat(5)+this.employee_name);
    }
}