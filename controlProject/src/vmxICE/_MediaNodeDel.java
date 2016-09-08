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
// Generated from file `_MediaNodeDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

public interface _MediaNodeDel extends _VMXObjectDel
{
    int enumPadList(PadListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int queryPadByIndex(PadDirection dir, int[] indexList, PadListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int queryPadByDirection(PadDirection dir, PadListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setPadCapability(PadDirection dir, int index, String capability, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getPadCapability(PadDirection dir, int index, Ice.StringHolder capability, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int recvEvent(PadDirection dir, int index, byte[] event, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int enumEventList(EventDescListHolder eventList, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getSourceList(LinkListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int getDeliverList(LinkListHolder list, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int addDeliverDst(String dst, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int addDeliverDstEx(String dst, int dstPadIndex, int srcPadIndex, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int removeDeliverDst(String dst, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int removeDeliverDstEx(String dst, int dstPadIndex, int srcPadIndex, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void recvMedia(int padIndex, byte[] seq, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int addSource(String sourceID, int sourcePadIndex, String sourceName, int dstPadIndex, TransferMode mode, String modeInfo, Ice.IntHolder outDstPadIndex, Ice.StringHolder dstNodeName, Ice.StringHolder dstMgrID, Ice.IntHolder dstNodeIndex, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int removeSource(String sourceID, int sourcePadIndex, int dstPadIndex, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
