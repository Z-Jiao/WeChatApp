package com.wechatapp.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

public class codeUtil {
    /**
     * 生成验证码图片
     *
     * @param request            设置session
     * @param response           转成图片
     * @param captchaProducer    生成图片方法类
     * @param validateSessionKey session名称
     * @throws Exception
     */
    public static void validateCode(HttpServletRequest request, HttpServletResponse response, DefaultKaptcha captchaProducer, String validateSessionKey) throws Exception {
        // 将在很久以前过期。
        response.setDateHeader("Expires", 0);
        // 设置标准的HTTP/1.1无缓存报头。
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        //设置IE扩展的HTTP/1.1无缓存标头(使用addHeader)。
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // 设置标准的HTTP/1.0无缓存报头
        response.setHeader("Pragma", "no-cache");

        // 返回一个jpeg
        response.setContentType("image/jpeg");

        // 为图像创建文本
        String capText = captchaProducer.createText();

        // 将文本存储在会话中
        request.getSession().setAttribute(validateSessionKey, capText);

        //创建一个对象，在内存中图片（验证码图片对象）
        BufferedImage bi = captchaProducer.createImage(capText);
        //生成一个输出流
        ServletOutputStream out = response.getOutputStream();
        // 将图片输出到页面展示
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
