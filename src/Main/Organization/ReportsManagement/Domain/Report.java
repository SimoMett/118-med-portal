package src.Main.Organization.ReportsManagement.Domain;

import src.Main.Organization.ReportsManagement.ReportPrimaryInfo;

//      <<proxy>>
public class Report
{
    private final String id;
    private ReportPrimaryInfo primaryInfo;
    private Object fullReport; //proxy member

    public Report(String id)
    {
        //"id" should be in the format 03/XX/XXXX where X is a number
        String[] strings = id.split("/", 2);
        for(String s : strings)
            Integer.parseInt(s);

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
