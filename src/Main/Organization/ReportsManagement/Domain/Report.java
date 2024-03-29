package src.Main.Organization.ReportsManagement.Domain;

import src.Main.Organization.ReportsManagement.ReportPrimaryInfo;

import static src.Main.Ems.Domain.Mission.MissionReport.throwIfInvalidMissionId;

//      <<proxy>>
public class Report
{
    private final String id;
    private ReportPrimaryInfo primaryInfo;
    private Object fullReport; //proxy member

    public Report(String id)
    {
        //"id" should be in the format 03/XX/XXXX where X is a number
        throwIfInvalidMissionId(id);

        this.id = id;
        //TODO initialize this.primaryInfo
        this.fullReport = null;
    }

    public ReportPrimaryInfo getInfo()
    {
        return primaryInfo;
    }

    public Object getFullReport()
    {
        return fullReport;
    }
}
