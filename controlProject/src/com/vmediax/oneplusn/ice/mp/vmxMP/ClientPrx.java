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
// Generated from file `ClientPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * Client是一个客户端在服务器端的虚拟代理，用于设置终端的信息然后加入[Conference]会议对象进行多点会议， 客户端可能是323终端，或者sip终端等.
 * 
 * <br><br>属性列表<br>
 * 
 * <b>所有类型客户端的属性列表:</b><br>
 * <ul>remote: 客户端的IP地址(如果是rtsp客户端，则为rtsp的uri, 没有默认值, 属性名对应的定义为[PropertyIpAddr].                                                                   </ul>
 * <ul>bandwidth: 带宽, 默认值为"2048", 属性名对应的定义为[PropertyBandwidth].                                                                           </ul>
 * <ul>audioCodec: 音频编解码类型, 默认值为"auto", 即自动协商，可以选择"auto/G711/G722/G722.1/G722.1C/G723.1/G728/G729", 属性名对应的定义为[PropertyAudioCodec].     </ul>
 * <ul>videoCodec: 视频编解码类型, 默认值为"auto", 即自动协商, 可以选择"auto/H264/H263", 属性名对应的定义为[PropertyVideoCodec]                                      </ul>
 * <ul>videoReceiveSize: 服务器发送到客户端的视频图像大小, 默认值为"720p", 可以选择"qcif/cif/4cif/XGA/720p/1080p", 属性名对应的定义为[PropertyVideoRxSize].     </ul>
 * <ul>videoTransmitSize: 客户端发送到服务器的视频图像大小, 默认值为"720p", 可以选择"qcif/cif/4cif/XGA/720p/1080p", 属性名对应的定义为[PropertyVideoTxSize].    </ul>
 * 
 * <b>323类型客户端的属性列表:</b></p>                                                                                                            
 * <ul>port: 323协议栈的端口, 默认值为"1332", 属性名对应的定义为[PropertyPort].                                                                                          </ul>
 * <ul>h323: h323 name, 无默认值, 属性名对应的定义为[PropertyH323Name].                                                                                                      </ul>
 * <ul>e164: e164 name, 无默认值, 属性名对应的定义为[PropertyE164].                                                                                                      </ul>
 * <ul>videoExtCodec: 视频辅流的编解码类型, 默认值是"auto", 即自动协商, 可以选择"auto/H264/H263", 属性名对应的定义为[PropertyVideoExtCodec]                                       </ul>
 * <ul>videoExtSizeRx: 视频辅流的服务器发送到客户端的视频图像大小, 默认值为"XGA", 可以选择"qcif/cif/4cif/XGA/720p/1080p", 属性名对应的定义为[PropertyVideoExtSizeRx].                      </ul>
 * <ul>videoExtSizeTx: 视频辅流的客户端发送的服务器的视频大小, 默认值是"XGA", 可以选择"qcif/cif/4cif/XGA/720p/1080p", 属性名对应的定义为[PropertyVideoExtSizeTx].                         </ul>
 * <ul>allowSendExtVideo: 允许客户端发送视频辅流, 默认值是"false", 可以选择"true/false", 属性名对应的定义为[PropertyAllowSendExtVideo]                                         </ul>
 * 
 * <b>sip类型客户端的属性列表:</b></p>                                                                                                          
 * <ul>userName：注册到SIP服务器的用户名，无默认值.                                                                                       </ul>
 * <ul>domain：注册的域，无默认值.                                                                                       </ul>
 * <ul>authName：注册时的授权名，无默认值.                                                                                       </ul>
 * <ul>passWord：密码，无默认值.                                                                                       </ul>
 * <ul>sipServerIP：SIP注册服务器的地址，无默认值.                                                                                     </ul>    
 * 
 * <b>flash类型客户端的属性列表:</b></p>                                                                                                    
 * <ul>rtmpDownStreamName：下行媒体流的名字,属性名对应的定义为[PropertyRtmpDownStreamName].                                                                                       </ul>
 * <ul>rtmpUpStreamName：上行行媒体流的名字,属性名对应的定义为[PropertyRtmpUpStreamName].                                                                                       </ul>
 * <ul>rtmpDownExtStreamName：辅流媒体流的名字,属性名对应的定义为[PropertyRtmpDownExtStreamName].                                                                                     </ul>
 * <ul>rtmpUpExtStreamName：辅流媒体流的名字,属性名对应的定义为[PropertyRtmpUpExtStreamName].                                                                                     </ul>
 * <ul>rtmpAppName：rtmp程序名,属性名对应的定义为[PropertyRtmpAppName].                                                                                               </ul>
 * 
 * <b>rtsp类型客户端的属性列表:</b></p>                                                                                                                                                                                            </ul>
 * <ul>protocols：传输协议的类型，默认值是udp，可以选择"udp/tcp/http".                                                                                       </ul>    
 * <ul>latency：缓冲的时间，默认值是"0".                                                                                       </ul>    
 * 
 * @see Conference
 * @see ClientMgr
 **/
public interface ClientPrx extends vmxICE.ResourcePrx
{
    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * <ul> [ErrInvalidParameter] - 客户端名称为空. </ul>
     * 
     **/
    public int setClientName(String name);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * <ul> [ErrInvalidParameter] - 客户端名称为空. </ul>
     * 
     **/
    public int setClientName(String name, java.util.Map<String, String> __ctx);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setClientName(String name);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setClientName(String name, java.util.Map<String, String> __ctx);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setClientName(String name, Ice.Callback __cb);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setClientName(String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setClientName(String name, Callback_Client_setClientName __cb);

    /**
     * 设置客户端名称.
     * 
     * @param name 客户端名称
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setClientName(String name, java.util.Map<String, String> __ctx, Callback_Client_setClientName __cb);

    /**
     * 设置客户端名称.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * <ul> [ErrInvalidParameter] - 客户端名称为空. </ul>
     * 
     **/
    public int end_setClientName(Ice.AsyncResult __result);

    /**
     * 获取客户端名称.
     * 
     * @param name 输出客户端名称
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getClientName(Ice.StringHolder name);

    /**
     * 获取客户端名称.
     * 
     * @param name 输出客户端名称
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getClientName(Ice.StringHolder name, java.util.Map<String, String> __ctx);

    /**
     * 获取客户端名称.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientName();

    /**
     * 获取客户端名称.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientName(java.util.Map<String, String> __ctx);

    /**
     * 获取客户端名称.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientName(Ice.Callback __cb);

    /**
     * 获取客户端名称.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientName(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 获取客户端名称.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientName(Callback_Client_getClientName __cb);

    /**
     * 获取客户端名称.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientName(java.util.Map<String, String> __ctx, Callback_Client_getClientName __cb);

    /**
     * 获取客户端名称.
     * 
     * @param name 输出客户端名称
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_getClientName(Ice.StringHolder name, Ice.AsyncResult __result);

    /**
     * 获取客户端的连接状态.
     * 
     * @param state 连接状态，参考枚举[ClientConnectState].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getConnectState(ClientConnectStateHolder state);

    /**
     * 获取客户端的连接状态.
     * 
     * @param state 连接状态，参考枚举[ClientConnectState].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getConnectState(ClientConnectStateHolder state, java.util.Map<String, String> __ctx);

    /**
     * 获取客户端的连接状态.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectState();

    /**
     * 获取客户端的连接状态.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectState(java.util.Map<String, String> __ctx);

    /**
     * 获取客户端的连接状态.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectState(Ice.Callback __cb);

    /**
     * 获取客户端的连接状态.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectState(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 获取客户端的连接状态.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectState(Callback_Client_getConnectState __cb);

    /**
     * 获取客户端的连接状态.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectState(java.util.Map<String, String> __ctx, Callback_Client_getConnectState __cb);

    /**
     * 获取客户端的连接状态.
     * 
     * @param state 连接状态，参考枚举[ClientConnectState].
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_getConnectState(ClientConnectStateHolder state, Ice.AsyncResult __result);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int setConnectMode(ClientConnectMode mode);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int setConnectMode(ClientConnectMode mode, java.util.Map<String, String> __ctx);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConnectMode(ClientConnectMode mode);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConnectMode(ClientConnectMode mode, java.util.Map<String, String> __ctx);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConnectMode(ClientConnectMode mode, Ice.Callback __cb);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConnectMode(ClientConnectMode mode, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConnectMode(ClientConnectMode mode, Callback_Client_setConnectMode __cb);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_setConnectMode(ClientConnectMode mode, java.util.Map<String, String> __ctx, Callback_Client_setConnectMode __cb);

    /**
     * 设置客户端的连接模式.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_setConnectMode(Ice.AsyncResult __result);

    /**
     * 获取客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getConnectMode(ClientConnectModeHolder mode);

    /**
     * 获取客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getConnectMode(ClientConnectModeHolder mode, java.util.Map<String, String> __ctx);

    /**
     * 获取客户端的连接模式.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectMode();

    /**
     * 获取客户端的连接模式.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectMode(java.util.Map<String, String> __ctx);

    /**
     * 获取客户端的连接模式.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectMode(Ice.Callback __cb);

    /**
     * 获取客户端的连接模式.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectMode(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 获取客户端的连接模式.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectMode(Callback_Client_getConnectMode __cb);

    /**
     * 获取客户端的连接模式.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getConnectMode(java.util.Map<String, String> __ctx, Callback_Client_getConnectMode __cb);

    /**
     * 获取客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_getConnectMode(ClientConnectModeHolder mode, Ice.AsyncResult __result);

    /**
     * 获取客户端的类型.
     * 
     * @param type 客户端的类型，参考[ClientType].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getClientType(ClientTypeHolder type);

    /**
     * 获取客户端的类型.
     * 
     * @param type 客户端的类型，参考[ClientType].
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int getClientType(ClientTypeHolder type, java.util.Map<String, String> __ctx);

    /**
     * 获取客户端的类型.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientType();

    /**
     * 获取客户端的类型.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientType(java.util.Map<String, String> __ctx);

    /**
     * 获取客户端的类型.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientType(Ice.Callback __cb);

    /**
     * 获取客户端的类型.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientType(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 获取客户端的类型.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientType(Callback_Client_getClientType __cb);

    /**
     * 获取客户端的类型.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getClientType(java.util.Map<String, String> __ctx, Callback_Client_getClientType __cb);

    /**
     * 获取客户端的类型.
     * 
     * @param type 客户端的类型，参考[ClientType].
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_getClientType(ClientTypeHolder type, Ice.AsyncResult __result);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int connect();

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int connect(java.util.Map<String, String> __ctx);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_connect();

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_connect(java.util.Map<String, String> __ctx);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_connect(Ice.Callback __cb);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_connect(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_connect(Callback_Client_connect __cb);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_connect(java.util.Map<String, String> __ctx, Callback_Client_connect __cb);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_connect(Ice.AsyncResult __result);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int disconnect();

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int disconnect(java.util.Map<String, String> __ctx);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_disconnect();

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_disconnect(java.util.Map<String, String> __ctx);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_disconnect(Ice.Callback __cb);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_disconnect(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_disconnect(Callback_Client_disconnect __cb);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_disconnect(java.util.Map<String, String> __ctx, Callback_Client_disconnect __cb);

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_disconnect(Ice.AsyncResult __result);

    /**
     * 重新协商码流的能力集.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int updateMediaCapability();

    /**
     * 重新协商码流的能力集.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int updateMediaCapability(java.util.Map<String, String> __ctx);

    /**
     * 重新协商码流的能力集.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_updateMediaCapability();

    /**
     * 重新协商码流的能力集.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_updateMediaCapability(java.util.Map<String, String> __ctx);

    /**
     * 重新协商码流的能力集.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_updateMediaCapability(Ice.Callback __cb);

    /**
     * 重新协商码流的能力集.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_updateMediaCapability(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 重新协商码流的能力集.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_updateMediaCapability(Callback_Client_updateMediaCapability __cb);

    /**
     * 重新协商码流的能力集.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_updateMediaCapability(java.util.Map<String, String> __ctx, Callback_Client_updateMediaCapability __cb);

    /**
     * 重新协商码流的能力集.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_updateMediaCapability(Ice.AsyncResult __result);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int execCommand(Command cmd);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int execCommand(Command cmd, java.util.Map<String, String> __ctx);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_execCommand(Command cmd);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_execCommand(Command cmd, java.util.Map<String, String> __ctx);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_execCommand(Command cmd, Ice.Callback __cb);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_execCommand(Command cmd, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_execCommand(Command cmd, Callback_Client_execCommand __cb);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_execCommand(Command cmd, java.util.Map<String, String> __ctx, Callback_Client_execCommand __cb);

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_execCommand(Ice.AsyncResult __result);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param list 命令列表，包括命令名称及说明.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int enumSupportCommand(CommandListHolder list);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param list 命令列表，包括命令名称及说明.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int enumSupportCommand(CommandListHolder list, java.util.Map<String, String> __ctx);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumSupportCommand();

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumSupportCommand(java.util.Map<String, String> __ctx);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumSupportCommand(Ice.Callback __cb);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumSupportCommand(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumSupportCommand(Callback_Client_enumSupportCommand __cb);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_enumSupportCommand(java.util.Map<String, String> __ctx, Callback_Client_enumSupportCommand __cb);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param list 命令列表，包括命令名称及说明.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_enumSupportCommand(CommandListHolder list, Ice.AsyncResult __result);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int close();

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int close(java.util.Map<String, String> __ctx);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_close();

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_close(java.util.Map<String, String> __ctx);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_close(Ice.Callback __cb);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_close(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_close(Callback_Client_close __cb);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_close(java.util.Map<String, String> __ctx, Callback_Client_close __cb);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @param __result The asynchronous result object.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    public int end_close(Ice.AsyncResult __result);
}
