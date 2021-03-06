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
// Generated from file `Callback_MediaNode_queryPadByDirection.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 枚举节点中的输入或者输出pad的信息。
 * 
 **/

public abstract class Callback_MediaNode_queryPadByDirection extends Ice.TwowayCallback
{
    public abstract void response(int __ret, NodePad[] list);

    public final void __completed(Ice.AsyncResult __result)
    {
        MediaNodePrx __proxy = (MediaNodePrx)__result.getProxy();
        int __ret = 0;
        PadListHolder list = new PadListHolder();
        try
        {
            __ret = __proxy.end_queryPadByDirection(list, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, list.value);
    }
}
