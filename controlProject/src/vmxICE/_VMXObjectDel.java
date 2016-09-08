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
// Generated from file `_VMXObjectDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

public interface _VMXObjectDel extends Ice._ObjectDel
{
    int enumPropertyList(PropertyInfoListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int enumProperty(String name, PropertyInfoHolder info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setPropertyList(java.util.Map<java.lang.String, java.lang.String> list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getPropertyList(PropertyListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setProperty(String name, String value, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getProperty(String name, Ice.StringHolder value, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int enumMessageList(MsgDescListHolder msgList, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setParent(String parent, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String getParent(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getObjectType(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String getName(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String getID(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setState(ObjectState state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getState(ObjectStateHolder state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int recvMessage(byte[] msg, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int registerMsg(int msgID, String ObjectID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int unregisterMsg(int msgID, String ObjectID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int registerMsgWithLocator(int msgID, String ObjectID, String locator, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int unregisterMsgWithLocator(int msgID, String ObjectID, String locator, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getStatistics(StatisticsListHolder info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
