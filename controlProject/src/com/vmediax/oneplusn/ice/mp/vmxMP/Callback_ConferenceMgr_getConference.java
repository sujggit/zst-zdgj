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
// Generated from file `Callback_ConferenceMgr_getConference.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * ��ȡ�������ľ��.
 * 
 **/

public abstract class Callback_ConferenceMgr_getConference extends Ice.TwowayCallback
{
    public abstract void response(ConferencePrx __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        ConferenceMgrPrx __proxy = (ConferenceMgrPrx)__result.getProxy();
        ConferencePrx __ret = null;
        try
        {
            __ret = __proxy.end_getConference(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}