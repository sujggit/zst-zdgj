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
// Generated from file `Callback_VMXSystem_getLicense.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * ��ȡ��Ȩֵ
 **/

public abstract class Callback_VMXSystem_getLicense extends Ice.TwowayCallback
{
    public abstract void response(int __ret, String attrValue);

    public final void __completed(Ice.AsyncResult __result)
    {
        VMXSystemPrx __proxy = (VMXSystemPrx)__result.getProxy();
        int __ret = 0;
        Ice.StringHolder attrValue = new Ice.StringHolder();
        try
        {
            __ret = __proxy.end_getLicense(attrValue, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, attrValue.value);
    }
}
