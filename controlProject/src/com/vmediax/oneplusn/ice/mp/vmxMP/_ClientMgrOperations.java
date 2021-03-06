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
// Generated from file `_ClientMgrOperations.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * ClientMgr对象包含多个客户端对象，是多个客户端对象的集合.
 * 
 **/
public interface _ClientMgrOperations extends vmxICE._ObjectMgrOperations
{
    /**
     * 获取客户端对象的句柄.
     * 
     * @param index 用户想要获取的客户端对象的索引.
     * 
     * @param __current The Current object for the invocation.
     * @return 如果成功，返回客户端对象的句柄，否则返回NULL.
     * 
     **/
    ClientPrx getClient(int index, Ice.Current __current);

    /**
     * 获取客户端对象的ID.
     * 
     * @param index 用户想要获取的客户端对象的索引.
     * @param ID 客户端对象的ID.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getClientID(int index, Ice.StringHolder ID, Ice.Current __current);

    /**
     * 获取集合中的客户端数量.
     * 
     * @param count 输出参数，输出客户端的数量.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getClientCount(Ice.IntHolder count, Ice.Current __current);

    /**
     * 获取集合中包含的客户端的类型.
     * 
     * @param type 客户端的类型，参考[ClientType].
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getClientType(ClientTypeHolder type, Ice.Current __current);

    /**
     * 获取空闲的客户端对象的ID.
     * 
     * @param ID 客户端的ID.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getIdleClient(Ice.StringHolder ID, Ice.Current __current);

    /**
     * 获取空闲的客户端对象的ID.
     * 
     * @param num 用户想要获取的客户端对象的数量.
     * @param list 客户端的ID列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getIdleClientList(int num, ClientIDListHolder list, Ice.Current __current);

    /**
     * 释放客户端对象为空闲客户端.
     * 
     * @param ID 用户想要释放的客户端对象的ID.
     * 
     * @param __current The Current object for the invocation.
     * @return 如果成功，返回客户端对象的句柄，否则返回NULL.
     * 
     **/
    int freeClient(String ID, Ice.Current __current);

    /**
     * 释放客户端对象为空闲客户端.
     * 
     * @param list 用户想要释放的客户端对象的ID列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 如果成功，返回客户端对象的句柄，否则返回NULL.
     * 
     **/
    int freeClientList(String[] list, Ice.Current __current);
}
