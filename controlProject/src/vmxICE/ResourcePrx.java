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
// Generated from file `ResourcePrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * [VMXResource]��mmap6����ж�ҵ���ϵͳ�е���Դ�Ķ��壬<b>�ӿڶ��廹δ���</b>��
 **/
public interface ResourcePrx extends VMXObjectPrx
{
    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param list ý�����ڵ��ID���������б�.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int enumInputNode(MediaNodeListHolder list);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param list ý�����ڵ��ID���������б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int enumInputNode(MediaNodeListHolder list, java.util.Map<String, String> __ctx);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumInputNode();

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumInputNode(java.util.Map<String, String> __ctx);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumInputNode(Ice.Callback __cb);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumInputNode(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumInputNode(Callback_Resource_enumInputNode __cb);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumInputNode(java.util.Map<String, String> __ctx, Callback_Resource_enumInputNode __cb);

    /**
     * ö����Դ�����������Ľڵ��б�.
     * 
     * @param list ý�����ڵ��ID���������б�.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_enumInputNode(MediaNodeListHolder list, Ice.AsyncResult __result);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param list ý�����ڵ��ID���������б�.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int enumOutputNode(MediaNodeListHolder list);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param list ý�����ڵ��ID���������б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int enumOutputNode(MediaNodeListHolder list, java.util.Map<String, String> __ctx);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumOutputNode();

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumOutputNode(java.util.Map<String, String> __ctx);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumOutputNode(Ice.Callback __cb);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumOutputNode(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumOutputNode(Callback_Resource_enumOutputNode __cb);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumOutputNode(java.util.Map<String, String> __ctx, Callback_Resource_enumOutputNode __cb);

    /**
     * ö����Դ�����ṩ����Ľڵ��б�.
     * 
     * @param list ý�����ڵ��ID���������б�.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_enumOutputNode(MediaNodeListHolder list, Ice.AsyncResult __result);
}