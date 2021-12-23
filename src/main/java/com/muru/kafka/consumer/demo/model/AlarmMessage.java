package com.muru.kafka.consumer.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.StringJoiner;

import static org.springframework.util.StringUtils.quote;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlarmMessage {
    @JsonProperty("NetcoolEventAction") private String netcoolEventAction; //5-10
    @JsonProperty("Identifier") private String identifier; //120
    @JsonProperty("Node") private String node; //20
    @JsonProperty("NodeAlias") private String nodeAlias; //12
    @JsonProperty("Manager") private String manager; //20
    @JsonProperty("Agent") private String agent; //30
    @JsonProperty("AlertGroup") private String alertGroup; //15
    @JsonProperty("AlertKey") private String alertKey; //50
    @JsonProperty("Severity") private String severity; //1,
    @JsonProperty("Summary") private String summary; //50
    @JsonProperty("StateChange") private String stateChange; //20
    @JsonProperty("FirstOccurrence") private String firstOccurrence; //2021-11-29 12:45:13
    @JsonProperty("LastOccurrence") private String lastOccurrence; //2021-12-15 12:27:20
    @JsonProperty("InternalLast") private String internalLast; //2021-12-15T12:27:28
    @JsonProperty("Poll") private String poll;   //1
    @JsonProperty("Type") private String type;   //1
    @JsonProperty("Tally") private String tally;  //4
    @JsonProperty("Class") private String classData;  //6
    @JsonProperty("Grade") private String grade;  //1
    @JsonProperty("Location") private String location; //10
    @JsonProperty("OwnerUID") private String ownerUID;   //5
    @JsonProperty("OwnerGID") private String ownerGID;   //1
    @JsonProperty("Acknowledged") private String acknowledged;   //1
    @JsonProperty("Flash") private String flash;   //1
    @JsonProperty("EventId") private String eventId; //60
    @JsonProperty("ExpireTime") private String expireTime;   //1
    @JsonProperty("ProcessReq") private String processReq;   //1
    @JsonProperty("SuppressEscl") private String suppressEscl;   //2
    @JsonProperty("Customer") private String customer;    //10
    @JsonProperty("PhysicalSlot") private String physicalSlot;   //1
    @JsonProperty("PhysicalPort") private String physicalPort;   //1
    @JsonProperty("TaskList") private String taskList;   //1
    @JsonProperty("NmosSerial") private String nmosSerial;  //5
    @JsonProperty("NmosObjInst") private String nmosObjInst;    //1
    @JsonProperty("NmosCauseType") private String nmosCauseType;  //1
    @JsonProperty("NmosDomainName") private String nmosDomainName;  //5
    @JsonProperty("NmosEntityId") private String nmosEntityId;   //1
    @JsonProperty("NmosManagedStatus") private String nmosManagedStatus;  //1
    @JsonProperty("NmosEventMap") private String nmosEventMap;    //10
    @JsonProperty("LocalNodeAlias") private String localNodeAlias;  //10
    @JsonProperty("LocalPriObj") private String localPriObj; //1
    @JsonProperty("LocalSecObj") private String localSecObj; //1
    @JsonProperty("LocalRootObj") private String localRootObj;    //1
    @JsonProperty("X733EventType") private String x733EventType;  //3
    @JsonProperty("X733ProbableCause") private String x733ProbableCause;  //1
    @JsonProperty("X733SpecificProb") private String x733SpecificProb;    //1
    @JsonProperty("X733CorrNotif") private String x733CorrNotif;   //1
    @JsonProperty("URL") private String url; //15
    @JsonProperty("ExtendedAttr") private String extendedAttr;    //15
    @JsonProperty("OldRow") private String oldRow; //1
    @JsonProperty("ProbeSubSecondId") private String probeSubSecondId;   //3
    @JsonProperty("BSM_Identity") private String bsmIdentity;    //1
    @JsonProperty("CollectionFirst") private String collectionFirst; //1970-01-01T01:00:00
    @JsonProperty("AggregationFirst") private String aggregationFirst;  //2021-11-29T12:45:17
    @JsonProperty("AcknowledgeUID") private String acknowledgeUID;  //3
    @JsonProperty("ToggleCount") private String toggleCount;    //1
    @JsonProperty("ToggleDelay") private String toggleDelay;    //1
    @JsonProperty("EscalateFlag") private String escalateFlag;    //1
    @JsonProperty("Family") private String family;  //1
    @JsonProperty("OnCall") private String onCall;  //1
    @JsonProperty("Ticket") private String ticket;  //15
    @JsonProperty("OldSeverity") private String oldSeverity;    //1
    @JsonProperty("OldOccurrence") private String oldOccurrence;   //2021-11-29T12:45:13
    @JsonProperty("DeduplicationOrder") private String deduplicationOrder;    //1
    @JsonProperty("CurrentSince") private String currentSince;    //2021-11-29 12:45:13
    @JsonProperty("Site") private String site;   //10
    @JsonProperty("ParentElement") private String parentElement;  //1
    @JsonProperty("Department") private String department;  //1
    @JsonProperty("IncidentID") private String incidentID;  //1
    @JsonProperty("DevicePrio") private String devicePrio;    //1
    @JsonProperty("OperatorNote") private String operatorNote;   //50
    @JsonProperty("HighFlappingEndCount") private String highFlappingEndCount;    //1
    @JsonProperty("HighFlappingEndTime") private String highFlappingEndTime; //1970-01-01T01:00:00
    @JsonProperty("HighFlappingCount") private String highFlappingCount;    //1
    @JsonProperty("HighFlappingWindow") private String highFlappingWindow;    //1
    @JsonProperty("LowFlappingEndCount") private String lowFlappingEndCount;    //1
    @JsonProperty("LowFlappingEndTime") private String lowFlappingEndTime;  //1970-01-01T01:00:00
    @JsonProperty("LowFlappingCount") private String lowFlappingCount;    //1
    @JsonProperty("LowFlappingWindow") private String lowFlappingWindow;    //1
    @JsonProperty("WatchList") private String watchList;  //1
    @JsonProperty("TicketAction") private String ticketAction;   //3
    @JsonProperty("DiagInfo") private String diagInfo;   //1
    @JsonProperty("AlertKeyAlias") private String alertKeyAlias;   //50
    @JsonProperty("EMSAlarmId") private String emsAlarmId;    //1
    @JsonProperty("XinY") private String xInY;  //1
    @JsonProperty("Info1") private String info1;  //1
    @JsonProperty("Info2") private String info2;  //1
    @JsonProperty("CallOut") private String callOut;    //1
    @JsonProperty("ServiceImpact") private String serviceImpact;    //1
    @JsonProperty("ServicePrio") private String servicePrio;    //1
    @JsonProperty("Lon") private String lon;  //1
    @JsonProperty("Lat") private String lat;  //1
    @JsonProperty("ManagedFlag") private String managedFlag;   //2
    @JsonProperty("UTSAOT") private String utsaot;  //1
    @JsonProperty("RCACauseType") private String rcaCauseType;    //1
    @JsonProperty("RCAEventType") private String rcaEventType;  //1
    @JsonProperty("RCAIdentifier") private String rcaIdentifier;  //1
    @JsonProperty("RCAOrgSeverity") private String rcaOrgSeverity;    //1
    @JsonProperty("RCAProblemText") private String rcaProblemText;  //1
    @JsonProperty("RCAStateChange") private String rcaStateChange;  //2021-11-29T14:35:42
    @JsonProperty("RemoteNodeAlias") private String remoteNodeAlias;  //1
    @JsonProperty("RemotePriObj") private String remotePriObj;  //1
    @JsonProperty("RemoteRootObj") private String remoteRootObj;  //1
    @JsonProperty("RemoteSecObj") private String remoteSecObj;  //1
    @JsonProperty("Service") private String service;  //1
    @JsonProperty("SEServiceName") private String seServiceName;  //1
    @JsonProperty("SEProblemText") private String seProblemText;  //1
    @JsonProperty("SEServiceType") private String seServiceType;    //1
    @JsonProperty("SEState") private String seState;    //1
    @JsonProperty("Layer") private String layer;    //1
    @JsonProperty("ClusterName") private String clusterName;  //1
    @JsonProperty("ClusterSize") private String clusterSize;    //1
    @JsonProperty("MonitoringOptions") private String monitoringOptions;  //1
    @JsonProperty("UseType") private String useType;  //1
    @JsonProperty("UTSTime1") private String utsTime1;    //2021-11-29T14:35:42
    @JsonProperty("RCAOldSeverity") private String rcaOldSeverity;    //1
    @JsonProperty("Parked") private String parked;    //1
    @JsonProperty("FrontOffice") private String frontOffice;   //3
    @JsonProperty("Region") private String region;    //1
    @JsonProperty("AlarmHelp") private String alarmHelp;  //1
    @JsonProperty("OIDKey") private String oidKey;   //90
    @JsonProperty("OIDVisible") private String oidVisible;    //1
    @JsonProperty("ClassVisible") private String classVisible;    //1
    @JsonProperty("NodeVisible") private String nodeVisible;    //1
    @JsonProperty("NodeValue") private String nodeValue;    //1
    @JsonProperty("ParentIdentifier") private String parentIdentifier;  //1
    @JsonProperty("IBMExtractedType") private String ibmExtractedType;  //1
    @JsonProperty("IBMProcessingStage") private String ibmProcessingStage;    //1
    @JsonProperty("ServerName") private String serverName;   //7
    @JsonProperty("ServerSerial") private String serverSerial;   //10

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(quote(this.netcoolEventAction));
        joiner.add(quote(this.identifier));
        joiner.add(quote(this.node));
        joiner.add(quote(this.nodeAlias));
        joiner.add(quote(this.manager));
        joiner.add(quote(this.agent));
        joiner.add(quote(this.alertGroup));
        joiner.add(quote(this.alertKey));
        joiner.add(quote(this.severity));
        joiner.add(quote(this.summary));
        joiner.add(quote(this.stateChange));
        joiner.add(quote(this.firstOccurrence));
        joiner.add(quote(this.lastOccurrence));
        joiner.add(quote(this.internalLast));
        joiner.add(quote(this.poll));
        joiner.add(quote(this.type));
        joiner.add(quote(this.tally));
        joiner.add(quote(this.classData));
        joiner.add(quote(this.grade));
        joiner.add(quote(this.location));
        joiner.add(quote(this.ownerUID));
        joiner.add(quote(this.ownerGID));
        joiner.add(quote(this.acknowledged));
        joiner.add(quote(this.flash));
        joiner.add(quote(this.eventId));
        joiner.add(quote(this.expireTime));
        joiner.add(quote(this.processReq));
        joiner.add(quote(this.suppressEscl));
        joiner.add(quote(this.customer));
        joiner.add(quote(this.physicalSlot));
        joiner.add(quote(this.physicalPort));
        joiner.add(quote(this.taskList));
        joiner.add(quote(this.nmosSerial));
        joiner.add(quote(this.nmosObjInst));
        joiner.add(quote(this.nmosCauseType));
        joiner.add(quote(this.nmosDomainName));
        joiner.add(quote(this.nmosEntityId));
        joiner.add(quote(this.nmosManagedStatus));
        joiner.add(quote(this.nmosEventMap));
        joiner.add(quote(this.localNodeAlias));
        joiner.add(quote(this.localPriObj));
        joiner.add(quote(this.localSecObj));
        joiner.add(quote(this.localRootObj));
        joiner.add(quote(this.x733EventType));
        joiner.add(quote(this.x733ProbableCause));
        joiner.add(quote(this.x733SpecificProb));
        joiner.add(quote(this.x733CorrNotif));
        joiner.add(quote(this.url));
        joiner.add(quote(this.extendedAttr));
        joiner.add(quote(this.oldRow));
        joiner.add(quote(this.probeSubSecondId));
        joiner.add(quote(this.bsmIdentity));
        joiner.add(quote(this.collectionFirst));
        joiner.add(quote(this.aggregationFirst));
        joiner.add(quote(this.acknowledgeUID));
        joiner.add(quote(this.toggleCount));
        joiner.add(quote(this.toggleDelay));
        joiner.add(quote(this.escalateFlag));
        joiner.add(quote(this.family));
        joiner.add(quote(this.onCall));
        joiner.add(quote(this.ticket));
        joiner.add(quote(this.oldSeverity));
        joiner.add(quote(this.oldOccurrence));
        joiner.add(quote(this.deduplicationOrder));
        joiner.add(quote(this.currentSince));
        joiner.add(quote(this.site));
        joiner.add(quote(this.parentElement));
        joiner.add(quote(this.department));
        joiner.add(quote(this.incidentID));
        joiner.add(quote(this.devicePrio));
        joiner.add(quote(this.operatorNote));
        joiner.add(quote(this.highFlappingEndCount));
        joiner.add(quote(this.highFlappingEndTime));
        joiner.add(quote(this.highFlappingCount));
        joiner.add(quote(this.highFlappingWindow));
        joiner.add(quote(this.lowFlappingEndCount));
        joiner.add(quote(this.lowFlappingEndTime));
        joiner.add(quote(this.lowFlappingCount));
        joiner.add(quote(this.lowFlappingWindow));
        joiner.add(quote(this.watchList));
        joiner.add(quote(this.ticketAction));
        joiner.add(quote(this.diagInfo));
        joiner.add(quote(this.alertKeyAlias));
        joiner.add(quote(this.emsAlarmId));
        joiner.add(quote(this.xInY));
        joiner.add(quote(this.info1));
        joiner.add(quote(this.info2));
        joiner.add(quote(this.callOut));
        joiner.add(quote(this.serviceImpact));
        joiner.add(quote(this.servicePrio));
        joiner.add(quote(this.lon));
        joiner.add(quote(this.lat));
        joiner.add(quote(this.managedFlag));
        joiner.add(quote(this.utsaot));
        joiner.add(quote(this.rcaCauseType));
        joiner.add(quote(this.rcaEventType));
        joiner.add(quote(this.rcaIdentifier));
        joiner.add(quote(this.rcaOrgSeverity));
        joiner.add(quote(this.rcaProblemText));
        joiner.add(quote(this.rcaStateChange));
        joiner.add(quote(this.remoteNodeAlias));
        joiner.add(quote(this.remotePriObj));
        joiner.add(quote(this.remoteRootObj));
        joiner.add(quote(this.remoteSecObj));
        joiner.add(quote(this.service));
        joiner.add(quote(this.seServiceName));
        joiner.add(quote(this.seProblemText));
        joiner.add(quote(this.seServiceType));
        joiner.add(quote(this.seState));
        joiner.add(quote(this.layer));
        joiner.add(quote(this.clusterName));
        joiner.add(quote(this.clusterSize));
        joiner.add(quote(this.monitoringOptions));
        joiner.add(quote(this.useType));
        joiner.add(quote(this.utsTime1));
        joiner.add(quote(this.rcaOldSeverity));
        joiner.add(quote(this.parked));
        joiner.add(quote(this.frontOffice));
        joiner.add(quote(this.region));
        joiner.add(quote(this.alarmHelp));
        joiner.add(quote(this.oidKey));
        joiner.add(quote(this.oidVisible));
        joiner.add(quote(this.classVisible));
        joiner.add(quote(this.nodeVisible));
        joiner.add(quote(this.nodeValue));
        joiner.add(quote(this.parentIdentifier));
        joiner.add(quote(this.ibmExtractedType));
        joiner.add(quote(this.ibmProcessingStage));
        joiner.add(quote(this.serverName));
        joiner.add(quote(this.serverSerial));

        return joiner.toString();
    }

    public static String getHeader() {
        return "'NetcoolEventAction','Identifier','Node','NodeAlias','Manager','Agent','AlertGroup','AlertKey','Severity','Summary','StateChange','FirstOccurrence','LastOccurrence','InternalLast','Poll','Type','Tally','Class','Grade','Location','OwnerUID','OwnerGID','Acknowledged','Flash','EventId','ExpireTime','ProcessReq','SuppressEscl','Customer','PhysicalSlot','PhysicalPort','TaskList','NmosSerial','NmosObjInst','NmosCauseType','NmosDomainName','NmosEntityId','NmosManagedStatus','NmosEventMap','LocalNodeAlias','LocalPriObj','LocalSecObj','LocalRootObj','X733EventType','X733ProbableCause','X733SpecificProb','X733CorrNotif','URL','ExtendedAttr','OldRow','ProbeSubSecondId','BSM_Identity','CollectionFirst','AggregationFirst','AcknowledgeUID','ToggleCount','ToggleDelay','EscalateFlag','Family','OnCall','Ticket','OldSeverity','OldOccurrence','DeduplicationOrder','CurrentSince','Site','ParentElement','Department','IncidentID','DevicePrio','OperatorNote','HighFlappingEndCount','HighFlappingEndTime','HighFlappingCount','HighFlappingWindow','LowFlappingEndCount','LowFlappingEndTime','LowFlappingCount','LowFlappingWindow','WatchList','TicketAction','DiagInfo','AlertKeyAlias','EMSAlarmId','XinY','Info1','Info2','CallOut','ServiceImpact','ServicePrio','Lon','Lat','ManagedFlag','UTSAOT','RCACauseType','RCAEventType','RCAIdentifier','RCAOrgSeverity','RCAProblemText','RCAStateChange','RemoteNodeAlias','RemotePriObj','RemoteRootObj','RemoteSecObj','Service','SEServiceName','SEProblemText','SEServiceType','SEState','Layer','ClusterName','ClusterSize','MonitoringOptions','UseType','UTSTime1','RCAOldSeverity','Parked','FrontOffice','Region','AlarmHelp','OIDKey','OIDVisible','ClassVisible','NodeVisible','NodeValue','ParentIdentifier','IBMExtractedType','IBMProcessingStage','ServerName','ServerSerial'";
    }
}