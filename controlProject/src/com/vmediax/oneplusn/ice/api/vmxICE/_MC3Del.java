// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `_MC3Del.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public interface _MC3Del extends Ice._ObjectDel
{
    CmdResult addTerminal(TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult updateTerminal(TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult deleteTerminal(String name, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getVedioTerminalList(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getAudioTerminalList(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalTypeInfo> getTemplateTerminalTypeList(String name, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getTemplateH323TerminList(String templatename, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getTemplateH323IdleTerminList(String templatename, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getTemplateAudioTerminList(String templatename, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getTemplateAudioIdleTerminList(String templatename, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TemplateInfo> getTemplateList(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult addMutiTemplate(MutiTemplateInfo template, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult updateMutiTemplate(MutiTemplateInfo template, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult deleteMutiTemplate(String templateName, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<LiveMeetTemplate> getLiveMeetTemplateList(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult addLiveMeetTemplate(LiveMeetTemplate template, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult updateLiveMeetTemplate(LiveMeetTemplate template, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult deleteLiveMeetTemplate(String templateName, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    LiveMeetTemplate getLiveMeetTemplate(String templateName, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TemplateParamInfo> getTemplateParam(String templatename, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getConferenceTerminals(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<Conference> getConferenceList(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<Conference> getConferenceInfo(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<ConferenceParam> getConferenceParam(String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int saveConferenceParam(String number, ConferenceParam cp, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getConferenceIdleVedioTerminals(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getConferenceIdleAudioTerminals(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<Conference> getConferenceInfoByTerminal(TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<TerminalInfo> getAudioTerminal(String ternumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult startLiveMeet(String livetemplatename, java.util.List<TerminalInfo> vediotermList, java.util.List<TerminalInfo> audioTermList, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult startTemplateMeet(Conference conf, String template, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult stopMutiConference(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult inviteVedioTerminal(java.util.List<TerminalInfo> terminalList, String qualityType, Conference conf, MutiTemplateInfo template, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult inviteAudioTerminal(java.util.List<TerminalInfo> terminalList, String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult kickMutiTerminal(String meetnumber, TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult disconnectMutiTerminal(String meetnumber, TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult connectMutiTerminal(String meetnumber, TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult disconnectAll(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult connectAll(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult muteMutiSpeaker(String meetnumber, TerminalInfo terminal, String speaker, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult muteMutiMicrophone(String meetnumber, TerminalInfo terminal, String mic, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult muteAllMicrophone(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult openAllMicrophone(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult muteAllSpeaker(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult openAllSpeaker(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String getVscreen(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<ScreenInfo> getScreenInfo(String meetnumber, String vscreen, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult setScreen(java.util.List<TerminalInfo> terList, String number, String vscreen, String index, String mode, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setQueue(String meetnumber, String index, TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setLecture(String meetnumber, TerminalInfo ter, String lecture, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setChair(String meetnumber, TerminalInfo ter, String chair, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult setChairsee(String meetnumber, String mode, java.util.List<TerminalInfo> terminalList, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<ChairCycleInfo> getChaircycleList(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<ChairCycleInfo> getChairseeList(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setFecc(String number, TerminalInfo ter, int actionType, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int stopFecc(String number, TerminalInfo ter, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setQualityH323(String number, TerminalInfo ter, String bandwidth, String vsize, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setQualitySoft(String number, TerminalInfo ter, String type, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioInsert(String ternumber1, String ternumberInsert, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioDismantle(String ternumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioHold(String terIp, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioUnHold(String terIp, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioTansfer(String ternumber, String targetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioStartSpy(String spyer, String ternumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioStopSpy(String spyer, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioStartRecord(String ternumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult audioStopRecord(String ternumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult powerPickUp(String num1, String targetnum, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult callback(String numa, String numb, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult consult(String conNum, String targetNum, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult meetShift(String meet1, String dstroomid, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult setAudioServ(String servip, String username, String pwd, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<PacketInfo> getMemberPacketStatus(String meetnumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult getServiceMode(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult getChannelsInLicenseNumber(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult setGWIP(String virtualFromIp, String virtualToIp, String subNetmask, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult setFixGWIP(String fixVirtualIp, String subNetmask, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult deleteGWIP(String virtualFromIp, String virtualToIp, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult deleteFixGWIP(String fixVirtualIp, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult clearAllGWIP(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult restartServer(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult startChannels(Conference channelsInfo, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult stopChannels(String channelsNumber, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    java.util.List<Conference> getChannelsList(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult callH323Terminal2Channels(TerminalInfo h323Terminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult disconnectH323Call2Channels(TerminalInfo h323Terminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult reconnectH323Call2Channels(TerminalInfo h323Terminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult stopH323Call2Channels(TerminalInfo h323Terminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult callRtspTerminal2Channels(TerminalInfo rtspTerminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult stopRtspCall2Channels(TerminalInfo rtspTerminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult disconnectRtspCall2Channels(TerminalInfo rtspTerminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult reconnectRtspCall2Channels(TerminalInfo rtspTerminal, String number, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    CmdResult setLogoPath2Channels(String logoPath, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
