package com.ps.dorm.emilecode;

import com.ps.dorm.Utils.AESUtil;
import com.ps.dorm.controller.EmilyCodeController;
import com.ps.dorm.domain.LoginDo;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

/**
 *JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议
 */
public class SendForgetPassword {
    public static void send( String mailCode,String number,HttpServletRequest req, HttpServletResponse resp){
        // 不要使用SimpleEmail,会出现乱码问题
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：，普通qq号只能是smtp.qq.com ；smtp.exmail.qq.com没测试成功
            email.setHostName("smtp.qq.com");
            //设置需要鉴权端口
            email.setSmtpPort(465);
            //开启 SSL 加密
            email.setSSLOnConnect(true);
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo(mailCode);
            // 发送人的邮箱
            email.setFrom("1753161465@qq.com", "pub");
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和得到的授权码
            email.setAuthentication("1753161465@qq.com", "mywfpqrppjdhdhba");
            email.setSubject("修改密码");
            String s = AESUtil.generateKey();
            req.getServletContext().setAttribute("key",s);
            System.out.println(s);
            String encryption=AESUtil.encode(s,number+"="+System.currentTimeMillis());
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg("<a href=http://192.168.56.1:8081/DormSystem/dist/pages/management/updatePassword.html?"+"token="+encryption+">点击修改密码</a>");
            // 发送
            email.send();
            System.out.println("邮件发送成功!");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("邮件发送失败!");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}