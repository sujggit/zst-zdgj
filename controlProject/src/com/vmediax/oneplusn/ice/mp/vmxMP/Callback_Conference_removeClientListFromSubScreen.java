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
// Generated from file `Callback_Conference_removeClientListFromSubScreen.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 从某个分屏上移除多个客户端.注意!!!,如果该分屏所在的屏幕的分屏模式是单屏,而该终端是分屏上最后一个客户端,那么该接口的调用结果会导致所有连接都被拆除,会议中其它终端都收不到视频流,请勿在会议结束之前进行这种调用.
 * 
 **/

public abstract class Callback_Conference_removeClientListFromSubScreen extends Ice.TwowayCallback
{
    public abstract void response(int __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        ConferencePrx __proxy = (ConferencePrx)__result.getProxy();
        int __ret = 0;
        try
        {
            __ret = __proxy.end_removeClientListFromSubScreen(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
