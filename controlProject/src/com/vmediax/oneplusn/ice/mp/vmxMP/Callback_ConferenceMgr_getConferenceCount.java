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
// Generated from file `Callback_ConferenceMgr_getConferenceCount.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 获取集合中的会议数量.
 * 
 **/

public abstract class Callback_ConferenceMgr_getConferenceCount extends Ice.TwowayCallback
{
    public abstract void response(int __ret, int count);

    public final void __completed(Ice.AsyncResult __result)
    {
        ConferenceMgrPrx __proxy = (ConferenceMgrPrx)__result.getProxy();
        int __ret = 0;
        Ice.IntHolder count = new Ice.IntHolder();
        try
        {
            __ret = __proxy.end_getConferenceCount(count, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, count.value);
    }
}
