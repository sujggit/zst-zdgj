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
// Generated from file `Callback_Conference_getConferenceVideoFPS.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 获取会议视频的fps.
 * 
 **/

public abstract class Callback_Conference_getConferenceVideoFPS extends Ice.TwowayCallback
{
    public abstract void response(int __ret, int fps);

    public final void __completed(Ice.AsyncResult __result)
    {
        ConferencePrx __proxy = (ConferencePrx)__result.getProxy();
        int __ret = 0;
        Ice.IntHolder fps = new Ice.IntHolder();
        try
        {
            __ret = __proxy.end_getConferenceVideoFPS(fps, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, fps.value);
    }
}
