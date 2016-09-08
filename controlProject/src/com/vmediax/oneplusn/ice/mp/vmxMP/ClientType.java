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
// Generated from file `ClientType.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * [Client]的类型, 例如323终端，sip终端等.
 **/
public enum ClientType implements java.io.Serializable
{
    
    /**
     * 这是一个323终端.
     **/
    ClientTypeH323,
    
    /**
     * 这是一个通过RTMP协议连接的终端，例如flash终端.
     **/
    ClientTypeRTMP,
    
    /**
     * 这是一个手机终端，目前定义的协议下行为RTSP协议，上行是自定义协议.
     **/
    ClientTypeMobile,
    
    /**
     * 这是mmap5中自定义的终端类型.
     **/
    ClientTypeVSSGW,
    
    /**
     * 这是一个sip终端.
     **/
    ClientTypeSIP,
    
    /**
     * 这是一个rtsp终端.
     **/
    ClientTypeRTSP;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static ClientType
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(6);
        return values()[__v];
    }
}
