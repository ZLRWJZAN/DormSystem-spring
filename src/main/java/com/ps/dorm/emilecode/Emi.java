package com.ps.dorm.emilecode;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.io.InputStream;


/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/14 10:10
 */
public class Emi {
    public static void main(String[] args) {
        // 属性
        Properties properties = new Properties();
        // 设置认证属性
        properties.setProperty( "mail.smtp.auth", "true" );
        // 设置通信协议
        properties.setProperty( "mail.transport.protocol", "smtp" );
        // 邮件环境信息
        Session session = Session.getInstance( properties );
        // 调试,打印信息
        session.setDebug( false );

        // 邮件
        Message message = new MimeMessage( session );

        try {
            // 主题
            message.setSubject( "验证码信息：" );
            // 发送人
            message.setFrom( new InternetAddress( "1753161465@qq.com" ) );
            // 内容
            message.setText( "验证码为："+"666666");

            // 邮件传输对象
            Transport transport = session.getTransport();
            // 传输连接：host，port，user，pass/主机，端口，用户名，密码
            transport.connect( "smtp.qq.com", 25, "1753161465@qq.com", "mywfpqrppjdhdhba" );
            // 发送邮件
            transport.sendMessage( message, new Address[]{new InternetAddress( "1876943364@qq.com" )} );
        } catch (MessagingException e) {

        }
    }
}
