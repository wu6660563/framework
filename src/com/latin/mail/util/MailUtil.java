package com.latin.mail.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.latin.mail.mapper.MailMapper;

/**
 * 后续考虑加上邮件日志表
 * @author nick
 * @since 2015/09/25
 */
@Component("mailUtil")
public class MailUtil {

	private int port = 0;
	private String timeOut = "";
	private String password = "";
	private String userName = "";
	private String hostName = "";
	private String protocol = "smtp";

	@Autowired
	private MailMapper mailMapper;

	public MailMapper getMailMapper() {
		return mailMapper;
	}

	public void setMailMapper(MailMapper mailMapper) {
		this.mailMapper = mailMapper;
	}

	public void send(String reviceiver, String content, String subject) {
		send(reviceiver, content, subject, null);
	}

	/**
	 * 
	 * @param reviceiver
	 *            接收人
	 * @param copyUser
	 *            抄送人
	 * @param content
	 *            邮件内容
	 * @param subject
	 *            邮件标题
	 * @param files
	 *            附件
	 * @throws UnsupportedEncodingException
	 */
	public void send(String reviceiver, String content, String subject,
			String[] files) {
		// 初始化，获取数据库中邮件配置
		init();

		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", this.protocol);// 发送邮件协议
		properties.setProperty("mail.smtp.auth", "true");// 需要验证
		properties.put("mail.smtp.ssl.enable", "true");

		Session session = Session.getInstance(properties);
		session.setDebug(true);// debug模式
		// 邮件信息
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(this.userName));
			message.setSubject(subject);
			// 发送邮件
			Transport tran = session.getTransport();
			tran.connect(this.hostName, this.port, this.userName, this.password);

			if (reviceiver == null) {
				return;
			}
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					reviceiver));

			if (files != null && files.length > 0) {
				Multipart multipart = new MimeMultipart();

				BodyPart contentPart = new MimeBodyPart();

				contentPart.setContent(content, "text/html;charset=UTF-8");
				multipart.addBodyPart(contentPart);

				for (String string : files) {
					BodyPart filepart = new MimeBodyPart();
					String fileName = new File(string).getName();
					DataSource source = new FileDataSource(string);
					filepart.setDataHandler(new DataHandler(source));
					filepart.setFileName(MimeUtility.encodeWord(fileName));
					multipart.addBodyPart(filepart);
				}

				message.setContent(multipart);
				message.saveChanges();
			} else {
				message.setContent(content, "text/html;charset=UTF-8");
			}

			tran.sendMessage(message, message.getAllRecipients()); // 设置邮件接收人
			tran.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化
	 */
	private void init() {
		List<HashMap<String, String>> list = mailMapper.getMailProperties();
		for (HashMap<String, String> hashMap : list) {

			if ("config_mail_smtp_port".equals(hashMap.get("key"))) {
				this.port = Integer.parseInt(hashMap.get("value").trim());
			} else if ("config_mail_smtp_timeout".equals(hashMap.get("key"))) {
				this.timeOut = hashMap.get("value").trim();
			} else if ("config_mail_smtp_password".equals(hashMap.get("key"))) {
				this.password = hashMap.get("value").trim();
			} else if ("config_mail_smtp_username".equals(hashMap.get("key"))) {
				this.userName = hashMap.get("value").trim();
			} else if ("config_mail_smtp_hostname".equals(hashMap.get("key"))) {
				this.hostName = hashMap.get("value").trim();
			} else if ("config_mail_protocol".equals(hashMap.get("key"))) {
				this.protocol = hashMap.get("value").trim();
			}
		}
	}

}
