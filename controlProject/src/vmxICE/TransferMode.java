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
// Generated from file `TransferMode.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 节点之间的传输模式
 **/
public enum TransferMode implements java.io.Serializable
{
    
    /**
     * 由节点自动判断采用何种模式
     **/
    TMAuto,
    
    /**
     * 通过本地函数调用来传递
     **/
    TMFunctionCall,
    
    /**
     * 通过ice的函数调用进行传输，这是节点之间数据传递的默认方式
     **/
    TMIce,
    
    /**
     * 通过进程间的共享内存方式进行传输，共享内存的地址通过调用[getTransferMode]获得。
     **/
    TMShareMemory,
    
    /**
     * 通过ice对象所属的池来进行数据传输，这种方式主要用于减少数据传输量，当一个节点需要给另外一个池的多个节点传输相同的数据时，采用这种方式可以极大地提高性能。
     **/
    TMIcePool;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static TransferMode
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(5);
        return values()[__v];
    }
}
