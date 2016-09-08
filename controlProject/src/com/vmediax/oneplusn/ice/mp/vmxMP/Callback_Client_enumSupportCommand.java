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
// Generated from file `Callback_Client_enumSupportCommand.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 枚举客户端支持的命令列表.
 * 
 **/

public abstract class Callback_Client_enumSupportCommand extends Ice.TwowayCallback
{
    public abstract void response(int __ret, java.util.Map<CommandType, java.lang.String> list);

    public final void __completed(Ice.AsyncResult __result)
    {
        ClientPrx __proxy = (ClientPrx)__result.getProxy();
        int __ret = 0;
        CommandListHolder list = new CommandListHolder();
        try
        {
            __ret = __proxy.end_enumSupportCommand(list, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, list.value);
    }
}
