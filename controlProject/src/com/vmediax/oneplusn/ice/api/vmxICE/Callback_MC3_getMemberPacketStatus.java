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
// Generated from file `Callback_MC3_getMemberPacketStatus.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public abstract class Callback_MC3_getMemberPacketStatus extends Ice.TwowayCallback
{
    public abstract void response(java.util.List<PacketInfo> __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        MC3Prx __proxy = (MC3Prx)__result.getProxy();
        java.util.List<PacketInfo> __ret = null;
        try
        {
            __ret = __proxy.end_getMemberPacketStatus(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
