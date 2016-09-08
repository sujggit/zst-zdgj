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
// Generated from file `Callback_ClientMgr_getIdleClient.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 获取空闲的客户端对象的ID.
 * 
 **/

public abstract class Callback_ClientMgr_getIdleClient extends Ice.TwowayCallback
{
    public abstract void response(int __ret, String ID);

    public final void __completed(Ice.AsyncResult __result)
    {
        ClientMgrPrx __proxy = (ClientMgrPrx)__result.getProxy();
        int __ret = 0;
        Ice.StringHolder ID = new Ice.StringHolder();
        try
        {
            __ret = __proxy.end_getIdleClient(ID, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, ID.value);
    }
}
