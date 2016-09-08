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
// Generated from file `Command.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * 命令结构，包含了命令的类型，及以字符串形式表现的附加值。
 * 
 **/
public class Command implements java.lang.Cloneable, java.io.Serializable
{
    /**
     * 命令类型，见[CommandType].
     **/
    public CommandType cmd;

    /**
     * 命令的附加值，以字符串形式表示，根据命令的类型不同而不同.
     **/
    public String value;

    public Command()
    {
    }

    public Command(CommandType cmd, String value)
    {
        this.cmd = cmd;
        this.value = value;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Command _r = null;
        try
        {
            _r = (Command)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(cmd != _r.cmd)
            {
                if(cmd == null || _r.cmd == null || !cmd.equals(_r.cmd))
                {
                    return false;
                }
            }
            if(value != _r.value)
            {
                if(value == null || _r.value == null || !value.equals(_r.value))
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
        if(cmd != null)
        {
            __h = 5 * __h + cmd.hashCode();
        }
        if(value != null)
        {
            __h = 5 * __h + value.hashCode();
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
        cmd.__write(__os);
        __os.writeString(value);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        cmd = CommandType.__read(__is);
        value = __is.readString();
    }
}
