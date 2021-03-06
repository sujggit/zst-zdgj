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
// Generated from file `_ResourceOperations.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * [VMXResource]是mmap6框架中对业务层系统中的资源的定义，<b>接口定义还未完成</b>。
 **/
public interface _ResourceOperations extends _VMXObjectOperations
{
    /**
     * 枚举资源对象接受输入的节点列表.
     * 
     * @param list 媒体流节点的ID及流类型列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int enumInputNode(MediaNodeListHolder list, Ice.Current __current);

    /**
     * 枚举资源对象提供输出的节点列表.
     * 
     * @param list 媒体流节点的ID及流类型列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int enumOutputNode(MediaNodeListHolder list, Ice.Current __current);
}
