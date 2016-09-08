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
// Generated from file `_ClientOperationsNC.java'
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
public interface _ClientOperationsNC extends vmxICE._ResourceOperationsNC
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
    int setClientName(String name);

    /**
     * 获取客户端名称.
     * 
     * @param name 输出客户端名称
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getClientName(Ice.StringHolder name);

    /**
     * 获取客户端的连接状态.
     * 
     * @param state 连接状态，参考枚举[ClientConnectState].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getConnectState(ClientConnectStateHolder state);

    /**
     * 设置客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int setConnectMode(ClientConnectMode mode);

    /**
     * 获取客户端的连接模式.
     * 
     * @param mode 连接模式，参考[ClientConnectMode].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getConnectMode(ClientConnectModeHolder mode);

    /**
     * 获取客户端的类型.
     * 
     * @param type 客户端的类型，参考[ClientType].
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getClientType(ClientTypeHolder type);

    /**
     * 连接客户端,在调用该函数成功之后,客户端的状态会立即转换为[ConnectStateConnecting],但是该函数成功不代表连接已经成功,调用者需要根据连接成功的消息才能确定该客户端真正建立连接.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int connect();

    /**
     * 中断和客户端的连接,如果客户端在会议中是发言者,调用该接口之前必须取消其发言者身份,否则会导致其它观看发言者的客户端收到的图像静止在挂断之前.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int disconnect();

    /**
     * 重新协商码流的能力集.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int updateMediaCapability();

    /**
     * 执行客户端支持的某个命令.
     * 
     * @param cmd 命令结构，包含命令的类型及值.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int execCommand(Command cmd);

    /**
     * 枚举客户端支持的命令列表.
     * 
     * @param list 命令列表，包括命令名称及说明.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int enumSupportCommand(CommandListHolder list);

    /**
     * 关闭客户端对象, 所有的资源都将被释放或者重置. 用于重置客户端对象使其可以连接一个新的终端.
     * 
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int close();
}
