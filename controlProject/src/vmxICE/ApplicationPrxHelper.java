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
// Generated from file `ApplicationPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package vmxICE;

/**
 * 应用接口类，应用如果需要接收[VMXSystem]发送出来的消息，需要继承这个接口并将自己的ice id通过MP的函数[registerCallbackWithLocator]注册到[VMXSystem]中。
 **/
public final class ApplicationPrxHelper extends Ice.ObjectPrxHelperBase implements ApplicationPrx
{
    public int
    onReveiceMessage(Message msg)
    {
        return onReveiceMessage(msg, null, false);
    }

    public int
    onReveiceMessage(Message msg, java.util.Map<String, String> __ctx)
    {
        return onReveiceMessage(msg, __ctx, true);
    }

    private int
    onReveiceMessage(Message msg, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("onReveiceMessage");
                __delBase = __getDelegate(false);
                _ApplicationDel __del = (_ApplicationDel)__delBase;
                return __del.onReveiceMessage(msg, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __onReveiceMessage_name = "onReveiceMessage";

    public Ice.AsyncResult begin_onReveiceMessage(Message msg)
    {
        return begin_onReveiceMessage(msg, null, false, null);
    }

    public Ice.AsyncResult begin_onReveiceMessage(Message msg, java.util.Map<String, String> __ctx)
    {
        return begin_onReveiceMessage(msg, __ctx, true, null);
    }

    public Ice.AsyncResult begin_onReveiceMessage(Message msg, Ice.Callback __cb)
    {
        return begin_onReveiceMessage(msg, null, false, __cb);
    }

    public Ice.AsyncResult begin_onReveiceMessage(Message msg, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_onReveiceMessage(msg, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_onReveiceMessage(Message msg, Callback_Application_onReveiceMessage __cb)
    {
        return begin_onReveiceMessage(msg, null, false, __cb);
    }

    public Ice.AsyncResult begin_onReveiceMessage(Message msg, java.util.Map<String, String> __ctx, Callback_Application_onReveiceMessage __cb)
    {
        return begin_onReveiceMessage(msg, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_onReveiceMessage(Message msg, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__onReveiceMessage_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __onReveiceMessage_name, __cb);
        try
        {
            __result.__prepare(__onReveiceMessage_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            msg.__write(__os);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public int end_onReveiceMessage(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __onReveiceMessage_name);
        if(!__result.__wait())
        {
            try
            {
                __result.__throwUserException();
            }
            catch(Ice.UserException __ex)
            {
                throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
            }
        }
        int __ret;
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __ret = __is.readInt();
        __is.endReadEncaps();
        return __ret;
    }

    public boolean
    onReveiceMessage_async(AMI_Application_onReveiceMessage __cb, Message msg)
    {
        Ice.AsyncResult __r;
        try
        {
            __checkTwowayOnly(__onReveiceMessage_name);
            __r = begin_onReveiceMessage(msg, null, false, __cb);
        }
        catch(Ice.TwowayOnlyException ex)
        {
            __r = new IceInternal.OutgoingAsync(this, __onReveiceMessage_name, __cb);
            __r.__exceptionAsync(ex);
        }
        return __r.sentSynchronously();
    }

    public boolean
    onReveiceMessage_async(AMI_Application_onReveiceMessage __cb, Message msg, java.util.Map<String, String> __ctx)
    {
        Ice.AsyncResult __r;
        try
        {
            __checkTwowayOnly(__onReveiceMessage_name);
            __r = begin_onReveiceMessage(msg, __ctx, true, __cb);
        }
        catch(Ice.TwowayOnlyException ex)
        {
            __r = new IceInternal.OutgoingAsync(this, __onReveiceMessage_name, __cb);
            __r.__exceptionAsync(ex);
        }
        return __r.sentSynchronously();
    }

    public static ApplicationPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ApplicationPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ApplicationPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    ApplicationPrxHelper __h = new ApplicationPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ApplicationPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ApplicationPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ApplicationPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    ApplicationPrxHelper __h = new ApplicationPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ApplicationPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ApplicationPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    ApplicationPrxHelper __h = new ApplicationPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ApplicationPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ApplicationPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    ApplicationPrxHelper __h = new ApplicationPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ApplicationPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ApplicationPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ApplicationPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                ApplicationPrxHelper __h = new ApplicationPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static ApplicationPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ApplicationPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ApplicationPrxHelper __h = new ApplicationPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::vmxICE::Application"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ApplicationDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ApplicationDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ApplicationPrx v)
    {
        __os.writeProxy(v);
    }

    public static ApplicationPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ApplicationPrxHelper result = new ApplicationPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
