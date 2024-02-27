package src.Main.Organization.ReportsManagement.BusinessLogic;

import src.Main.Organization.ReportsManagement.DataAccess.IReportDao;
import src.Main.Organization.ReportsManagement.Domain.Report;

import java.util.List;

public class ReportsController
{
    private final IReportDao reportDao;

    public ReportsController(IReportDao reportDao)
    {
        this.reportDao = reportDao;
    }

    public List<Report> searchMission(Object param)
    {
        return reportDao.searchMission(param);
    }

    public List<Report> getLastReports(int count)
    {
        return reportDao.getLastReports(count);
    }

    public Report fetchFullReport(String id)
    {
        return reportDao.getFullReportById(id);
    }
}
