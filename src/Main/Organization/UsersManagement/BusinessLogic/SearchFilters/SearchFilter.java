package src.Main.Organization.UsersManagement.BusinessLogic.SearchFilters;

import src.Main.Organization.UsersManagement.Domain.User;

public interface SearchFilter
{
    boolean matches(User u, String param);
}
