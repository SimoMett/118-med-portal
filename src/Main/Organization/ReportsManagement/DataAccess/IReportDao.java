package src.Main.Organization.ReportsManagement.DataAccess;

import src.Main.Organization.ReportsManagement.Domain.Report;

import java.util.List;

public interface IReportDao
{
    List<Report> searchMission(Object param);
    List<Report> getLastReports(int count);
    Report getReportById(String id);
    Report getFullReportById(String id);
}
