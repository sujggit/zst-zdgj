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
// Generated from file `Callback_Resource_enumInputNode.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 枚举资源对象接受输入的节点列表.
 * 
 **/

public abstract class Callback_Resource_enumInputNode extends Ice.TwowayCallback
{
    public abstract void response(int __ret, ResourceNodeDesc[] list);

    public final void __completed(Ice.AsyncResult __result)
    {
        ResourcePrx __proxy = (ResourcePrx)__result.getProxy();
        int __ret = 0;
        MediaNodeListHolder list = new MediaNodeListHolder();
        try
        {
            __ret = __proxy.end_enumInputNode(list, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, list.value);
    }
}
