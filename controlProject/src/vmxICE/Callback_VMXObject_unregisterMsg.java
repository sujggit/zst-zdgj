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
// Generated from file `Callback_VMXObject_unregisterMsg.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 消息取消注册函数，将ICE ID为参数ObjectID的对象取消在被调用对象上针对ID为msgID的消息的关注，如果msgID为CMessage::MSG_ID_NULL，
 * 则取消ICE ID为objectID对象在被调用对象上所有消息的注册.
 * 
 **/

public abstract class Callback_VMXObject_unregisterMsg extends Ice.TwowayCallback
{
    public abstract void response(int __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        VMXObjectPrx __proxy = (VMXObjectPrx)__result.getProxy();
        int __ret = 0;
        try
        {
            __ret = __proxy.end_unregisterMsg(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
