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
// Generated from file `Callback_Conference_muteAllMicrophone.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 将会议中所有客户端的麦克风都静音.如果调用了这个接口,之后添加到会议中的客户端默认都是这次设置的状态.例如调用了该接口并且mute参数为true,则之后添加到会议中的客户端的麦克风都是静音状态.
 * 
 **/

public abstract class Callback_Conference_muteAllMicrophone extends Ice.TwowayCallback
{
    public abstract void response(int __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        ConferencePrx __proxy = (ConferencePrx)__result.getProxy();
        int __ret = 0;
        try
        {
            __ret = __proxy.end_muteAllMicrophone(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
