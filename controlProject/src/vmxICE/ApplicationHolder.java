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
// Generated from file `ApplicationHolder.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

public final class ApplicationHolder extends Ice.ObjectHolderBase<Application>
{
    public
    ApplicationHolder()
    {
    }

    public
    ApplicationHolder(Application value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        try
        {
            value = (Application)v;
        }
        catch(ClassCastException ex)
        {
            IceInternal.Ex.throwUOE(type(), v.ice_id());
        }
    }

    public String
    type()
    {
        return _ApplicationDisp.ice_staticId();
    }
}