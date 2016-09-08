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
// Generated from file `Callback_MediaNode_getDeliverList.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 获取和节点相连的下游节点列表。
 * 
 **/

public abstract class Callback_MediaNode_getDeliverList extends Ice.TwowayCallback
{
    public abstract void response(int __ret, LinkNode[] list);

    public final void __completed(Ice.AsyncResult __result)
    {
        MediaNodePrx __proxy = (MediaNodePrx)__result.getProxy();
        int __ret = 0;
        LinkListHolder list = new LinkListHolder();
        try
        {
            __ret = __proxy.end_getDeliverList(list, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, list.value);
    }
}
