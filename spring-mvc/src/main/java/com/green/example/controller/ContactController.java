package com.green.example.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.example.entity.Contact;
import com.green.example.model.ContactModel;
import com.green.example.service.ContactService;

import utils.Constants;

//localhost:8080/spring-mvc/contact

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	//localhost:8080/spring-mvc/contact
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		
		List<Contact> contacts = contactService.search(null);
		model.addAttribute("contacts", contacts);
		
		return "contact-list"; // WEB-INF/view/contact-list.jsp
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView list() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("contact-list");
//		
//		List<Contact> contacts = contactService.search(null);
//		model.addObject("contacts", contacts);
//		
//		return model; // WEB-INF/view/contact-list.jsp
//	}
	
	// localhost:8080/spring-mvc/contact/create
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		
		ContactModel contact = new ContactModel();
		model.addAttribute("contact", contact);
		
		return "contact-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute("contact") ContactModel contactModel, 
			BindingResult result, Model model) {
		
		// validate inputed contact info and convert to entity
		if (result.hasErrors()) {
			return "contact-detail";
		}
		
		// save contact info
		Contact c = contactModel.toContact();
		String fileName = saveContactAvatar(contactModel.getAvatarFile(), contactModel.getAvatar());
		c.setAvatar(fileName);
		
		contactService.createContact(c);
		
		// back to contact list page
		return "redirect:/contact";
	}
	
	// http://localhost:8080/spring-mvc/contact/update?contactId=1
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(name="contactId") Long contactId, Model model) {
		
		Contact c = contactService.findContact(contactId);
		if (c == null) {
			return "redirect:/contact";
		}
		
		ContactModel contactModel = new ContactModel();
		contactModel.fromContact(c);
		
		model.addAttribute("contact", contactModel);
		
		return "contact-detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String handleUpdate(@RequestParam(name="contactId") Long contactId,
			@ModelAttribute("contact") ContactModel contact, 
			BindingResult result, Model model) {
		
		// validate inputed contact info and convert to entity
		if (result.hasErrors()) {
			return "contact-detail";
		}
		
		// save contact info
		//.....
		
		// back to contact list page
		return "redirect:/contact";
	}
	
	/*
     * Download avatar
     */
    @RequestMapping(value="/avatar/{contactId}", method = RequestMethod.GET)
    public void downloadAvatar(HttpServletResponse response, @PathVariable("contactId") Long contactId) throws IOException {
     
    	// get Contact form DB
    	Contact contact = contactService.findContact(contactId);
    	
    	if (contact == null) {
    		return; // no contact found
    	}
    	
    	
    	String fullPath = Constants.UPLOAD_FOLDER + "/" + contact.getAvatar(); 
        File file = new File(fullPath);
         
        if(!file.exists()){
            String errorMessage = "Sorry. The file you are looking for does not exist";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
    
    private String saveContactAvatar(MultipartFile file, String defaultAvatar) {
    	if (file != null) {
			try {
				byte[] bytes = file.getBytes();
				String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
	             Path path = Paths.get(Constants.UPLOAD_FOLDER  + "/" + fileName );
	             Files.write(path, bytes);
	             
	             return fileName;
	             
			} catch (IOException e) {
				// TODO logging
				return defaultAvatar;
			}
		} else {
			return defaultAvatar;
		}
    }
}
