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
// Generated from file `Callback_Client_getClientType.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 获取客户端的类型.
 * 
 **/

public abstract class Callback_Client_getClientType extends Ice.TwowayCallback
{
    public abstract void response(int __ret, ClientType type);

    public final void __completed(Ice.AsyncResult __result)
    {
        ClientPrx __proxy = (ClientPrx)__result.getProxy();
        int __ret = 0;
        ClientTypeHolder type = new ClientTypeHolder();
        try
        {
            __ret = __proxy.end_getClientType(type, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, type.value);
    }
}
