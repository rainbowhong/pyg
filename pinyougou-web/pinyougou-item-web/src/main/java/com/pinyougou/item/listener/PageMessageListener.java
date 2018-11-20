package com.pinyougou.item.listener;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.service.GoodsService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/** 消息监听器(生成静态html页面) */
public class PageMessageListener implements SessionAwareMessageListener<TextMessage>{


    @Value("${page.dir}")
    private String pageDir;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Reference(timeout = 10000)
    private GoodsService goodsService;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        try {
            System.out.println("=====PageMessageListener======");
            String goodsId = textMessage.getText();
            System.out.println("goodsId:" + goodsId);
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("item.ftl");
            Map<String,Object> dataModel = goodsService.getGoods(Long.valueOf(goodsId));

            // 创建输出流
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(pageDir + goodsId + ".html"),"UTF-8");
            // 填充模版生成静态的html页面
            template.process(dataModel,writer);
            writer.close();

        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
}
