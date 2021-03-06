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
// Generated from file `XmppTree.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public class XmppTree implements java.lang.Cloneable, java.io.Serializable
{
    public int id;

    public int userflag;

    public String name;

    public int superDepartmentid;

    public String superDepartmentName;

    public String dlevel;

    public XmppTree()
    {
    }

    public XmppTree(int id, int userflag, String name, int superDepartmentid, String superDepartmentName, String dlevel)
    {
        this.id = id;
        this.userflag = userflag;
        this.name = name;
        this.superDepartmentid = superDepartmentid;
        this.superDepartmentName = superDepartmentName;
        this.dlevel = dlevel;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        XmppTree _r = null;
        try
        {
            _r = (XmppTree)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(id != _r.id)
            {
                return false;
            }
            if(userflag != _r.userflag)
            {
                return false;
            }
            if(name != _r.name)
            {
                if(name == null || _r.name == null || !name.equals(_r.name))
                {
                    return false;
                }
            }
            if(superDepartmentid != _r.superDepartmentid)
            {
                return false;
            }
            if(superDepartmentName != _r.superDepartmentName)
            {
                if(superDepartmentName == null || _r.superDepartmentName == null || !superDepartmentName.equals(_r.superDepartmentName))
                {
                    return false;
                }
            }
            if(dlevel != _r.dlevel)
            {
                if(dlevel == null || _r.dlevel == null || !dlevel.equals(_r.dlevel))
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
        __h = 5 * __h + id;
        __h = 5 * __h + userflag;
        if(name != null)
        {
            __h = 5 * __h + name.hashCode();
        }
        __h = 5 * __h + superDepartmentid;
        if(superDepartmentName != null)
        {
            __h = 5 * __h + superDepartmentName.hashCode();
        }
        if(dlevel != null)
        {
            __h = 5 * __h + dlevel.hashCode();
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
        __os.writeInt(id);
        __os.writeInt(userflag);
        __os.writeString(name);
        __os.writeInt(superDepartmentid);
        __os.writeString(superDepartmentName);
        __os.writeString(dlevel);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        id = __is.readInt();
        userflag = __is.readInt();
        name = __is.readString();
        superDepartmentid = __is.readInt();
        superDepartmentName = __is.readString();
        dlevel = __is.readString();
    }
}
