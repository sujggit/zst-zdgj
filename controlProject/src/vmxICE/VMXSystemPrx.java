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
// Generated from file `VMXSystemPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * [VMXSystem]��mmap6����ж�ҵ���ϵͳ�Ķ��壬������ÿ������mmap6��ܵ�ϵͳ��ͨ�ýӿڣ�������ϵͳ�����������ϵͳ֮��Ľ����ȣ�<b>�ӿڶ��廹δ���</b>��
 **/
public interface VMXSystemPrx extends VMXObjectPrx
{
    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param locator Ice locator.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int registerCallbackWithLocator(String ID, String locator);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param locator Ice locator.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int registerCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_registerCallbackWithLocator(String ID, String locator);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_registerCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_registerCallbackWithLocator(String ID, String locator, Ice.Callback __cb);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_registerCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_registerCallbackWithLocator(String ID, String locator, Callback_VMXSystem_registerCallbackWithLocator __cb);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param ID ��Ҫ������Ϣ�Ķ����ID.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_registerCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx, Callback_VMXSystem_registerCallbackWithLocator __cb);

    /**
     * ע��һ��ice����ϵͳ�У����ڽ���ϵͳ����Ϣ�� ע��Ķ�����Ҫ�̳�[Application]����Ϣ���Ͳο�[Message].
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_registerCallbackWithLocator(Ice.AsyncResult __result);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param locator Ice locator.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int unregisterCallbackWithLocator(String ID, String locator);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param locator Ice locator.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int unregisterCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_unregisterCallbackWithLocator(String ID, String locator);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_unregisterCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_unregisterCallbackWithLocator(String ID, String locator, Ice.Callback __cb);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_unregisterCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_unregisterCallbackWithLocator(String ID, String locator, Callback_VMXSystem_unregisterCallbackWithLocator __cb);

    /**
     * ȡ��ע��.
     * 
     * @param ID ��Ҫȡ��������Ϣ�Ķ����ID.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_unregisterCallbackWithLocator(String ID, String locator, java.util.Map<String, String> __ctx, Callback_VMXSystem_unregisterCallbackWithLocator __cb);

    /**
     * ȡ��ע��.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_unregisterCallbackWithLocator(Ice.AsyncResult __result);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param value �������ֵ.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int setConfigInfo(String name, String value);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param value �������ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int setConfigInfo(String name, String value, java.util.Map<String, String> __ctx);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConfigInfo(String name, String value);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConfigInfo(String name, String value, java.util.Map<String, String> __ctx);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConfigInfo(String name, String value, Ice.Callback __cb);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConfigInfo(String name, String value, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConfigInfo(String name, String value, Callback_VMXSystem_setConfigInfo __cb);

    /**
     * �����������ֵ.
     * 
     * @param name �����������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConfigInfo(String name, String value, java.util.Map<String, String> __ctx, Callback_VMXSystem_setConfigInfo __cb);

    /**
     * �����������ֵ.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_setConfigInfo(Ice.AsyncResult __result);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param value �������ֵ.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getConfigInfo(String name, Ice.StringHolder value);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param value �������ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getConfigInfo(String name, Ice.StringHolder value, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfo(String name);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfo(String name, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfo(String name, Ice.Callback __cb);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfo(String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfo(String name, Callback_VMXSystem_getConfigInfo __cb);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param name �����������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfo(String name, java.util.Map<String, String> __ctx, Callback_VMXSystem_getConfigInfo __cb);

    /**
     * ��ȡ�������ֵ.
     * 
     * @param value �������ֵ.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_getConfigInfo(Ice.StringHolder value, Ice.AsyncResult __result);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param StringSeq ���������Ϣ�б�����ʽΪ:����,��ǰֵ,����������,�������ֵ������,Ĭ��ֵ,��Χ(���ֵ����Ϊselect������|Ϊ���ö������ѡ������Ϊint������a-b�����÷�Χ)
     * </p>�������ֵ�������б�:
     * <ul>
     * <li> select - �б��е�ѡ     </li> 
     * <li> string - �ַ���         </li> 
     * <li> int - ��ֵ              </li> 
     * <li> bool - ����ֵ           </li> 
     * </ul> 
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getConfigInfoList(StringSeqHolder configInfoList);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param StringSeq ���������Ϣ�б�����ʽΪ:����,��ǰֵ,����������,�������ֵ������,Ĭ��ֵ,��Χ(���ֵ����Ϊselect������|Ϊ���ö������ѡ������Ϊint������a-b�����÷�Χ)
     * </p>�������ֵ�������б�:
     * <ul>
     * <li> select - �б��е�ѡ     </li> 
     * <li> string - �ַ���         </li> 
     * <li> int - ��ֵ              </li> 
     * <li> bool - ����ֵ           </li> 
     * </ul> 
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getConfigInfoList(StringSeqHolder configInfoList, java.util.Map<String, String> __ctx);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfoList();

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfoList(java.util.Map<String, String> __ctx);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfoList(Ice.Callback __cb);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfoList(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfoList(Callback_VMXSystem_getConfigInfoList __cb);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConfigInfoList(java.util.Map<String, String> __ctx, Callback_VMXSystem_getConfigInfoList __cb);

    /**
     * ���б���ʽ��ȡ��������������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_getConfigInfoList(StringSeqHolder configInfoList, Ice.AsyncResult __result);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param value �߼��������ֵ.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int setAdvanceConfigInfo(String name, String value);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param value �߼��������ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int setAdvanceConfigInfo(String name, String value, java.util.Map<String, String> __ctx);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setAdvanceConfigInfo(String name, String value);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setAdvanceConfigInfo(String name, String value, java.util.Map<String, String> __ctx);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setAdvanceConfigInfo(String name, String value, Ice.Callback __cb);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setAdvanceConfigInfo(String name, String value, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setAdvanceConfigInfo(String name, String value, Callback_VMXSystem_setAdvanceConfigInfo __cb);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param name �߼������������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setAdvanceConfigInfo(String name, String value, java.util.Map<String, String> __ctx, Callback_VMXSystem_setAdvanceConfigInfo __cb);

    /**
     * ���ø߼��������ֵ���߼����������������������ڸ߼����������ͨ�û���������Ҫ�ɼ����̻����������̽������á�
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_setAdvanceConfigInfo(Ice.AsyncResult __result);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param value �߼��������ֵ.
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getAdvanceConfigInfo(String name, Ice.StringHolder value);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param value �߼��������ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getAdvanceConfigInfo(String name, Ice.StringHolder value, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfo(String name);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfo(String name, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfo(String name, Ice.Callback __cb);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfo(String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfo(String name, Callback_VMXSystem_getAdvanceConfigInfo __cb);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param name �߼������������.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfo(String name, java.util.Map<String, String> __ctx, Callback_VMXSystem_getAdvanceConfigInfo __cb);

    /**
     * ��ȡ�߼��������ֵ.
     * 
     * @param value �߼��������ֵ.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_getAdvanceConfigInfo(Ice.StringHolder value, Ice.AsyncResult __result);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param StringSeq ���Ե���Ϣ�б�����ʽΪ:����,��ǰֵ,�߼�����������,�߼��������ֵ������,Ĭ��ֵ,��Χ(���ֵ����Ϊselect������|Ϊ���ö������ѡ������Ϊint������a-b�����÷�Χ)
     * </p>�߼��������ֵ�������б�:
     * <ul>
     * <li> select - �б��е�ѡ     </li> 
     * <li> string - �ַ���         </li> 
     * <li> int - ��ֵ              </li> 
     * <li> bool - ����ֵ           </li> 
     * </ul> 
     * 
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getAdvanceConfigInfoList(ConfigInfoSeqHolder configInfoSequence);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param StringSeq ���Ե���Ϣ�б�����ʽΪ:����,��ǰֵ,�߼�����������,�߼��������ֵ������,Ĭ��ֵ,��Χ(���ֵ����Ϊselect������|Ϊ���ö������ѡ������Ϊint������a-b�����÷�Χ)
     * </p>�߼��������ֵ�������б�:
     * <ul>
     * <li> select - �б��е�ѡ     </li> 
     * <li> string - �ַ���         </li> 
     * <li> int - ��ֵ              </li> 
     * <li> bool - ����ֵ           </li> 
     * </ul> 
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getAdvanceConfigInfoList(ConfigInfoSeqHolder configInfoSequence, java.util.Map<String, String> __ctx);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfoList();

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfoList(java.util.Map<String, String> __ctx);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfoList(Ice.Callback __cb);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfoList(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfoList(Callback_VMXSystem_getAdvanceConfigInfoList __cb);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getAdvanceConfigInfoList(java.util.Map<String, String> __ctx, Callback_VMXSystem_getAdvanceConfigInfoList __cb);

    /**
     * ���б���ʽ��ȡ���и߼�����������ƣ�ֵ�����ͣ���Χ����ǰֵ��Ĭ��ֵ.
     * 
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�������Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_getAdvanceConfigInfoList(ConfigInfoSeqHolder configInfoSequence, Ice.AsyncResult __result);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param value
     * 
     * @return ����ֵΪ0�����ɹ�, ����Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getLicense(String attrName, Ice.StringHolder attrValue);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param value
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return ����ֵΪ0�����ɹ�, ����Ϊʧ�ܵĴ�����.
     * 
     **/
    public int getLicense(String attrName, Ice.StringHolder attrValue, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLicense(String attrName);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLicense(String attrName, java.util.Map<String, String> __ctx);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLicense(String attrName, Ice.Callback __cb);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLicense(String attrName, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLicense(String attrName, Callback_VMXSystem_getLicense __cb);

    /**
     * ��ȡ��Ȩֵ
     * @param attrName  
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getLicense(String attrName, java.util.Map<String, String> __ctx, Callback_VMXSystem_getLicense __cb);

    /**
     * ��ȡ��Ȩֵ
     * @param __result The asynchronous result object.
     * @return ����ֵΪ0�����ɹ�, ����Ϊʧ�ܵĴ�����.
     * 
     **/
    public int end_getLicense(Ice.StringHolder attrValue, Ice.AsyncResult __result);
}