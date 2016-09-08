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
// Generated from file `NodePad.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 节点的PAD的描述结构，Pad可以看成是一个节点的输入输出口，每个多媒体处理节点至少有一个输入或者输出Pad，可以有多个输入及多个输出pad，
 * 通过多媒体节点的ice ID加上pad的索引和方向可以唯一定位到一个pad，在连接节点的时候可以指定pad的index，也可以不指定，<b>如果多媒体节点的
 * 输入或者输出没有不同类型的数据流，那么就没必要指定，让节点自己选择</b>。
 * 
 **/
public class NodePad implements java.lang.Cloneable, java.io.Serializable
{
    /**
     * pad的类型，输入还是输出
     **/
    public PadDirection dir;

    /**
     * pad的索引
     **/
    public int index;

    /**
     * pad的能力描述
     **/
    public String caps;

    /**
     * pad中数据的传输模式
     **/
    public TransferMode mode;

    /**
     * pad是否有连接
     **/
    public boolean connected;

    /**
     * pad连接的节点的信息列表，如果没有则为空数组
     **/
    public LinkNode[] nodeList;

    /**
     * 从pad经过的数据包的数量,如果pad类型是输入,则表示pad接收的数据包的数量,如果pad类型是输出,则表示pad发出的数据包的数量
     **/
    public int bufferNum;

    public NodePad()
    {
    }

    public NodePad(PadDirection dir, int index, String caps, TransferMode mode, boolean connected, LinkNode[] nodeList, int bufferNum)
    {
        this.dir = dir;
        this.index = index;
        this.caps = caps;
        this.mode = mode;
        this.connected = connected;
        this.nodeList = nodeList;
        this.bufferNum = bufferNum;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        NodePad _r = null;
        try
        {
            _r = (NodePad)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(dir != _r.dir)
            {
                if(dir == null || _r.dir == null || !dir.equals(_r.dir))
                {
                    return false;
                }
            }
            if(index != _r.index)
            {
                return false;
            }
            if(caps != _r.caps)
            {
                if(caps == null || _r.caps == null || !caps.equals(_r.caps))
                {
                    return false;
                }
            }
            if(mode != _r.mode)
            {
                if(mode == null || _r.mode == null || !mode.equals(_r.mode))
                {
                    return false;
                }
            }
            if(connected != _r.connected)
            {
                return false;
            }
            if(!java.util.Arrays.equals(nodeList, _r.nodeList))
            {
                return false;
            }
            if(bufferNum != _r.bufferNum)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 0;
        if(dir != null)
        {
            __h = 5 * __h + dir.hashCode();
        }
        __h = 5 * __h + index;
        if(caps != null)
        {
            __h = 5 * __h + caps.hashCode();
        }
        if(mode != null)
        {
            __h = 5 * __h + mode.hashCode();
        }
        __h = 5 * __h + (connected ? 1 : 0);
        if(nodeList != null)
        {
            for(int __i0 = 0; __i0 < nodeList.length; __i0++)
            {
                if(nodeList[__i0] != null)
                {
                    __h = 5 * __h + nodeList[__i0].hashCode();
                }
            }
        }
        __h = 5 * __h + bufferNum;
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
        dir.__write(__os);
        __os.writeInt(index);
        __os.writeString(caps);
        mode.__write(__os);
        __os.writeBool(connected);
        LinkListHelper.write(__os, nodeList);
        __os.writeInt(bufferNum);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        dir = PadDirection.__read(__is);
        index = __is.readInt();
        caps = __is.readString();
        mode = TransferMode.__read(__is);
        connected = __is.readBool();
        nodeList = LinkListHelper.read(__is);
        bufferNum = __is.readInt();
    }
}
