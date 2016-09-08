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
// Generated from file `TransferMode.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * �ڵ�֮��Ĵ���ģʽ
 **/
public enum TransferMode implements java.io.Serializable
{
    
    /**
     * �ɽڵ��Զ��жϲ��ú���ģʽ
     **/
    TMAuto,
    
    /**
     * ͨ�����غ�������������
     **/
    TMFunctionCall,
    
    /**
     * ͨ��ice�ĺ������ý��д��䣬���ǽڵ�֮�����ݴ��ݵ�Ĭ�Ϸ�ʽ
     **/
    TMIce,
    
    /**
     * ͨ�����̼�Ĺ����ڴ淽ʽ���д��䣬�����ڴ�ĵ�ַͨ������[getTransferMode]��á�
     **/
    TMShareMemory,
    
    /**
     * ͨ��ice���������ĳ����������ݴ��䣬���ַ�ʽ��Ҫ���ڼ������ݴ���������һ���ڵ���Ҫ������һ���صĶ���ڵ㴫����ͬ������ʱ���������ַ�ʽ���Լ����������ܡ�
     **/
    TMIcePool;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static TransferMode
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(5);
        return values()[__v];
    }
}