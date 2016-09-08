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
// Generated from file `_MediaNodeOperations.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * [MediaNode]是mmap6框架中的多媒体节点基类，提供了多媒体节点的通用接口。
 **/
public interface _MediaNodeOperations extends _VMXObjectOperations
{
    /**
     * 枚举节点中所有Pad的信息。
     * 
     * @param list Pad信息列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int enumPadList(PadListHolder list, Ice.Current __current);

    /**
     * 枚举节点中指定index的Pad的信息。
     * 
     * @param dir pad的类型.
     * @param indexList index列表.
     * @param list Pad列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int queryPadByIndex(PadDirection dir, int[] indexList, PadListHolder list, Ice.Current __current);

    /**
     * 枚举节点中的输入或者输出pad的信息。
     * 
     * @param dir pad的输入输出类型.
     * @param list Pad列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int queryPadByDirection(PadDirection dir, PadListHolder list, Ice.Current __current);

    /**
     * 设置节点中指定index的Pad的媒体流描述信息。
     * 
     * @param dir pad的类型.
     * @param index pad的索引.
     * @param capability 媒体流的详细描述.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int setPadCapability(PadDirection dir, int index, String capability, Ice.Current __current);

    /**
     * 获取节点中指定index的Pad的媒体流描述信息。
     * 
     * @param dir pad的类型.
     * @param index pad的索引.
     * @param capability 媒体流的详细描述.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getPadCapability(PadDirection dir, int index, Ice.StringHolder capability, Ice.Current __current);

    /**
     * 接收事件的回调函数，由框架触发，而不是使用者.
     * 
     * @param dir pad的类型.
     * @param index pad的索引.
     * @param event 事件的内容，通过vmx_event::CEvent类来解析，该类描述在基础库libevent的mmap_libevent.h头文件中。
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int recvEvent(PadDirection dir, int index, byte[] event, Ice.Current __current);

    /**
     * 枚举节点在运行过程中会发送的所有事件的ID及其描述。
     * 
     * @param msgList 事件ID列表，在vmx_msg::CEvent类中有基础定义，另外在各项目中可能会有扩展定义.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int enumEventList(EventDescListHolder eventList, Ice.Current __current);

    /**
     * 获取和节点相连的上游节点列表。
     * 
     * @param list 上游节点的描述列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getSourceList(LinkListHolder list, Ice.Current __current);

    /**
     * 获取和节点相连的下游节点列表。
     * 
     * @param list 下游节点的描述列表.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int getDeliverList(LinkListHolder list, Ice.Current __current);

    /**
     * 添加节点的下一个数据传输节点。
     * 
     * @param dst 接收数据的节点的ICE ID.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int addDeliverDst(String dst, Ice.Current __current);

    /**
     * 添加节点的下一个数据传输节点，和[addDeliverDst]的区别在于可以设置源节点和目标节点的PadIndex，用于指定传输源节点的哪条数据流到目标节点的哪个接收Pad上。
     * 
     * @param dst 接收数据的节点的ICE ID.
     * @param dstPadIndex 接收数据的节点的输入pad索引，如果为[InvalidPadIndex]则表示不指定.
     * @param srcPadIndex 传输数据的节点的输出pad索引，如果为[InvalidPadIndex]则表示不指定.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int addDeliverDstEx(String dst, int dstPadIndex, int srcPadIndex, Ice.Current __current);

    /**
     * 删除与操作节点相连的下一个节点。
     * 
     * @param dst 下游节点的ICE ID.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int removeDeliverDst(String dst, Ice.Current __current);

    /**
     * 删除与操作节点相连的下一个节点，和[removeDeliverDst]的区别在于可以设置源节点和目标节点的PadIndex。
     * 
     * @param dst 下游节点的ICE ID.
     * @param dstPadIndex 接收数据的节点的输入pad索引，如果为[InvalidPadIndex]则表示不指定.
     * @param srcPadIndex 传输数据的节点的输出pad索引，如果为[InvalidPadIndex]则表示不指定.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int removeDeliverDstEx(String dst, int dstPadIndex, int srcPadIndex, Ice.Current __current);

    /**
     * 节点的接收数据函数。
     * 
     * @param padIndex 数据到达的节点的pad的索引，索引的值需要和调用[addDeliverDstEx]时设定的index相同.
     * @param seq 传递的数据包，数据包的格式通过vmx_media::IMediaFrameBuffer的toVector()获取，同样，这种数据包可以通过vmx_media::IMediaFrameBuffer.fromVector()来解析.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    void recvMedia(int padIndex, byte[] seq, Ice.Current __current);

    /**
     * 节点的连接函数，由内部框架调用，不应该由应用调用。
     * 
     * @param sourceID 上游节点的ID.
     * @param sourcePadIndex 上游节点的pad索引.
     * @param sourceName 上游节点的名称.
     * @param dstPadIndex 下游节点的pad索引，如果为[InvalidPadIndex]则表示由下游节点选择并通过输出参数[outDstPadIndex]返回给调用者。
     * @param outDstPadIndex 下游节点的pad索引。
     * @param dstNodeName 下游节点的名称，由下游节点返回给调用者.
     * @param dstMgrID 下游节点所在池的ice ID.
     * @param dstNodeIndex 下游节点所在池中节点自身的索引，用于通过池来传输数据.
     * @param mode 数据传输的模式
     * @param modeInfo 传输模式的附加信息，根据传输模式的参数来确定其中包含的信息，谁提供传输模式，谁就必须给出传输信息。例如如果调用者设定传输模式为共享内存，则需要调用者填充共享内存的名称.
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int addSource(String sourceID, int sourcePadIndex, String sourceName, int dstPadIndex, TransferMode mode, String modeInfo, Ice.IntHolder outDstPadIndex, Ice.StringHolder dstNodeName, Ice.StringHolder dstMgrID, Ice.IntHolder dstNodeIndex, Ice.Current __current);

    /**
     * 节点的断开连接函数，由内部框架调用，不应该由应用调用。
     * 
     * @param sourceID 上游节点的ID.
     * @param sourcePadIndex 上游节点的pad索引.
     * @param dstPadIndex 下游节点的pad索引，如果为[InvalidPadIndex]则表示由下游节点选择并作为输出参数返回给调用者。
     * 
     * @param __current The Current object for the invocation.
     * @return 返回值为0代表成功，否则为失败的错误码.
     * 
     **/
    int removeSource(String sourceID, int sourcePadIndex, int dstPadIndex, Ice.Current __current);
}
