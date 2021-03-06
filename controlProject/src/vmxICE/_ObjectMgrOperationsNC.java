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
// Generated from file `_ObjectMgrOperationsNC.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * [ObjectPool]是mmap6框架中各种对象的管理池，提供了对象管理方面的功能。
 **/
public interface _ObjectMgrOperationsNC extends _VMXContainerOperationsNC
{
    /**
     * 获取集合中的对象数量.
     * 
     * @return 返回值为对象在池中的数量.
     * 
     **/
    int getObjectCount();

    /**
     * 获取指定索引的对象的ID，注意，这个调用不会将对象状态设置为已用.
     * 
     * @param index 对象索引.
     * @param ID 指定索引的对象的ID.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getObjectByIndex(int index, Ice.StringHolder ID);

    /**
     * 获取空闲的对象的ID.
     * 
     * @param ID 空闲的对象的ID.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getIdleObject(Ice.StringHolder ID);

    /**
     * 获取空闲的对象的ID列表，如果要求的数量大于存在的数量，则申请存在的数量并返回VMX_STATUS_ERR_OUT_OF_RESOURCE错误，实际申请到的数量可以通过查看list的数量获取.
     * 
     * @param list 空闲的对象的ID列表.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getIdleObjectList(int num, StringSeqHolder list);

    /**
     * 获取所有的对象的ID列表.
     * 
     * @param list 所有对象的ID列表.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getAllObjectList(StringSeqHolder list);

    /**
     * 判断对象是否空闲
     * 
     * @param ID 对象的ID.
     * 
     * @return 返回值为真代表空闲.
     * 
     **/
    boolean isObjectIdle(String ID);

    /**
     * 释放对象给对象池.
     * 
     * @param ID 用户想要释放的对象的ID.
     * 
     * @return 如果成功，返回客户端对象的句柄，否则返回NULL.
     * 
     **/
    int freeObject(String ID);

    /**
     * 释放多个对象给对象池.
     * 
     * @param list 用户想要释放的对象的ID列表.
     * 
     * @return 如果成功，返回客户端对象的句柄，否则返回NULL.
     * 
     **/
    int freeObjectList(String[] list);
}
