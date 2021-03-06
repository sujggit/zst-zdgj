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
// Generated from file `ClientNamePos.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 枚举客户端名称的显示位置.
 **/
public enum ClientNamePos implements java.io.Serializable
{
    
    ClientNamePosUpLeft,
    
    ClientNamePosUpMid,
    
    ClientNamePosUpRight,
    
    ClientNamePosDownLeft,
    
    ClientNamePosDownMid,
    
    ClientNamePosDownRight,
    
    ClientNamePosCenter;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static ClientNamePos
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(7);
        return values()[__v];
    }
}
