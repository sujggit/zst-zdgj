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
// Generated from file `EventDesc.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 事件的描述结构，事件在mmap框架中用于多媒体节点之间信息的传递，按照和数据流的关系可以分为两种，一种是和数据流采用同种传输通道，这样事件的处理顺序
 * 会插在数据包之间按照顺序得到执行，另外一种是和数据流无关方式，通过调用目标对象的[recvEvent]函数进行传输。按照传输方向又可以分为两种，一种是下游向
 * 上游上溯传输，另外一种是上游向下游传输，第二种可以采用插入数据流顺序传输，而第一种不可以。
 **/
public class EventDesc implements java.lang.Cloneable, java.io.Serializable
{
    /**
     * 事件的ID，在vmx_event::CEvent类中有基础定义，另外在各项目中可能会有扩展定义.
     **/
    public int ID;

    /**
     * 事件的描述信息.
     **/
    public String desc;

    public EventDesc()
    {
    }

    public EventDesc(int ID, String desc)
    {
        this.ID = ID;
        this.desc = desc;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        EventDesc _r = null;
        try
        {
            _r = (EventDesc)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(ID != _r.ID)
            {
                return false;
            }
            if(desc != _r.desc)
            {
                if(desc == null || _r.desc == null || !desc.equals(_r.desc))
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
        __h = 5 * __h + ID;
        if(desc != null)
        {
            __h = 5 * __h + desc.hashCode();
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
        __os.writeInt(ID);
        __os.writeString(desc);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        ID = __is.readInt();
        desc = __is.readString();
    }
}
