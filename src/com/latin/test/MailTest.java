package com.latin.test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 简单的邮件测试类
 * 
 * @author nick
 *
 */
public class MailTest {

	public static void main(String[] args) {
		mainTest();
	}

	public static void mail_test(String reviewer) {
		if (reviewer == null) {
			return;
		}
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");// 发送邮件协议
		properties.setProperty("mail.smtp.auth", "true");// 需要验证
		properties.put("mail.smtp.ssl.enable", "true");
		Session session = Session.getInstance(properties);
		session.setDebug(true);// debug模式
		// 邮件信息
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("wendy@comprame.com"));
			// 设置发送人

			message.setSubject("发送邮件测试");// 设置邮件主题
			// 发送邮件
			Transport tran = session.getTransport();
			// tran.connect("smtp.sohu.com", 25, "wuhuiyao@sohu.com",
			// "xxxx");//连接到新浪邮箱服务器
			tran.connect("smtp.exmail.qq.com", 465, "wendy@comprame.com",
					"WENDY2015!");// 连接到新浪邮箱服务器
			// tran.connect("smtp.qq.com", 25, "Michael8@qq.vip.com",
			// "xxxx");//连接到QQ邮箱服务器
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					reviewer));

			String file = "D:\\中文.jpg";
			if (file != null && !"".equals(file)) {
				Multipart multipart = new MimeMultipart();

				BodyPart contentPart = new MimeBodyPart();

				contentPart.setContent("<br>TEST<br><p><b>正在测试中文</b>",
						"text/html;charset=UTF-8");
				multipart.addBodyPart(contentPart);

				BodyPart messageBodyPart = new MimeBodyPart();
				String fileName = new File(file).getName();
				DataSource source = new FileDataSource(file);
				messageBodyPart.setDataHandler(new DataHandler(source));
				try {
					messageBodyPart.setFileName(MimeUtility
							.encodeWord(fileName));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				multipart.addBodyPart(messageBodyPart);

				BodyPart zippart = new MimeBodyPart();
				DataSource source2 = new FileDataSource("D:\\测试.rar");
				zippart.setDataHandler(new DataHandler(source2));
				try {
					zippart.setFileName(MimeUtility.encodeWord("测试.rar"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				multipart.addBodyPart(zippart);

				message.setContent(multipart);
				message.saveChanges();
			} else {
				message.setContent(
						"<b>你好啊！</b>111111<p><br><br><br><br>222222222222<p>",
						"text/html;charset=UTF-8");
			}

			tran.sendMessage(message, message.getAllRecipients());// 设置邮件接收人
			tran.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void mainTest() {
		String[] reviceiver = { "nick@comprame.com", "953374957@qq.com" };
		for (int i = 0; i < reviceiver.length; i++) {
			mail_test(reviceiver[i]);
		}
	}

}
