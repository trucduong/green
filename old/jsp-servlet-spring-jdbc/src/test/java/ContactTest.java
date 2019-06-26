import org.springframework.context.ApplicationContext;

import com.green.example.entity.Contact;

import utils.SpringUtils;

public class ContactTest {
	
	public static void main(String[] args) {
		
//		Contact contact = new Contact();
//		contact.setName("Phuong");
//		
//		Contact contact1 = new Contact();
//		contact1.setName("Phuong To");
//		
//		
//		System.out.println(contact.getName());
		
		ApplicationContext context = SpringUtils.getApplicationContext();
		Contact contact = context.getBean("contact", Contact.class);
		
		Contact contact1 = context.getBean("contact", Contact.class);
		
		System.out.println(contact.getName());
	}

}
