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
// Generated from file `Callback_ObjectMgr_isObjectIdle.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * �ж϶����Ƿ����
 * 
 **/

public abstract class Callback_ObjectMgr_isObjectIdle extends Ice.TwowayCallback
{
    public abstract void response(boolean __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        ObjectMgrPrx __proxy = (ObjectMgrPrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_isObjectIdle(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
