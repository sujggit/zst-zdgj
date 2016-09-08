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
// Generated from file `MPPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * MP����Ϊ��ý�����ĳ������ͨ�����������ö�ý�����ƽ̨����ѯ�����Ļ��鼯�ϼ��ͻ��˼��ϵ�,Ĭ�ϵ�MP��ICE IDΪmp/0@mp-0.
 * 
 **/
public interface MPPrx extends vmxICE.VMXSystemPrx
{
    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @return ClientMgr������.
     * 
     **/
    public int GetClientMgrCount();

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ClientMgr������.
     * 
     **/
    public int GetClientMgrCount(java.util.Map<String, String> __ctx);

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrCount();

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrCount(java.util.Map<String, String> __ctx);

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrCount(Ice.Callback __cb);

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrCount(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrCount(Callback_MP_GetClientMgrCount __cb);

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrCount(java.util.Map<String, String> __ctx, Callback_MP_GetClientMgrCount __cb);

    /**
     * ��ȡ[ClientMgr]���ϵ�����.
     * 
     * @param __result The asynchronous result object.
     * @return ClientMgr������.
     * 
     **/
    public int end_GetClientMgrCount(Ice.AsyncResult __result);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param ID ClientMgr��ID.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetClientMgrByIndex(int index, Ice.StringHolder ID);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param ID ClientMgr��ID.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetClientMgrByIndex(int index, Ice.StringHolder ID, java.util.Map<String, String> __ctx);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrByIndex(int index);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrByIndex(int index, java.util.Map<String, String> __ctx);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrByIndex(int index, Ice.Callback __cb);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrByIndex(int index, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrByIndex(int index, Callback_MP_GetClientMgrByIndex __cb);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ClientMgr������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrByIndex(int index, java.util.Map<String, String> __ctx, Callback_MP_GetClientMgrByIndex __cb);

    /**
     * ��ȡĳ��[ClientMgr]��ID.
     * 
     * @param ID ClientMgr��ID.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_GetClientMgrByIndex(Ice.StringHolder ID, Ice.AsyncResult __result);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param list ���е�ClientMgr��ID���б�.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetClientMgrList(vmxICE.StringSeqHolder list);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param list ���е�ClientMgr��ID���б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetClientMgrList(vmxICE.StringSeqHolder list, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrList();

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrList(java.util.Map<String, String> __ctx);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrList(Ice.Callback __cb);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrList(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrList(Callback_MP_GetClientMgrList __cb);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetClientMgrList(java.util.Map<String, String> __ctx, Callback_MP_GetClientMgrList __cb);

    /**
     * ��ȡ����[ClientMgr]��ID�б�.
     * 
     * @param list ���е�ClientMgr��ID���б�.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_GetClientMgrList(vmxICE.StringSeqHolder list, Ice.AsyncResult __result);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @return ConferenceMgr������.
     * 
     **/
    public int GetConferenceMgrCount();

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ConferenceMgr������.
     * 
     **/
    public int GetConferenceMgrCount(java.util.Map<String, String> __ctx);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrCount();

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrCount(java.util.Map<String, String> __ctx);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrCount(Ice.Callback __cb);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrCount(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrCount(Callback_MP_GetConferenceMgrCount __cb);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrCount(java.util.Map<String, String> __ctx, Callback_MP_GetConferenceMgrCount __cb);

    /**
     * ��ȡMP������ConferenceMgr������.
     * 
     * @param __result The asynchronous result object.
     * @return ConferenceMgr������.
     * 
     **/
    public int end_GetConferenceMgrCount(Ice.AsyncResult __result);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param ID ConferenceMgr��ID.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetConferenceMgrByIndex(int index, Ice.StringHolder ID);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param ID ConferenceMgr��ID.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetConferenceMgrByIndex(int index, Ice.StringHolder ID, java.util.Map<String, String> __ctx);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrByIndex(int index);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrByIndex(int index, java.util.Map<String, String> __ctx);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrByIndex(int index, Ice.Callback __cb);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrByIndex(int index, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrByIndex(int index, Callback_MP_GetConferenceMgrByIndex __cb);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param index ��Ҫ��ȡ��ConferenceMgr������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrByIndex(int index, java.util.Map<String, String> __ctx, Callback_MP_GetConferenceMgrByIndex __cb);

    /**
     * ��ȡĳ��[ConferenceMgr]��ID.
     * 
     * @param ID ConferenceMgr��ID.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_GetConferenceMgrByIndex(Ice.StringHolder ID, Ice.AsyncResult __result);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param list ���е�ConferenceMgr��ID���б�.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetConferenceMgrList(vmxICE.StringSeqHolder list);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param list ���е�ConferenceMgr��ID���б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int GetConferenceMgrList(vmxICE.StringSeqHolder list, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrList();

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrList(java.util.Map<String, String> __ctx);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrList(Ice.Callback __cb);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrList(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrList(Callback_MP_GetConferenceMgrList __cb);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_GetConferenceMgrList(java.util.Map<String, String> __ctx, Callback_MP_GetConferenceMgrList __cb);

    /**
     * ��ȡ����[ConferenceMgr]��ID�б�.
     * 
     * @param list ���е�ConferenceMgr��ID���б�.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_GetConferenceMgrList(vmxICE.StringSeqHolder list, Ice.AsyncResult __result);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int setLogoPath(String path);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int setLogoPath(String path, java.util.Map<String, String> __ctx);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setLogoPath(String path);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setLogoPath(String path, java.util.Map<String, String> __ctx);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setLogoPath(String path, Ice.Callback __cb);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setLogoPath(String path, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setLogoPath(String path, Callback_MP_setLogoPath __cb);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setLogoPath(String path, java.util.Map<String, String> __ctx, Callback_MP_setLogoPath __cb);

    /**
     * ����logͼƬ����������Ƶͼ��ʱ�ķ�����ʾ����.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_setLogoPath(Ice.AsyncResult __result);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getLogoPath(Ice.StringHolder path);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getLogoPath(Ice.StringHolder path, java.util.Map<String, String> __ctx);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLogoPath();

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLogoPath(java.util.Map<String, String> __ctx);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLogoPath(Ice.Callback __cb);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLogoPath(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLogoPath(Callback_MP_getLogoPath __cb);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLogoPath(java.util.Map<String, String> __ctx, Callback_MP_getLogoPath __cb);

    /**
     * ��ȡlogͼƬ��·��.
     * 
     * @param path logͼƬ�ڷ������ϵ�·��.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_getLogoPath(Ice.StringHolder path, Ice.AsyncResult __result);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int removeLogo();

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int removeLogo(java.util.Map<String, String> __ctx);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_removeLogo();

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_removeLogo(java.util.Map<String, String> __ctx);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_removeLogo(Ice.Callback __cb);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_removeLogo(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_removeLogo(Callback_MP_removeLogo __cb);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_removeLogo(java.util.Map<String, String> __ctx, Callback_MP_removeLogo __cb);

    /**
     * ɾ��logͼƬ.������Ƶͼ��ʱ����������ʾ��ɫ.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_removeLogo(Ice.AsyncResult __result);
}