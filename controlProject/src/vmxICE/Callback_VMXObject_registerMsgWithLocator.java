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
// Generated from file `Callback_VMXObject_registerMsgWithLocator.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 消息注册函数，和[registerMsg]不同之处在于这个函数支持通过ice的locator来进行注册，也即是说想要获取消息的对象可以和目标对象不在同一个icegrid中.
 * 
 **/

public abstract class Callback_VMXObject_registerMsgWithLocator extends Ice.TwowayCallback
{
    public abstract void response(int __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        VMXObjectPrx __proxy = (VMXObjectPrx)__result.getProxy();
        int __ret = 0;
        try
        {
            __ret = __proxy.end_registerMsgWithLocator(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
