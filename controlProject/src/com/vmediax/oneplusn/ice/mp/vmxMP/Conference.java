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
// Generated from file `Conference.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.mp.vmxMP;

/**
 * Conference是会议的抽象化对象.
 * <br><br>属性列表<br>
 * <ul>cycleInterval: 分屏为轮询模式时的轮询时间间隔,单位为秒,默认值为5s. </ul>
 * <ul>name: 会议的名称. </ul>
 * <ul>ID: 会议的ID. </ul>
 * <ul>password: 会议的密码. </ul>
 * 
 **/
public interface Conference extends Ice.Object,
                                    _ConferenceOperations, _ConferenceOperationsNC,
                                    vmxICE.VMXObject
{
}
