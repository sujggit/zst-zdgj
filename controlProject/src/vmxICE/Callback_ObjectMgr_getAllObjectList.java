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
// Generated from file `Callback_ObjectMgr_getAllObjectList.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 获取所有的对象的ID列表.
 * 
 **/

public abstract class Callback_ObjectMgr_getAllObjectList extends Ice.TwowayCallback
{
    public abstract void response(int __ret, String[] list);

    public final void __completed(Ice.AsyncResult __result)
    {
        ObjectMgrPrx __proxy = (ObjectMgrPrx)__result.getProxy();
        int __ret = 0;
        StringSeqHolder list = new StringSeqHolder();
        try
        {
            __ret = __proxy.end_getAllObjectList(list, __result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret, list.value);
    }
}
