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
// Generated from file `TerminalTypeInfo.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public class TerminalTypeInfo implements java.lang.Cloneable, java.io.Serializable
{
    public String templateid;

    public String bandwidth;

    public String vsize;

    public String type;

    public TerminalTypeInfo()
    {
    }

    public TerminalTypeInfo(String templateid, String bandwidth, String vsize, String type)
    {
        this.templateid = templateid;
        this.bandwidth = bandwidth;
        this.vsize = vsize;
        this.type = type;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        TerminalTypeInfo _r = null;
        try
        {
            _r = (TerminalTypeInfo)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(templateid != _r.templateid)
            {
                if(templateid == null || _r.templateid == null || !templateid.equals(_r.templateid))
                {
                    return false;
                }
            }
            if(bandwidth != _r.bandwidth)
            {
                if(bandwidth == null || _r.bandwidth == null || !bandwidth.equals(_r.bandwidth))
                {
                    return false;
                }
            }
            if(vsize != _r.vsize)
            {
                if(vsize == null || _r.vsize == null || !vsize.equals(_r.vsize))
                {
                    return false;
                }
            }
            if(type != _r.type)
            {
                if(type == null || _r.type == null || !type.equals(_r.type))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 0;
        if(templateid != null)
        {
            __h = 5 * __h + templateid.hashCode();
        }
        if(bandwidth != null)
        {
            __h = 5 * __h + bandwidth.hashCode();
        }
        if(vsize != null)
        {
            __h = 5 * __h + vsize.hashCode();
        }
        if(type != null)
        {
            __h = 5 * __h + type.hashCode();
        }
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(templateid);
        __os.writeString(bandwidth);
        __os.writeString(vsize);
        __os.writeString(type);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        templateid = __is.readString();
        bandwidth = __is.readString();
        vsize = __is.readString();
        type = __is.readString();
    }
}
