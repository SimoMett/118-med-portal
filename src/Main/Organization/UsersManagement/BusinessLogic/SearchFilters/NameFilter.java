package src.Main.Organization.UsersManagement.BusinessLogic.SearchFilters;

import src.Main.Organization.UsersManagement.Domain.User;

public class NameFilter implements SearchFilter
{
    @Override
    public boolean matches(User u, String param)
    {
        return u.getInfo().name().contains(param);
    }
}
