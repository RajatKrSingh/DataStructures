package structural.composite.organization;

public abstract class OrganizationEntity
{
    private int id;
    public OrganizationEntity()
    {
        this.id = 0;
    }
    public OrganizationEntity(int id)
    {
        this.id = id;
    }
    public abstract void show();
}