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
// Generated from file `_MPDisp.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * MP对象为多媒体服务的抽象对象，通过它可以配置多媒体服务平台，查询包含的会议集合及客户端集合等,默认的MP的ICE ID为mp/0@mp-0.
 * 
 **/
public abstract class _MPDisp extends Ice.ObjectImpl implements MP
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::vmxICE::VMXObject",
        "::vmxICE::VMXSystem",
        "::vmxMP::MP"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[3];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[3];
    }

    public static String
    ice_staticId()
    {
        return __ids[3];
    }

    /**
     * 枚举节点在运行过程中会发送的所有消息的ID及其描述。
     * 
     * @param msgList 消息ID列表，在vmx_msg::CMessage类中有基础定义，另外在各项目中可能会有扩展定义.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    enumMessageList(vmxICE.MsgDescListHolder msgList)
    {
        return enumMessageList(msgList, null);
    }

    /**
     * 枚举对象的单个属性信息.
     * 
     * @param name 属性名称
     * @param info 属性信息
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    enumProperty(String name, vmxICE.PropertyInfoHolder info)
    {
        return enumProperty(name, info, null);
    }

    /**
     * 枚举对象的属性信息列表.
     * 
     * @param list 属性信息列表
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    enumPropertyList(vmxICE.PropertyInfoListHolder list)
    {
        return enumPropertyList(list, null);
    }

    /**
     * 获取对象的ICE ID.
     * 
     * @return 返回对象的ICE ID.
     * 
     **/
    public final String
    getID()
    {
        return getID(null);
    }

    /**
     * 获取对象名称.
     * 
     * @return 返回对象的名称.
     * 
     **/
    public final String
    getName()
    {
        return getName(null);
    }

    /**
     * 获取对象类型特征。
     * 
     * @return 返回对象的类型，有[ObjectTypeMediaNode],[ObjectTypeContainer],[ObjectTypeHasAPI],[ObjectTypeApplication]四种，这四种类型可以并存.
     * 
     **/
    public final int
    getObjectType()
    {
        return getObjectType(null);
    }

    /**
     * 获取对象的所有者。
     * 
     * @return 返回对象的所有者的ICE ID，如果没有所有者，则返回空字符串.
     * 
     **/
    public final String
    getParent()
    {
        return getParent(null);
    }

    /**
     * 获取属性值.
     * 
     * @param name 属性名称
     * @param value 属性值
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getProperty(String name, Ice.StringHolder value)
    {
        return getProperty(name, value, null);
    }

    /**
     * 以列表的形式获取指定属性的值.
     * 
     * @param list 输入为属性名称列表，输出为名称和值对应的列表
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getPropertyList(vmxICE.PropertyListHolder list)
    {
        return getPropertyList(list, null);
    }

    /**
     * 获取对象的状态。
     * 
     * @param state 状态值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getState(vmxICE.ObjectStateHolder state)
    {
        return getState(state, null);
    }

    /**
     * 获取对象的统计信息.
     * 
     * @param info 格式化的统计信息
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getStatistics(vmxICE.StatisticsListHolder info)
    {
        return getStatistics(info, null);
    }

    /**
     * 接收消息的回调函数，由框架触发，而不是使用者.
     * 
     * @param msg 消息的内容，通过vmx_msg::CMessage类来解析，该类描述在基础库libmessage的mmap_libmessage.h头文件中。
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    recvMessage(byte[] msg)
    {
        return recvMessage(msg, null);
    }

    /**
     * 消息注册函数，将ICE ID为参数ObjectID的对象注册到被调用的对象上，当被调用的对象抛出了ID为msgID的消息时，ICE ID为ObjectID的对象将会收到该消息.
     * 
     * @param msgID 消息的ID, ID类型描述在基础库libmessage的mmap_libmessage.h头文件中，或者在某个项目对消息类的扩展的头文件定义中。
     * @param ObjectID 要接收消息的对象的ICE ID。
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    registerMsg(int msgID, String ObjectID)
    {
        return registerMsg(msgID, ObjectID, null);
    }

    /**
     * 消息注册函数，和[registerMsg]不同之处在于这个函数支持通过ice的locator来进行注册，也即是说想要获取消息的对象可以和目标对象不在同一个icegrid中.
     * 
     * @param msgID 消息的ID, ID类型描述在基础库libmessage的mmap_libmessage.h头文件中，或者在某个项目对消息类的扩展的头文件定义中。
     * @param ObjectID 要接收消息的对象的ICE ID。
     * @param locator 对应ice框架中的locator。
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    registerMsgWithLocator(int msgID, String ObjectID, String locator)
    {
        return registerMsgWithLocator(msgID, ObjectID, locator, null);
    }

    /**
     * 给对象设置所有者，对象的大部分消息都会给所有者发送.
     * 
     * @param parent 父亲的ICE ID.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setParent(String parent)
    {
        return setParent(parent, null);
    }

    /**
     * 设置属性值.
     * 
     * @param name 属性名称
     * @param value 属性值
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setProperty(String name, String value)
    {
        return setProperty(name, value, null);
    }

    /**
     * 以列表的形式设置指定属性的值.
     * 
     * @param list 属性名称和对应的值的列表
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setPropertyList(java.util.Map<java.lang.String, java.lang.String> list)
    {
        return setPropertyList(list, null);
    }

    /**
     * 设置对象的状态。
     * 
     * @param state 状态值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setState(vmxICE.ObjectState state)
    {
        return setState(state, null);
    }

    /**
     * 消息取消注册函数，将ICE ID为参数ObjectID的对象取消在被调用对象上针对ID为msgID的消息的关注，如果msgID为CMessage::MSG_ID_NULL，
     * 则取消ICE ID为objectID对象在被调用对象上所有消息的注册.
     * 
     * @param msgID 消息的ID, ID类型描述在基础库libmessage的mmap_libmessage.h头文件中，或者在某个项目对消息类的扩展的头文件定义中。
     * @param ObjectID 要取消接收消息的对象的ICE ID。
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    unregisterMsg(int msgID, String ObjectID)
    {
        return unregisterMsg(msgID, ObjectID, null);
    }

    /**
     * 消息取消注册函数，和[unregisterMsg]不同之处在于这个函数支持通过ice的locator来进行注册，也即是说想要取消注册消息的对象可以和目标对象不在同一个icegrid中.
     * 
     * @param msgID 消息的ID, ID类型描述在基础库libmessage的mmap_libmessage.h头文件中，或者在某个项目对消息类的扩展的头文件定义中。
     * @param ObjectID 要接收消息的对象的ICE ID。
     * @param locator 对应ice框架中的locator。
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    unregisterMsgWithLocator(int msgID, String ObjectID, String locator)
    {
        return unregisterMsgWithLocator(msgID, ObjectID, locator, null);
    }

    /**
     * 获取高级配置项的值.
     * 
     * @param name 高级配置项的名称.
     * @param value 高级配置项的值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getAdvanceConfigInfo(String name, Ice.StringHolder value)
    {
        return getAdvanceConfigInfo(name, value, null);
    }

    /**
     * 以列表形式获取所有高级配置项的名称，值的类型，范围，当前值，默认值.
     * 
     * @param StringSeq 调试的信息列表，格式为:名称,当前值,高级配置项描述,高级配置项的值的类型,默认值,范围(如果值类型为select，则以|为间隔枚举所有选择项，如果为int，则用a-b来设置范围)
     * </p>高级配置项的值的类型列表:
     * <ul>
     * <li> select - 列表中单选     </li> 
     * <li> string - 字符串         </li> 
     * <li> int - 数值              </li> 
     * <li> bool - 布尔值           </li> 
     * </ul> 
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getAdvanceConfigInfoList(vmxICE.ConfigInfoSeqHolder configInfoSequence)
    {
        return getAdvanceConfigInfoList(configInfoSequence, null);
    }

    /**
     * 获取配置项的值.
     * 
     * @param name 配置项的名称.
     * @param value 配置项的值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getConfigInfo(String name, Ice.StringHolder value)
    {
        return getConfigInfo(name, value, null);
    }

    /**
     * 以列表形式获取所有配置项的名称，值的类型，范围，当前值，默认值.
     * 
     * @param StringSeq 配置项的信息列表，格式为:名称,当前值,配置项描述,配置项的值的类型,默认值,范围(如果值类型为select，则以|为间隔枚举所有选择项，如果为int，则用a-b来设置范围)
     * </p>配置项的值的类型列表:
     * <ul>
     * <li> select - 列表中单选     </li> 
     * <li> string - 字符串         </li> 
     * <li> int - 数值              </li> 
     * <li> bool - 布尔值           </li> 
     * </ul> 
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getConfigInfoList(vmxICE.StringSeqHolder configInfoList)
    {
        return getConfigInfoList(configInfoList, null);
    }

    /**
     * 获取授权值
     * @param attrName  
     * @param value
     * 
     * @return 返回值为0代表成功, 否则为失败的错误码.
     * 
     **/
    public final int
    getLicense(String attrName, Ice.StringHolder attrValue)
    {
        return getLicense(attrName, attrValue, null);
    }

    /**
     * 注册一个ice对象到系统中，用于接收系统的消息， 注册的对象需要继承[Application]，消息类型参考[Message].
     * 
     * @param ID 想要接收消息的对象的ID.
     * @param locator Ice locator.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    registerCallbackWithLocator(String ID, String locator)
    {
        return registerCallbackWithLocator(ID, locator, null);
    }

    /**
     * 设置高级配置项的值，高级配置项和配置项的区别在于高级配置项不对普通用户公开，需要由集成商或者生产厂商进行配置。
     * 
     * @param name 高级配置项的名称.
     * @param value 高级配置项的值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setAdvanceConfigInfo(String name, String value)
    {
        return setAdvanceConfigInfo(name, value, null);
    }

    /**
     * 设置配置项的值.
     * 
     * @param name 配置项的名称.
     * @param value 配置项的值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setConfigInfo(String name, String value)
    {
        return setConfigInfo(name, value, null);
    }

    /**
     * 取消注册.
     * 
     * @param ID 想要取消接收消息的对象的ID.
     * @param locator Ice locator.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    unregisterCallbackWithLocator(String ID, String locator)
    {
        return unregisterCallbackWithLocator(ID, locator, null);
    }

    /**
     * 获取某个[ClientMgr]的ID.
     * 
     * @param index 想要获取的ClientMgr的索引.
     * @param ID ClientMgr的ID.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    GetClientMgrByIndex(int index, Ice.StringHolder ID)
    {
        return GetClientMgrByIndex(index, ID, null);
    }

    /**
     * 获取[ClientMgr]集合的数量.
     * 
     * @return ClientMgr的数量.
     * 
     **/
    public final int
    GetClientMgrCount()
    {
        return GetClientMgrCount(null);
    }

    /**
     * 获取所有[ClientMgr]的ID列表.
     * 
     * @param list 所有的ClientMgr的ID的列表.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    GetClientMgrList(vmxICE.StringSeqHolder list)
    {
        return GetClientMgrList(list, null);
    }

    /**
     * 获取某个[ConferenceMgr]的ID.
     * 
     * @param index 想要获取的ConferenceMgr的索引.
     * @param ID ConferenceMgr的ID.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    GetConferenceMgrByIndex(int index, Ice.StringHolder ID)
    {
        return GetConferenceMgrByIndex(index, ID, null);
    }

    /**
     * 获取MP包含的ConferenceMgr的数量.
     * 
     * @return ConferenceMgr的数量.
     * 
     **/
    public final int
    GetConferenceMgrCount()
    {
        return GetConferenceMgrCount(null);
    }

    /**
     * 获取所有[ConferenceMgr]的ID列表.
     * 
     * @param list 所有的ConferenceMgr的ID的列表.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    GetConferenceMgrList(vmxICE.StringSeqHolder list)
    {
        return GetConferenceMgrList(list, null);
    }

    /**
     * 获取log图片的路径.
     * 
     * @param path log图片在服务器上的路径.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    getLogoPath(Ice.StringHolder path)
    {
        return getLogoPath(path, null);
    }

    /**
     * 删除log图片.当无视频图像时，分屏将显示灰色.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    removeLogo()
    {
        return removeLogo(null);
    }

    /**
     * 设置log图片，用于无视频图像时的分屏显示画面.
     * 
     * @param path log图片在服务器上的路径.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public final int
    setLogoPath(String path)
    {
        return setLogoPath(path, null);
    }

    public static Ice.DispatchStatus
    ___GetClientMgrCount(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.GetClientMgrCount(__current);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___GetClientMgrByIndex(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        int index;
        index = __is.readInt();
        __is.endReadEncaps();
        Ice.StringHolder ID = new Ice.StringHolder();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.GetClientMgrByIndex(index, ID, __current);
        __os.writeString(ID.value);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___GetClientMgrList(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        vmxICE.StringSeqHolder list = new vmxICE.StringSeqHolder();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.GetClientMgrList(list, __current);
        vmxICE.StringSeqHelper.write(__os, list.value);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___GetConferenceMgrCount(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.GetConferenceMgrCount(__current);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___GetConferenceMgrByIndex(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        int index;
        index = __is.readInt();
        __is.endReadEncaps();
        Ice.StringHolder ID = new Ice.StringHolder();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.GetConferenceMgrByIndex(index, ID, __current);
        __os.writeString(ID.value);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___GetConferenceMgrList(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        vmxICE.StringSeqHolder list = new vmxICE.StringSeqHolder();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.GetConferenceMgrList(list, __current);
        vmxICE.StringSeqHelper.write(__os, list.value);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___setLogoPath(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String path;
        path = __is.readString();
        __is.endReadEncaps();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.setLogoPath(path, __current);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___getLogoPath(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        Ice.StringHolder path = new Ice.StringHolder();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.getLogoPath(path, __current);
        __os.writeString(path.value);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___removeLogo(MP __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.is().skipEmptyEncaps();
        IceInternal.BasicStream __os = __inS.os();
        int __ret = __obj.removeLogo(__current);
        __os.writeInt(__ret);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "GetClientMgrByIndex",
        "GetClientMgrCount",
        "GetClientMgrList",
        "GetConferenceMgrByIndex",
        "GetConferenceMgrCount",
        "GetConferenceMgrList",
        "enumMessageList",
        "enumProperty",
        "enumPropertyList",
        "getAdvanceConfigInfo",
        "getAdvanceConfigInfoList",
        "getConfigInfo",
        "getConfigInfoList",
        "getID",
        "getLicense",
        "getLogoPath",
        "getName",
        "getObjectType",
        "getParent",
        "getProperty",
        "getPropertyList",
        "getState",
        "getStatistics",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "recvMessage",
        "registerCallbackWithLocator",
        "registerMsg",
        "registerMsgWithLocator",
        "removeLogo",
        "setAdvanceConfigInfo",
        "setConfigInfo",
        "setLogoPath",
        "setParent",
        "setProperty",
        "setPropertyList",
        "setState",
        "unregisterCallbackWithLocator",
        "unregisterMsg",
        "unregisterMsgWithLocator"
    };

    public Ice.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___GetClientMgrByIndex(this, in, __current);
            }
            case 1:
            {
                return ___GetClientMgrCount(this, in, __current);
            }
            case 2:
            {
                return ___GetClientMgrList(this, in, __current);
            }
            case 3:
            {
                return ___GetConferenceMgrByIndex(this, in, __current);
            }
            case 4:
            {
                return ___GetConferenceMgrCount(this, in, __current);
            }
            case 5:
            {
                return ___GetConferenceMgrList(this, in, __current);
            }
            case 6:
            {
                return vmxICE._VMXObjectDisp.___enumMessageList(this, in, __current);
            }
            case 7:
            {
                return vmxICE._VMXObjectDisp.___enumProperty(this, in, __current);
            }
            case 8:
            {
                return vmxICE._VMXObjectDisp.___enumPropertyList(this, in, __current);
            }
            case 9:
            {
                return vmxICE._VMXSystemDisp.___getAdvanceConfigInfo(this, in, __current);
            }
            case 10:
            {
                return vmxICE._VMXSystemDisp.___getAdvanceConfigInfoList(this, in, __current);
            }
            case 11:
            {
                return vmxICE._VMXSystemDisp.___getConfigInfo(this, in, __current);
            }
            case 12:
            {
                return vmxICE._VMXSystemDisp.___getConfigInfoList(this, in, __current);
            }
            case 13:
            {
                return vmxICE._VMXObjectDisp.___getID(this, in, __current);
            }
            case 14:
            {
                return vmxICE._VMXSystemDisp.___getLicense(this, in, __current);
            }
            case 15:
            {
                return ___getLogoPath(this, in, __current);
            }
            case 16:
            {
                return vmxICE._VMXObjectDisp.___getName(this, in, __current);
            }
            case 17:
            {
                return vmxICE._VMXObjectDisp.___getObjectType(this, in, __current);
            }
            case 18:
            {
                return vmxICE._VMXObjectDisp.___getParent(this, in, __current);
            }
            case 19:
            {
                return vmxICE._VMXObjectDisp.___getProperty(this, in, __current);
            }
            case 20:
            {
                return vmxICE._VMXObjectDisp.___getPropertyList(this, in, __current);
            }
            case 21:
            {
                return vmxICE._VMXObjectDisp.___getState(this, in, __current);
            }
            case 22:
            {
                return vmxICE._VMXObjectDisp.___getStatistics(this, in, __current);
            }
            case 23:
            {
                return ___ice_id(this, in, __current);
            }
            case 24:
            {
                return ___ice_ids(this, in, __current);
            }
            case 25:
            {
                return ___ice_isA(this, in, __current);
            }
            case 26:
            {
                return ___ice_ping(this, in, __current);
            }
            case 27:
            {
                return vmxICE._VMXObjectDisp.___recvMessage(this, in, __current);
            }
            case 28:
            {
                return vmxICE._VMXSystemDisp.___registerCallbackWithLocator(this, in, __current);
            }
            case 29:
            {
                return vmxICE._VMXObjectDisp.___registerMsg(this, in, __current);
            }
            case 30:
            {
                return vmxICE._VMXObjectDisp.___registerMsgWithLocator(this, in, __current);
            }
            case 31:
            {
                return ___removeLogo(this, in, __current);
            }
            case 32:
            {
                return vmxICE._VMXSystemDisp.___setAdvanceConfigInfo(this, in, __current);
            }
            case 33:
            {
                return vmxICE._VMXSystemDisp.___setConfigInfo(this, in, __current);
            }
            case 34:
            {
                return ___setLogoPath(this, in, __current);
            }
            case 35:
            {
                return vmxICE._VMXObjectDisp.___setParent(this, in, __current);
            }
            case 36:
            {
                return vmxICE._VMXObjectDisp.___setProperty(this, in, __current);
            }
            case 37:
            {
                return vmxICE._VMXObjectDisp.___setPropertyList(this, in, __current);
            }
            case 38:
            {
                return vmxICE._VMXObjectDisp.___setState(this, in, __current);
            }
            case 39:
            {
                return vmxICE._VMXSystemDisp.___unregisterCallbackWithLocator(this, in, __current);
            }
            case 40:
            {
                return vmxICE._VMXObjectDisp.___unregisterMsg(this, in, __current);
            }
            case 41:
            {
                return vmxICE._VMXObjectDisp.___unregisterMsgWithLocator(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type vmxMP::MP was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type vmxMP::MP was not generated with stream support";
        throw ex;
    }
}
