package src.Main.Organization.ReportsManagement.BusinessLogic;

import src.Main.Organization.ReportsManagement.Domain.Report;

public interface SearchFilter
{
    boolean matches(Report r, String param);
}
