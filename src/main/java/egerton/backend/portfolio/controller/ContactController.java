package egerton.backend.portfolio.controller;

import egerton.backend.portfolio.implementation.MailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.mail.javamail.JavaMailSender;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("contact/")
public class ContactController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	@Autowired
//	private JavaMailSender mailSender;
//	MailMessage message = new MailMessage();

//	@PostMapping(value = "/Contact", consumes = "application/json", produces = "application/json")
//	public void savePreferences(@RequestBody MailMessage mailMessage) {
//		LOGGER.info("***** saveJan_budget_1_2 ***** Contact------------------------------ " + mailMessage.toString());
//		try {
////			message.setRecipient("recipient");
////			message.setSubject("subject");
////			message.setBody("body");
//		} catch (Exception e) {
//			// Get the cause of the exception
//			Throwable cause = e.getCause();
//
//			// Print the stack trace of the exception
//			cause.printStackTrace();
//		}
//	}

	@GetMapping("/contact")
	public String sendEmail() {
		String recipient = "example@gmail.com";
		String subject = "This is a test email";
		String body = "This is the body of the email.";


//		message.setRecipient(recipient);
//		message.setSubject(subject);
//		message.setBody(body);

//		mailSender.send(message);

		return "Email sent successfully!";
	}
}
