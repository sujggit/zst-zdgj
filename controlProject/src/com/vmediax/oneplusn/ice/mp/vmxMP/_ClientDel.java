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
// Generated from file `_ClientDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

public interface _ClientDel extends vmxICE._ResourceDel
{
    int setClientName(String name, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getClientName(Ice.StringHolder name, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getConnectState(ClientConnectStateHolder state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setConnectMode(ClientConnectMode mode, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getConnectMode(ClientConnectModeHolder mode, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getClientType(ClientTypeHolder type, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int connect(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int disconnect(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int updateMediaCapability(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int execCommand(Command cmd, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int enumSupportCommand(CommandListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int close(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
