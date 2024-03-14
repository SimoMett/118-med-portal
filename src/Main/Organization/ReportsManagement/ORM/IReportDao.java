package src.Main.Organization.ReportsManagement.ORM;

import src.Main.Organization.ReportsManagement.BusinessLogic.SearchFilter;
import src.Main.Organization.ReportsManagement.Domain.Report;

import java.util.List;

public interface IReportDao
{
    List<Report> searchMission(SearchFilter filter, String param);
    List<Report> getLastReports(int count);
    Report getReportById(String id);
    Report getFullReportById(String id);
}
