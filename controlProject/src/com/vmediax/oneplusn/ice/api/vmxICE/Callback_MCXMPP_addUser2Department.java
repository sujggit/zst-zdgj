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
// Generated from file `Callback_MCXMPP_addUser2Department.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public abstract class Callback_MCXMPP_addUser2Department extends Ice.TwowayCallback
{
    public abstract void response(int __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        MCXMPPPrx __proxy = (MCXMPPPrx)__result.getProxy();
        int __ret = 0;
        try
        {
            __ret = __proxy.end_addUser2Department(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
