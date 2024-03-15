package src.Test.Organization.DummyDao;

import src.Main.Organization.ReportsManagement.BusinessLogic.SearchFilter;
import src.Main.Organization.ReportsManagement.DataAccess.IReportDao;
import src.Main.Organization.ReportsManagement.Domain.Report;

import java.util.List;

public class DummyReportDao implements IReportDao
{
    @Override
    public List<Report> searchMission(SearchFilter filter, String param)
    {
        return null;
    }

    @Override
    public List<Report> getLastReports(int count) {
        return null;
    }

    @Override
    public Report getReportById(String id) {
        return null;
    }

    @Override
    public Report getFullReportById(String id) {
        return null;
    }
}
