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
// Generated from file `SourceMoveDirection.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * ö�������˶��ķ���
 * 
 **/
public enum SourceMoveDirection implements java.io.Serializable
{
    
    Up,
    
    Dowm,
    
    Left,
    
    Right;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static SourceMoveDirection
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(4);
        return values()[__v];
    }
}