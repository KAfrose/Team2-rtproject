package com.mphasis.rproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.rproject.entity.User;
import com.mphasis.rproject.model.UserService;


@RestController
//@RequestMapping("/um")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public List<User> getAllUsers()
	{
		return userService.read(); 
	}
	
	@PostMapping("/user/otp")
	public String generateOtp(@RequestBody String emailAddress)
	{
		double x=Math.random()*1000000;
		int otp=(int)x;
		sendEmail(emailAddress, "The OTP required for signing up to the application is "+otp+" Do not share the otp with anybody");
		return ""+otp;
	}
	
	@PostMapping("/user/login")
	public User validateLogin(@RequestParam("userName") String userName, @RequestParam("password") String password)
	{
		if(userName==null)
			return null;
		return userService.validateLogin(userName, password);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		return userService.create(user);
	}
	
	@PutMapping("/user")
	public User modifyUser(@RequestBody User user)
	{
		return userService.update(user);
	}
	
	@DeleteMapping("/user/{userName}")
	public void removeUser(@PathVariable("userName")String userName)
	{
		userService.delete(userName);
	}
	
	
	private void sendEmail(String to, String message)
	{
		 Properties props = new Properties();
	        props.put("mail.smtp.host", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        //Establishing a session with required user details
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("team2.javaprogram@gmail.com", "team2@123");
	            }
	        });
	        try {
	            //Creating a Message object to set the email content
	            MimeMessage msg = new MimeMessage(session);
	            //Storing the comma seperated values to email addresses
//	            String to = "harshavardhangdk@gmail.com";
	            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
	            addresses in an array of InternetAddress objects*/
	            InternetAddress[] address = InternetAddress.parse(to, true);
	            //Setting the recepients from the address variable
	            msg.setRecipients(Message.RecipientType.TO, address);
	            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
	            msg.setSubject("Otp : " + timeStamp);
	            msg.setSentDate(new Date());
	            msg.setText(message);
	            msg.setHeader("XPriority", "1");
	           
	            Transport.send(msg);
	            System.out.println("Mail has been sent successfully");
	        } catch (MessagingException mex) {
	            System.out.println("Unable to send an email:\n" + mex);
	        }
	}
}
