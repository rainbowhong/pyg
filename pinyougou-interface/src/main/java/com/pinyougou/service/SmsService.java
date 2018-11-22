package com.pinyougou.service;

public interface SmsService {


    /**
     *
     * @param phone 手机号码
     * @param signName  签名
     * @param templateCode  短信模板
     * @param templateParam 模板参数
     * @return
     */

    public boolean sendSms(String phone,String signName,String templateCode,String templateParam);
}
