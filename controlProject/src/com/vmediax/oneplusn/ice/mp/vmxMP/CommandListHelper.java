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
// Generated from file `CommandListHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

public final class CommandListHelper
{
    public static void
    write(IceInternal.BasicStream __os, java.util.Map<CommandType, java.lang.String> __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.size());
            for(java.util.Map.Entry<CommandType, java.lang.String> __e : __v.entrySet())
            {
                __e.getKey().__write(__os);
                __os.writeString(__e.getValue());
            }
        }
    }

    public static java.util.Map<CommandType, java.lang.String>
    read(IceInternal.BasicStream __is)
    {
        java.util.Map<CommandType, java.lang.String> __v;
        __v = new java.util.HashMap<com.vmediax.oneplusn.ice.mp.vmxMP.CommandType, java.lang.String>();
        int __sz0 = __is.readSize();
        for(int __i0 = 0; __i0 < __sz0; __i0++)
        {
            CommandType __key;
            __key = CommandType.__read(__is);
            String __value;
            __value = __is.readString();
            __v.put(__key, __value);
        }
        return __v;
    }
}
