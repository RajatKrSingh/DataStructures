package structural.composite.organization;
import java.util.*;

public class CompositeOrganization extends OrganizationEntity
{
    List<OrganizationEntity> listOrganization;
    String organization_name;
    public CompositeOrganization(String name)
    {
        listOrganization = new ArrayList<>();
        this.organization_name = name;
    }
    public void addOrganization(OrganizationEntity entity)
    {
        this.listOrganization.add(entity);
    }
    @Override
    public void show()
    {
        System.out.print(this.organization_name);
        for(OrganizationEntity entity: listOrganization)
            entity.show();
    }
}