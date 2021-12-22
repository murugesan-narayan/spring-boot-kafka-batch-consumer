package com.muru.kafka.consumer.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.StringJoiner;

import static org.springframework.util.StringUtils.quote;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlarmMessage {
    @JsonProperty("NetcoolEventAction") private String NetcoolEventAction; //5-10
    @JsonProperty("Identifier") private String Identifier; //120
    @JsonProperty("Node") private String Node; //20
    @JsonProperty("NodeAlias") private String NodeAlias; //12
    @JsonProperty("Manager") private String Manager; //20
    @JsonProperty("Agent") private String Agent; //30
    @JsonProperty("AlertGroup") private String AlertGroup; //15
    @JsonProperty("AlertKey") private String AlertKey; //50
    @JsonProperty("Severity") private String Severity; //1,
    @JsonProperty("Summary") private String Summary; //50
    @JsonProperty("StateChange") private String StateChange; //20
    @JsonProperty("FirstOccurrence") private String FirstOccurrence; //2021-11-29 12:45:13
    @JsonProperty("LastOccurrence") private String LastOccurrence; //2021-12-15 12:27:20
    @JsonProperty("InternalLast") private String InternalLast; //2021-12-15T12:27:28
    @JsonProperty("Poll") private String Poll;   //1
    @JsonProperty("Type") private String Type;   //1
    @JsonProperty("Tally") private String Tally;  //4
    @JsonProperty("Class") private String ClassData;  //6
    @JsonProperty("Grade") private String Grade;  //1
    @JsonProperty("Location") private String Location; //10
    @JsonProperty("OwnerUID") private String OwnerUID;   //5
    @JsonProperty("OwnerGID") private String OwnerGID;   //1
    @JsonProperty("Acknowledged") private String Acknowledged;   //1
    @JsonProperty("Flash") private String Flash;   //1
    @JsonProperty("EventId") private String EventId; //60
    @JsonProperty("ExpireTime") private String ExpireTime;   //1
    @JsonProperty("ProcessReq") private String ProcessReq;   //1
    @JsonProperty("SuppressEscl") private String SuppressEscl;   //2
    @JsonProperty("Customer") private String Customer;    //10
    @JsonProperty("PhysicalSlot") private String PhysicalSlot;   //1
    @JsonProperty("PhysicalPort") private String PhysicalPort;   //1
    @JsonProperty("TaskList") private String TaskList;   //1
    @JsonProperty("NmosSerial") private String NmosSerial;  //5
    @JsonProperty("NmosObjInst") private String NmosObjInst;    //1
    @JsonProperty("NmosCauseType") private String NmosCauseType;  //1
    @JsonProperty("NmosDomainName") private String NmosDomainName;  //5
    @JsonProperty("NmosEntityId") private String NmosEntityId;   //1
    @JsonProperty("NmosManagedStatus") private String NmosManagedStatus;  //1
    @JsonProperty("NmosEventMap") private String NmosEventMap;    //10
    @JsonProperty("LocalNodeAlias") private String LocalNodeAlias;  //10
    @JsonProperty("LocalPriObj") private String LocalPriObj; //1
    @JsonProperty("LocalSecObj") private String LocalSecObj; //1
    @JsonProperty("LocalRootObj") private String LocalRootObj;    //1
    @JsonProperty("X733EventType") private String X733EventType;  //3
    @JsonProperty("X733ProbableCause") private String X733ProbableCause;  //1
    @JsonProperty("X733SpecificProb") private String X733SpecificProb;    //1
    @JsonProperty("X733CorrNotif") private String X733CorrNotif;   //1
    @JsonProperty("URL") private String URL; //15
    @JsonProperty("ExtendedAttr") private String ExtendedAttr;    //15
    @JsonProperty("OldRow") private String OldRow; //1
    @JsonProperty("ProbeSubSecondId") private String ProbeSubSecondId;   //3
    @JsonProperty("BSM_Identity") private String BSM_Identity;    //1
    @JsonProperty("CollectionFirst") private String CollectionFirst; //1970-01-01T01:00:00
    @JsonProperty("AggregationFirst") private String AggregationFirst;  //2021-11-29T12:45:17
    @JsonProperty("AcknowledgeUID") private String AcknowledgeUID;  //3
    @JsonProperty("ToggleCount") private String ToggleCount;    //1
    @JsonProperty("ToggleDelay") private String ToggleDelay;    //1
    @JsonProperty("EscalateFlag") private String EscalateFlag;    //1
    @JsonProperty("Family") private String Family;  //1
    @JsonProperty("OnCall") private String OnCall;  //1
    @JsonProperty("Ticket") private String Ticket;  //15
    @JsonProperty("OldSeverity") private String OldSeverity;    //1
    @JsonProperty("OldOccurrence") private String OldOccurrence;   //2021-11-29T12:45:13
    @JsonProperty("DeduplicationOrder") private String DeduplicationOrder;    //1
    @JsonProperty("CurrentSince") private String CurrentSince;    //2021-11-29 12:45:13
    @JsonProperty("Site") private String Site;   //10
    @JsonProperty("ParentElement") private String ParentElement;  //1
    @JsonProperty("Department") private String Department;  //1
    @JsonProperty("IncidentID") private String IncidentID;  //1
    @JsonProperty("DevicePrio") private String DevicePrio;    //1
    @JsonProperty("OperatorNote") private String OperatorNote;   //50
    @JsonProperty("HighFlappingEndCount") private String HighFlappingEndCount;    //1
    @JsonProperty("HighFlappingEndTime") private String HighFlappingEndTime; //1970-01-01T01:00:00
    @JsonProperty("HighFlappingCount") private String HighFlappingCount;    //1
    @JsonProperty("HighFlappingWindow") private String HighFlappingWindow;    //1
    @JsonProperty("LowFlappingEndCount") private String LowFlappingEndCount;    //1
    @JsonProperty("LowFlappingEndTime") private String LowFlappingEndTime;  //1970-01-01T01:00:00
    @JsonProperty("LowFlappingCount") private String LowFlappingCount;    //1
    @JsonProperty("LowFlappingWindow") private String LowFlappingWindow;    //1
    @JsonProperty("WatchList") private String WatchList;  //1
    @JsonProperty("TicketAction") private String TicketAction;   //3
    @JsonProperty("DiagInfo") private String DiagInfo;   //1
    @JsonProperty("AlertKeyAlias") private String AlertKeyAlias;   //50
    @JsonProperty("EMSAlarmId") private String EMSAlarmId;    //1
    @JsonProperty("XinY") private String XinY;  //1
    @JsonProperty("Info1") private String Info1;  //1
    @JsonProperty("Info2") private String Info2;  //1
    @JsonProperty("CallOut") private String CallOut;    //1
    @JsonProperty("ServiceImpact") private String ServiceImpact;    //1
    @JsonProperty("ServicePrio") private String ServicePrio;    //1
    @JsonProperty("Lon") private String Lon;  //1
    @JsonProperty("Lat") private String Lat;  //1
    @JsonProperty("ManagedFlag") private String ManagedFlag;   //2
    @JsonProperty("UTSAOT") private String UTSAOT;  //1
    @JsonProperty("RCACauseType") private String RCACauseType;    //1
    @JsonProperty("RCAEventType") private String RCAEventType;  //1
    @JsonProperty("RCAIdentifier") private String RCAIdentifier;  //1
    @JsonProperty("RCAOrgSeverity") private String RCAOrgSeverity;    //1
    @JsonProperty("RCAProblemText") private String RCAProblemText;  //1
    @JsonProperty("RCAStateChange") private String RCAStateChange;  //2021-11-29T14:35:42
    @JsonProperty("RemoteNodeAlias") private String RemoteNodeAlias;  //1
    @JsonProperty("RemotePriObj") private String RemotePriObj;  //1
    @JsonProperty("RemoteRootObj") private String RemoteRootObj;  //1
    @JsonProperty("RemoteSecObj") private String RemoteSecObj;  //1
    @JsonProperty("Service") private String Service;  //1
    @JsonProperty("SEServiceName") private String SEServiceName;  //1
    @JsonProperty("SEProblemText") private String SEProblemText;  //1
    @JsonProperty("SEServiceType") private String SEServiceType;    //1
    @JsonProperty("SEState") private String SEState;    //1
    @JsonProperty("Layer") private String Layer;    //1
    @JsonProperty("ClusterName") private String ClusterName;  //1
    @JsonProperty("ClusterSize") private String ClusterSize;    //1
    @JsonProperty("MonitoringOptions") private String MonitoringOptions;  //1
    @JsonProperty("UseType") private String UseType;  //1
    @JsonProperty("UTSTime1") private String UTSTime1;    //2021-11-29T14:35:42
    @JsonProperty("RCAOldSeverity") private String RCAOldSeverity;    //1
    @JsonProperty("Parked") private String Parked;    //1
    @JsonProperty("FrontOffice") private String FrontOffice;   //3
    @JsonProperty("Region") private String Region;    //1
    @JsonProperty("AlarmHelp") private String AlarmHelp;  //1
    @JsonProperty("OIDKey") private String OIDKey;   //90
    @JsonProperty("OIDVisible") private String OIDVisible;    //1
    @JsonProperty("ClassVisible") private String ClassVisible;    //1
    @JsonProperty("NodeVisible") private String NodeVisible;    //1
    @JsonProperty("NodeValue") private String NodeValue;    //1
    @JsonProperty("ParentIdentifier") private String ParentIdentifier;  //1
    @JsonProperty("IBMExtractedType") private String IBMExtractedType;  //1
    @JsonProperty("IBMProcessingStage") private String IBMProcessingStage;    //1
    @JsonProperty("ServerName") private String ServerName;   //7
    @JsonProperty("ServerSerial") private String ServerSerial;   //10

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(quote(this.NetcoolEventAction));
        joiner.add(quote(this.Identifier));
        joiner.add(quote(this.Node));
        joiner.add(quote(this.NodeAlias));
        joiner.add(quote(this.Manager));
        joiner.add(quote(this.Agent));
        joiner.add(quote(this.AlertGroup));
        joiner.add(quote(this.AlertKey));
        joiner.add(quote(this.Severity));
        joiner.add(quote(this.Summary));
        joiner.add(quote(this.StateChange));
        joiner.add(quote(this.FirstOccurrence));
        joiner.add(quote(this.LastOccurrence));
        joiner.add(quote(this.InternalLast));
        joiner.add(quote(this.Poll));
        joiner.add(quote(this.Type));
        joiner.add(quote(this.Tally));
        joiner.add(quote(this.ClassData));
        joiner.add(quote(this.Grade));
        joiner.add(quote(this.Location));
        joiner.add(quote(this.OwnerUID));
        joiner.add(quote(this.OwnerGID));
        joiner.add(quote(this.Acknowledged));
        joiner.add(quote(this.Flash));
        joiner.add(quote(this.EventId));
        joiner.add(quote(this.ExpireTime));
        joiner.add(quote(this.ProcessReq));
        joiner.add(quote(this.SuppressEscl));
        joiner.add(quote(this.Customer));
        joiner.add(quote(this.PhysicalSlot));
        joiner.add(quote(this.PhysicalPort));
        joiner.add(quote(this.TaskList));
        joiner.add(quote(this.NmosSerial));
        joiner.add(quote(this.NmosObjInst));
        joiner.add(quote(this.NmosCauseType));
        joiner.add(quote(this.NmosDomainName));
        joiner.add(quote(this.NmosEntityId));
        joiner.add(quote(this.NmosManagedStatus));
        joiner.add(quote(this.NmosEventMap));
        joiner.add(quote(this.LocalNodeAlias));
        joiner.add(quote(this.LocalPriObj));
        joiner.add(quote(this.LocalSecObj));
        joiner.add(quote(this.LocalRootObj));
        joiner.add(quote(this.X733EventType));
        joiner.add(quote(this.X733ProbableCause));
        joiner.add(quote(this.X733SpecificProb));
        joiner.add(quote(this.X733CorrNotif));
        joiner.add(quote(this.URL));
        joiner.add(quote(this.ExtendedAttr));
        joiner.add(quote(this.OldRow));
        joiner.add(quote(this.ProbeSubSecondId));
        joiner.add(quote(this.BSM_Identity));
        joiner.add(quote(this.CollectionFirst));
        joiner.add(quote(this.AggregationFirst));
        joiner.add(quote(this.AcknowledgeUID));
        joiner.add(quote(this.ToggleCount));
        joiner.add(quote(this.ToggleDelay));
        joiner.add(quote(this.EscalateFlag));
        joiner.add(quote(this.Family));
        joiner.add(quote(this.OnCall));
        joiner.add(quote(this.Ticket));
        joiner.add(quote(this.OldSeverity));
        joiner.add(quote(this.OldOccurrence));
        joiner.add(quote(this.DeduplicationOrder));
        joiner.add(quote(this.CurrentSince));
        joiner.add(quote(this.Site));
        joiner.add(quote(this.ParentElement));
        joiner.add(quote(this.Department));
        joiner.add(quote(this.IncidentID));
        joiner.add(quote(this.DevicePrio));
        joiner.add(quote(this.OperatorNote));
        joiner.add(quote(this.HighFlappingEndCount));
        joiner.add(quote(this.HighFlappingEndTime));
        joiner.add(quote(this.HighFlappingCount));
        joiner.add(quote(this.HighFlappingWindow));
        joiner.add(quote(this.LowFlappingEndCount));
        joiner.add(quote(this.LowFlappingEndTime));
        joiner.add(quote(this.LowFlappingCount));
        joiner.add(quote(this.LowFlappingWindow));
        joiner.add(quote(this.WatchList));
        joiner.add(quote(this.TicketAction));
        joiner.add(quote(this.DiagInfo));
        joiner.add(quote(this.AlertKeyAlias));
        joiner.add(quote(this.EMSAlarmId));
        joiner.add(quote(this.XinY));
        joiner.add(quote(this.Info1));
        joiner.add(quote(this.Info2));
        joiner.add(quote(this.CallOut));
        joiner.add(quote(this.ServiceImpact));
        joiner.add(quote(this.ServicePrio));
        joiner.add(quote(this.Lon));
        joiner.add(quote(this.Lat));
        joiner.add(quote(this.ManagedFlag));
        joiner.add(quote(this.UTSAOT));
        joiner.add(quote(this.RCACauseType));
        joiner.add(quote(this.RCAEventType));
        joiner.add(quote(this.RCAIdentifier));
        joiner.add(quote(this.RCAOrgSeverity));
        joiner.add(quote(this.RCAProblemText));
        joiner.add(quote(this.RCAStateChange));
        joiner.add(quote(this.RemoteNodeAlias));
        joiner.add(quote(this.RemotePriObj));
        joiner.add(quote(this.RemoteRootObj));
        joiner.add(quote(this.RemoteSecObj));
        joiner.add(quote(this.Service));
        joiner.add(quote(this.SEServiceName));
        joiner.add(quote(this.SEProblemText));
        joiner.add(quote(this.SEServiceType));
        joiner.add(quote(this.SEState));
        joiner.add(quote(this.Layer));
        joiner.add(quote(this.ClusterName));
        joiner.add(quote(this.ClusterSize));
        joiner.add(quote(this.MonitoringOptions));
        joiner.add(quote(this.UseType));
        joiner.add(quote(this.UTSTime1));
        joiner.add(quote(this.RCAOldSeverity));
        joiner.add(quote(this.Parked));
        joiner.add(quote(this.FrontOffice));
        joiner.add(quote(this.Region));
        joiner.add(quote(this.AlarmHelp));
        joiner.add(quote(this.OIDKey));
        joiner.add(quote(this.OIDVisible));
        joiner.add(quote(this.ClassVisible));
        joiner.add(quote(this.NodeVisible));
        joiner.add(quote(this.NodeValue));
        joiner.add(quote(this.ParentIdentifier));
        joiner.add(quote(this.IBMExtractedType));
        joiner.add(quote(this.IBMProcessingStage));
        joiner.add(quote(this.ServerName));
        joiner.add(quote(this.ServerSerial));

        return joiner.toString();
    }

    public static String getHeader() {
        return "'NetcoolEventAction','Identifier','Node','NodeAlias','Manager','Agent','AlertGroup','AlertKey','Severity','Summary','StateChange','FirstOccurrence','LastOccurrence','InternalLast','Poll','Type','Tally','Class','Grade','Location','OwnerUID','OwnerGID','Acknowledged','Flash','EventId','ExpireTime','ProcessReq','SuppressEscl','Customer','PhysicalSlot','PhysicalPort','TaskList','NmosSerial','NmosObjInst','NmosCauseType','NmosDomainName','NmosEntityId','NmosManagedStatus','NmosEventMap','LocalNodeAlias','LocalPriObj','LocalSecObj','LocalRootObj','X733EventType','X733ProbableCause','X733SpecificProb','X733CorrNotif','URL','ExtendedAttr','OldRow','ProbeSubSecondId','BSM_Identity','CollectionFirst','AggregationFirst','AcknowledgeUID','ToggleCount','ToggleDelay','EscalateFlag','Family','OnCall','Ticket','OldSeverity','OldOccurrence','DeduplicationOrder','CurrentSince','Site','ParentElement','Department','IncidentID','DevicePrio','OperatorNote','HighFlappingEndCount','HighFlappingEndTime','HighFlappingCount','HighFlappingWindow','LowFlappingEndCount','LowFlappingEndTime','LowFlappingCount','LowFlappingWindow','WatchList','TicketAction','DiagInfo','AlertKeyAlias','EMSAlarmId','XinY','Info1','Info2','CallOut','ServiceImpact','ServicePrio','Lon','Lat','ManagedFlag','UTSAOT','RCACauseType','RCAEventType','RCAIdentifier','RCAOrgSeverity','RCAProblemText','RCAStateChange','RemoteNodeAlias','RemotePriObj','RemoteRootObj','RemoteSecObj','Service','SEServiceName','SEProblemText','SEServiceType','SEState','Layer','ClusterName','ClusterSize','MonitoringOptions','UseType','UTSTime1','RCAOldSeverity','Parked','FrontOffice','Region','AlarmHelp','OIDKey','OIDVisible','ClassVisible','NodeVisible','NodeValue','ParentIdentifier','IBMExtractedType','IBMProcessingStage','ServerName','ServerSerial'";
    }
}