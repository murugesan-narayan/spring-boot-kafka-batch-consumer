package com.muru.kafka.consumer.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

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

    public TestMessage getTestMessage() {
        RandomGenerator random = RandomGenerator.getDefault();
        TestMessage message = new TestMessage();
        message.setNetcoolEventAction(RandomString.make(10));
        message.setIdentifier(RandomString.make(20));
        message.setNode(RandomString.make(20)); //20
        message.setNodeAlias(RandomString.make(12)); //12
        message.setManager(RandomString.make(20)); //20
        message.setAgent(RandomString.make(30)); //30
        message.setAlertGroup(RandomString.make(15)); //15
        message.setAlertKey(RandomString.make(20)); //50
        message.setSeverity(random.nextInt(0,9)); //1,
        message.setSummary(RandomString.make(20)); //50
        message.setStateChange(RandomString.make(20)); //20
        message.setFirstOccurrence("2021-11-29 12:45:13");
        message.setLastOccurrence("2021-12-15 12:27:20");
        message.setInternalLast("2021-12-15T12:27:28");
        message.setPoll(random.nextInt(0,9));   //1
        message.setType(random.nextInt(0,9));   //1
        message.setTally(random.nextInt(1000, 9999));  //4
        message.setClassA(random.nextInt(100000,999999));  //6
        message.setGrade(random.nextInt(0,9));  //1
        message.setLocation(RandomString.make(10)); //10
        message.setOwnerUID(random.nextInt(10000, 99999));   //5
        message.setOwnerGID(random.nextInt(0,9));   //1
        message.setAcknowledged(random.nextInt(0,9));   //1
        message.setFlash(random.nextInt(0,9));   //1
        message.setEventId(RandomString.make(20)); //60
        message.setExpireTime(random.nextInt(0,9));   //1
        message.setProcessReq(random.nextInt(0,9));   //1
        message.setSuppressEscl(random.nextInt(10, 99));   //2
        message.setCustomer(RandomString.make(10));    //10
        message.setPhysicalSlot(random.nextInt(0,9));   //1
        message.setPhysicalPort(random.nextInt(0,9));   //1
        message.setTaskList(random.nextInt(0,9));   //1
        message.setNmosSerial(RandomString.make(5));  //5
        message.setNmosObjInst(random.nextInt(0,9));    //1
        message.setNmosCauseType(random.nextInt(0,9));  //1
        message.setNmosDomainName(RandomString.make(5));  //5
        message.setNmosEntityId(random.nextInt(0,9));   //1
        message.setNmosManagedStatus(random.nextInt(0,9));  //1
        message.setNmosEventMap(RandomString.make(10));    //10
        message.setLocalNodeAlias(RandomString.make(10));  //10
        message.setLocalPriObj(RandomString.make(1)); //1
        message.setLocalSecObj("a"); //1
        message.setLocalRootObj("a");    //1
        message.setX733EventType(random.nextInt(100, 999));  //3
        message.setX733ProbableCause(random.nextInt(0,9));  //1
        message.setX733SpecificProb("a");    //1
        message.setX733CorrNotif("a");   //1
        message.setURL(RandomString.make(15)); //15
        message.setExtendedAttr(RandomString.make(15));    //15
        message.setOldRow(random.nextInt(0,9)); //1
        message.setProbeSubSecondId(random.nextInt(100, 999));   //3
        message.setBSM_Identity("a");    //1
        message.setCollectionFirst("1970-01-01T01:00:00");
        message.setAggregationFirst("2021-11-29T12:45:17");
        message.setAcknowledgeUID(RandomString.make(3));  //3
        message.setToggleCount(random.nextInt(0,9));    //1
        message.setToggleDelay(random.nextInt(0,9));    //1
        message.setEscalateFlag(random.nextInt(0,9));    //1
        message.setFamily("a");  //1
        message.setOnCall("a");  //1
        message.setTicket(RandomString.make(15));  //15
        message.setOldSeverity(random.nextInt(0,9));    //1
        message.setOldOccurrence("2021-11-29T12:45:13");
        message.setDeduplicationOrder(random.nextInt(0, 9));    //1
        message.setCurrentSince("2021-11-29 12:45:13");
        message.setSite(RandomString.make(10));   //10
        message.setParentElement("a");  //1
        message.setDepartment("a");  //1
        message.setIncidentID("a");  //1
        message.setDevicePrio(random.nextInt(0,9));    //1
        message.setOperatorNote(RandomString.make(20));   //50
        message.setHighFlappingEndCount(random.nextInt(0,9));    //1
        message.setHighFlappingEndTime("1970-01-01T01:00:00");
        message.setHighFlappingCount(random.nextInt(0,9));    //1
        message.setHighFlappingWindow(random.nextInt(0,9));    //1
        message.setLowFlappingEndCount(random.nextInt(0,9));    //1
        message.setLowFlappingEndTime("1970-01-01T01:00:00");
        message.setLowFlappingCount(random.nextInt(0,9));    //1
        message.setLowFlappingWindow(random.nextInt(0,9));    //1
        message.setWatchList("a");  //1
        message.setTicketAction(random.nextInt(100, 999));   //3
        message.setDiagInfo("a");   //1
        message.setAlertKeyAlias(RandomString.make(50));   //50
        message.setEMSAlarmId(random.nextInt(0,9));    //1
        message.setXinY("a");  //1
        message.setInfo1("a");  //1
        message.setInfo2("a");  //1
        message.setCallOut(random.nextInt(0,9));    //1
        message.setServiceImpact(random.nextInt(0,9));    //1
        message.setServicePrio(random.nextInt(0,9));    //1
        message.setLon("a");  //1
        message.setLat("a");  //1
        message.setManagedFlag(random.nextInt(10, 99));   //2
        message.setUTSAOT("a");  //1
        message.setRCACauseType(random.nextInt(0,9));    //1
        message.setRCAEventType("a");  //1
        message.setRCAIdentifier("a");  //1
        message.setRCAOrgSeverity(random.nextInt(0,9));    //1
        message.setRCAProblemText("a");  //1
        message.setRCAStateChange("2021-11-29T14:35:42");
        message.setRemoteNodeAlias("a");  //1
        message.setRemotePriObj("a");  //1
        message.setRemoteRootObj("a");  //1
        message.setRemoteSecObj("a");  //1
        message.setService("a");  //1
        message.setSEServiceName("a");  //1
        message.setSEProblemText("a");  //1
        message.setSEServiceType(random.nextInt(0,9));    //1
        message.setSEState(random.nextInt(0,9));    //1
        message.setLayer(random.nextInt(0,9));    //1
        message.setClusterName("a");  //1
        message.setClusterSize(random.nextInt(0,9));    //1
        message.setMonitoringOptions("a");  //1
        message.setUseType("a");  //1
        message.setUTSTime1("2021-11-29T14:35:42");
        message.setRCAOldSeverity(random.nextInt(0,9));    //1
        message.setParked(random.nextInt(0,9));    //1
        message.setFrontOffice(RandomString.make(3));   //3
        message.setRegion(random.nextInt(0,9));    //1
        message.setAlarmHelp("a");  //1
        message.setOIDKey(RandomString.make(20));   //90
        message.setOIDVisible(random.nextInt(0,9));    //1
        message.setClassVisible(random.nextInt(0,9));    //1
        message.setNodeVisible(random.nextInt(0,9));    //1
        message.setNodeValue(random.nextInt(0,9));    //1
        message.setParentIdentifier("a");  //1
        message.setIBMExtractedType("a");  //1
        message.setIBMProcessingStage(random.nextInt(0,9));    //1
        message.setServerName(RandomString.make(7));   //7
        message.setServerSerial(random.nextInt(100000000, 999999999));   //10-1
        message.setPk(RandomString.make(50));   //50
        message.setPk_node(RandomString.make(35));   //35
        message.setPk_date(RandomString.make(35));   //35
        message.setDomain("a");  //1
        message.setAlarm_Identifier(RandomString.make(20));   //20
        message.setTopic(RandomString.make(10));   //10
        message.setUse_Case("a");  //1
        message.setUse_Case_Group("a");  //1
        message.setDelete_event("False");    //4,5
        message.setDaaip_correlation_id("a");  //1
        message.setAlarm_Received_Time("2021-12-15 12:28:06");
        return message;
    }

}
