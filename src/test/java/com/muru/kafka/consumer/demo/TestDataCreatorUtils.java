package com.muru.kafka.consumer.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muru.kafka.consumer.demo.model.AlarmMessage;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class TestDataCreatorUtils {
    @Test
    public void createTestFile_min() throws IOException {
        createFile(1);
        createFile(3);
    }

    private void createFile(int min) throws IOException {
        String fileNameFullPath = "target/test-data-"+min+"min.txt";
        Files.deleteIfExists(Path.of(fileNameFullPath));
        Path file = Files.createFile(Path.of(fileNameFullPath));

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 4000 * min; i++) {
            String dataStr = objectMapper.writeValueAsString(getTestMessage());
            data.add(dataStr);
        }
        Files.write(file, data, StandardCharsets.UTF_8);
    }

    public AlarmMessage getTestMessage() {
        AlarmMessage message = new AlarmMessage();
        message.setNetcoolEventAction(RandomString.make(10)); //5-10
        message.setIdentifier(RandomString.make(20)); //120
        message.setNode(RandomString.make(20)); //20
        message.setNodeAlias(RandomString.make(12)); //12
        message.setManager(RandomString.make(20)); //20
        message.setAgent(RandomString.make(30)); //30
        message.setAlertGroup(RandomString.make(15)); //15
        message.setAlertKey(RandomString.make(20)); //50
        message.setSeverity(RandomString.make(1)); //1,
        message.setSummary(RandomString.make(20)); //50
        message.setStateChange(RandomString.make(20)); //20
        message.setFirstOccurrence("2021-11-29 12:45:13");
        message.setLastOccurrence("2021-12-15 12:27:20");
        message.setInternalLast("2021-12-15T12:27:28");
        message.setPoll(RandomString.make(1));   //1
        message.setType(RandomString.make(1));   //1
        message.setTally(RandomString.make(4));  //4
        message.setClassData(RandomString.make(6));  //6
        message.setGrade(RandomString.make(1));  //1
        message.setLocation(RandomString.make(10)); //10
        message.setOwnerUID(RandomString.make(5));   //5
        message.setOwnerGID(RandomString.make(1));   //1
        message.setAcknowledged(RandomString.make(1));   //1
        message.setFlash(RandomString.make(1));   //1
        message.setEventId(RandomString.make(20)); //60
        message.setExpireTime(RandomString.make(1));   //1
        message.setProcessReq(RandomString.make(1));   //1
        message.setSuppressEscl(RandomString.make(2));   //2
        message.setCustomer(RandomString.make(10));    //10
        message.setPhysicalSlot(RandomString.make(1));   //1
        message.setPhysicalPort(RandomString.make(1));   //1
        message.setTaskList(RandomString.make(1));   //1
        message.setNmosSerial(RandomString.make(5));  //5
        message.setNmosObjInst(RandomString.make(1));    //1
        message.setNmosCauseType(RandomString.make(1));  //1
        message.setNmosDomainName(RandomString.make(5));  //5
        message.setNmosEntityId(RandomString.make(1));   //1
        message.setNmosManagedStatus(RandomString.make(1));  //1
        message.setNmosEventMap(RandomString.make(10));    //10
        message.setLocalNodeAlias(RandomString.make(10));  //10
        message.setLocalPriObj(RandomString.make(1)); //1
        message.setLocalSecObj("a"); //1
        message.setLocalRootObj("a");    //1
        message.setX733EventType(RandomString.make(3));  //3
        message.setX733ProbableCause(RandomString.make(1));  //1
        message.setX733SpecificProb("a");    //1
        message.setX733CorrNotif("a");   //1
        message.setURL(RandomString.make(15)); //15
        message.setExtendedAttr(RandomString.make(15));    //15
        message.setOldRow(RandomString.make(1)); //1
        message.setProbeSubSecondId(RandomString.make(3));   //3
        message.setBSM_Identity("a");    //1
        message.setCollectionFirst("1970-01-01T01:00:00");
        message.setAggregationFirst("2021-11-29T12:45:17");
        message.setAcknowledgeUID(RandomString.make(3));  //3
        message.setToggleCount(RandomString.make(1));    //1
        message.setToggleDelay(RandomString.make(1));    //1
        message.setEscalateFlag(RandomString.make(1));    //1
        message.setFamily("a");  //1
        message.setOnCall("a");  //1
        message.setTicket(RandomString.make(15));  //15
        message.setOldSeverity(RandomString.make(1));    //1
        message.setOldOccurrence("2021-11-29T12:45:13");
        message.setDeduplicationOrder(RandomString.make(1));    //1
        message.setCurrentSince("2021-11-29 12:45:13");
        message.setSite(RandomString.make(10));   //10
        message.setParentElement("a");  //1
        message.setDepartment("a");  //1
        message.setIncidentID("a");  //1
        message.setDevicePrio(RandomString.make(1));    //1
        message.setOperatorNote(RandomString.make(20));   //50
        message.setHighFlappingEndCount(RandomString.make(1));    //1
        message.setHighFlappingEndTime("1970-01-01T01:00:00");
        message.setHighFlappingCount(RandomString.make(1));    //1
        message.setHighFlappingWindow(RandomString.make(1));    //1
        message.setLowFlappingEndCount(RandomString.make(1));    //1
        message.setLowFlappingEndTime("1970-01-01T01:00:00");
        message.setLowFlappingCount(RandomString.make(1));    //1
        message.setLowFlappingWindow(RandomString.make(1));    //1
        message.setWatchList("a");  //1
        message.setTicketAction(RandomString.make(3));   //3
        message.setDiagInfo("a");   //1
        message.setAlertKeyAlias(RandomString.make(50));   //50
        message.setEMSAlarmId(RandomString.make(1));    //1
        message.setXinY("a");  //1
        message.setInfo1("a");  //1
        message.setInfo2("a");  //1
        message.setCallOut(RandomString.make(1));    //1
        message.setServiceImpact(RandomString.make(1));    //1
        message.setServicePrio(RandomString.make(1));    //1
        message.setLon("a");  //1
        message.setLat("a");  //1
        message.setManagedFlag(RandomString.make(2));   //2
        message.setUTSAOT("a");  //1
        message.setRCACauseType(RandomString.make(1));    //1
        message.setRCAEventType("a");  //1
        message.setRCAIdentifier("a");  //1
        message.setRCAOrgSeverity(RandomString.make(1));    //1
        message.setRCAProblemText("a");  //1
        message.setRCAStateChange("2021-11-29T14:35:42");
        message.setRemoteNodeAlias("a");  //1
        message.setRemotePriObj("a");  //1
        message.setRemoteRootObj("a");  //1
        message.setRemoteSecObj("a");  //1
        message.setService("a");  //1
        message.setSEServiceName("a");  //1
        message.setSEProblemText("a");  //1
        message.setSEServiceType(RandomString.make(1));    //1
        message.setSEState(RandomString.make(1));    //1
        message.setLayer(RandomString.make(1));    //1
        message.setClusterName("a");  //1
        message.setClusterSize(RandomString.make(1));    //1
        message.setMonitoringOptions("a");  //1
        message.setUseType("a");  //1
        message.setUTSTime1("2021-11-29T14:35:42");
        message.setRCAOldSeverity(RandomString.make(1));    //1
        message.setParked(RandomString.make(1));    //1
        message.setFrontOffice(RandomString.make(3));   //3
        message.setRegion(RandomString.make(1));    //1
        message.setAlarmHelp("a");  //1
        message.setOIDKey(RandomString.make(20));   //90
        message.setOIDVisible(RandomString.make(1));    //1
        message.setClassVisible(RandomString.make(1));    //1
        message.setNodeVisible(RandomString.make(1));    //1
        message.setNodeValue(RandomString.make(1));    //1
        message.setParentIdentifier("a");  //1
        message.setIBMExtractedType("a");  //1
        message.setIBMProcessingStage(RandomString.make(1));    //1
        message.setServerName(RandomString.make(7));   //7
        message.setServerSerial(RandomString.make(10));   //10-1

        return message;
    }

}
