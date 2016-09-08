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
// Generated from file `TemplateSHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public final class TemplateSHelper
{
    public static void
    write(IceInternal.BasicStream __os, java.util.List<TemplateInfo> __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.size());
            for(TemplateInfo __elem : __v)
            {
                __elem.__write(__os);
            }
        }
    }

    public static java.util.List<TemplateInfo>
    read(IceInternal.BasicStream __is)
    {
        java.util.List<TemplateInfo> __v;
        __v = new java.util.LinkedList();
        final int __len0 = __is.readAndCheckSeqSize(12);
        for(int __i0 = 0; __i0 < __len0; __i0++)
        {
            TemplateInfo __elem;
            __elem = new TemplateInfo();
            __elem.__read(__is);
            __v.add(__elem);
        }
        return __v;
    }
}
