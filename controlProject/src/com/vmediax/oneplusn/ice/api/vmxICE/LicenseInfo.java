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
// Generated from file `LicenseInfo.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.vmediax.oneplusn.ice.api.vmxICE;

public class LicenseInfo implements java.lang.Cloneable, java.io.Serializable
{
    public String bind;

    public String expire;

    public String companyName;

    public String webURL;

    public String supportEmail;

    public String productName;

    public String serialNumber;

    public int callMax;

    public int h323CallMax;

    public int sipCallMax;

    public int rtspCallMax;

    public String sipEnable;

    public String feccEnable;

    public String subtitleEnable;

    public String videoExtEnable;

    public String videoCodecEnable;

    public String videoSizeMaxVSM;

    public String audiosupportFormat;

    public String audioCodecEnable;

    public int bandwidthMax;

    public int conferenceMax;

    public LicenseInfo()
    {
    }

    public LicenseInfo(String bind, String expire, String companyName, String webURL, String supportEmail, String productName, String serialNumber, int callMax, int h323CallMax, int sipCallMax, int rtspCallMax, String sipEnable, String feccEnable, String subtitleEnable, String videoExtEnable, String videoCodecEnable, String videoSizeMaxVSM, String audiosupportFormat, String audioCodecEnable, int bandwidthMax, int conferenceMax)
    {
        this.bind = bind;
        this.expire = expire;
        this.companyName = companyName;
        this.webURL = webURL;
        this.supportEmail = supportEmail;
        this.productName = productName;
        this.serialNumber = serialNumber;
        this.callMax = callMax;
        this.h323CallMax = h323CallMax;
        this.sipCallMax = sipCallMax;
        this.rtspCallMax = rtspCallMax;
        this.sipEnable = sipEnable;
        this.feccEnable = feccEnable;
        this.subtitleEnable = subtitleEnable;
        this.videoExtEnable = videoExtEnable;
        this.videoCodecEnable = videoCodecEnable;
        this.videoSizeMaxVSM = videoSizeMaxVSM;
        this.audiosupportFormat = audiosupportFormat;
        this.audioCodecEnable = audioCodecEnable;
        this.bandwidthMax = bandwidthMax;
        this.conferenceMax = conferenceMax;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        LicenseInfo _r = null;
        try
        {
            _r = (LicenseInfo)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(bind != _r.bind)
            {
                if(bind == null || _r.bind == null || !bind.equals(_r.bind))
                {
                    return false;
                }
            }
            if(expire != _r.expire)
            {
                if(expire == null || _r.expire == null || !expire.equals(_r.expire))
                {
                    return false;
                }
            }
            if(companyName != _r.companyName)
            {
                if(companyName == null || _r.companyName == null || !companyName.equals(_r.companyName))
                {
                    return false;
                }
            }
            if(webURL != _r.webURL)
            {
                if(webURL == null || _r.webURL == null || !webURL.equals(_r.webURL))
                {
                    return false;
                }
            }
            if(supportEmail != _r.supportEmail)
            {
                if(supportEmail == null || _r.supportEmail == null || !supportEmail.equals(_r.supportEmail))
                {
                    return false;
                }
            }
            if(productName != _r.productName)
            {
                if(productName == null || _r.productName == null || !productName.equals(_r.productName))
                {
                    return false;
                }
            }
            if(serialNumber != _r.serialNumber)
            {
                if(serialNumber == null || _r.serialNumber == null || !serialNumber.equals(_r.serialNumber))
                {
                    return false;
                }
            }
            if(callMax != _r.callMax)
            {
                return false;
            }
            if(h323CallMax != _r.h323CallMax)
            {
                return false;
            }
            if(sipCallMax != _r.sipCallMax)
            {
                return false;
            }
            if(rtspCallMax != _r.rtspCallMax)
            {
                return false;
            }
            if(sipEnable != _r.sipEnable)
            {
                if(sipEnable == null || _r.sipEnable == null || !sipEnable.equals(_r.sipEnable))
                {
                    return false;
                }
            }
            if(feccEnable != _r.feccEnable)
            {
                if(feccEnable == null || _r.feccEnable == null || !feccEnable.equals(_r.feccEnable))
                {
                    return false;
                }
            }
            if(subtitleEnable != _r.subtitleEnable)
            {
                if(subtitleEnable == null || _r.subtitleEnable == null || !subtitleEnable.equals(_r.subtitleEnable))
                {
                    return false;
                }
            }
            if(videoExtEnable != _r.videoExtEnable)
            {
                if(videoExtEnable == null || _r.videoExtEnable == null || !videoExtEnable.equals(_r.videoExtEnable))
                {
                    return false;
                }
            }
            if(videoCodecEnable != _r.videoCodecEnable)
            {
                if(videoCodecEnable == null || _r.videoCodecEnable == null || !videoCodecEnable.equals(_r.videoCodecEnable))
                {
                    return false;
                }
            }
            if(videoSizeMaxVSM != _r.videoSizeMaxVSM)
            {
                if(videoSizeMaxVSM == null || _r.videoSizeMaxVSM == null || !videoSizeMaxVSM.equals(_r.videoSizeMaxVSM))
                {
                    return false;
                }
            }
            if(audiosupportFormat != _r.audiosupportFormat)
            {
                if(audiosupportFormat == null || _r.audiosupportFormat == null || !audiosupportFormat.equals(_r.audiosupportFormat))
                {
                    return false;
                }
            }
            if(audioCodecEnable != _r.audioCodecEnable)
            {
                if(audioCodecEnable == null || _r.audioCodecEnable == null || !audioCodecEnable.equals(_r.audioCodecEnable))
                {
                    return false;
                }
            }
            if(bandwidthMax != _r.bandwidthMax)
            {
                return false;
            }
            if(conferenceMax != _r.conferenceMax)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 0;
        if(bind != null)
        {
            __h = 5 * __h + bind.hashCode();
        }
        if(expire != null)
        {
            __h = 5 * __h + expire.hashCode();
        }
        if(companyName != null)
        {
            __h = 5 * __h + companyName.hashCode();
        }
        if(webURL != null)
        {
            __h = 5 * __h + webURL.hashCode();
        }
        if(supportEmail != null)
        {
            __h = 5 * __h + supportEmail.hashCode();
        }
        if(productName != null)
        {
            __h = 5 * __h + productName.hashCode();
        }
        if(serialNumber != null)
        {
            __h = 5 * __h + serialNumber.hashCode();
        }
        __h = 5 * __h + callMax;
        __h = 5 * __h + h323CallMax;
        __h = 5 * __h + sipCallMax;
        __h = 5 * __h + rtspCallMax;
        if(sipEnable != null)
        {
            __h = 5 * __h + sipEnable.hashCode();
        }
        if(feccEnable != null)
        {
            __h = 5 * __h + feccEnable.hashCode();
        }
        if(subtitleEnable != null)
        {
            __h = 5 * __h + subtitleEnable.hashCode();
        }
        if(videoExtEnable != null)
        {
            __h = 5 * __h + videoExtEnable.hashCode();
        }
        if(videoCodecEnable != null)
        {
            __h = 5 * __h + videoCodecEnable.hashCode();
        }
        if(videoSizeMaxVSM != null)
        {
            __h = 5 * __h + videoSizeMaxVSM.hashCode();
        }
        if(audiosupportFormat != null)
        {
            __h = 5 * __h + audiosupportFormat.hashCode();
        }
        if(audioCodecEnable != null)
        {
            __h = 5 * __h + audioCodecEnable.hashCode();
        }
        __h = 5 * __h + bandwidthMax;
        __h = 5 * __h + conferenceMax;
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(bind);
        __os.writeString(expire);
        __os.writeString(companyName);
        __os.writeString(webURL);
        __os.writeString(supportEmail);
        __os.writeString(productName);
        __os.writeString(serialNumber);
        __os.writeInt(callMax);
        __os.writeInt(h323CallMax);
        __os.writeInt(sipCallMax);
        __os.writeInt(rtspCallMax);
        __os.writeString(sipEnable);
        __os.writeString(feccEnable);
        __os.writeString(subtitleEnable);
        __os.writeString(videoExtEnable);
        __os.writeString(videoCodecEnable);
        __os.writeString(videoSizeMaxVSM);
        __os.writeString(audiosupportFormat);
        __os.writeString(audioCodecEnable);
        __os.writeInt(bandwidthMax);
        __os.writeInt(conferenceMax);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        bind = __is.readString();
        expire = __is.readString();
        companyName = __is.readString();
        webURL = __is.readString();
        supportEmail = __is.readString();
        productName = __is.readString();
        serialNumber = __is.readString();
        callMax = __is.readInt();
        h323CallMax = __is.readInt();
        sipCallMax = __is.readInt();
        rtspCallMax = __is.readInt();
        sipEnable = __is.readString();
        feccEnable = __is.readString();
        subtitleEnable = __is.readString();
        videoExtEnable = __is.readString();
        videoCodecEnable = __is.readString();
        videoSizeMaxVSM = __is.readString();
        audiosupportFormat = __is.readString();
        audioCodecEnable = __is.readString();
        bandwidthMax = __is.readInt();
        conferenceMax = __is.readInt();
    }
}