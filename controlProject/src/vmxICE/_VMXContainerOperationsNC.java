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
// Generated from file `_VMXContainerOperationsNC.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * [VMXContainer]是mmap6中容器的定义。
 **/
public interface _VMXContainerOperationsNC extends _VMXObjectOperationsNC
{
    /**
     * 获取所有子对象的ID，如果对象本身包含业务逻辑特性，则输出所有使用的节点ID.
     * 
     * @param list 输出所有的子对象的ID的列表.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getChildrenID(StringSeqHolder list);
}
