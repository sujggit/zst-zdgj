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
// Generated from file `NodeMediaType.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 媒体节点的类型枚举
 **/
public enum NodeMediaType implements java.io.Serializable
{
    
    NodeMediaTypeAudio,
    
    NodeMediaTypeVideo,
    
    NodeMediaTypeData;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static NodeMediaType
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(3);
        return values()[__v];
    }
}
