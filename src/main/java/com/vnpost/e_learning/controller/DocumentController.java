package com.vnpost.e_learning.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vnpost.e_learning.bean.VNCharacterUtils;
import com.vnpost.e_learning.entities.Document;
import com.vnpost.e_learning.entities.DocumentCategory;
import com.vnpost.e_learning.service.IDocumentCategoryService;
import com.vnpost.e_learning.service.IDocumentService;

@Controller
public class DocumentController {
	@Autowired
	VNCharacterUtils vn;
	@Autowired
	HttpServletResponse response;
	  @Autowired
	  ServletContext text;
	@Autowired
	IDocumentService d;
	@Autowired
	IDocumentCategoryService dd;
	@RequestMapping("/document/search")// timkiem
		
	public String Finddocument(Model model ,@RequestParam("keyword") String s) {
		String search = vn.removeAccent(s);
		List<Document> list = d.getListFindByName(s);
		 List<DocumentCategory> documentCategories = dd.findAll();
		 model.addAttribute("listD",list);
		  model.addAttribute("listDC", documentCategories);
		 for(Document d: list) {
			 System.out.println(d.getName());
		 }
		 return "user/Home/Document";
	}
	
	
	
  @RequestMapping(value = {"/home/document"})
  public String homeDocument(Model model ) {
	  List<DocumentCategory> documentCategories = dd.findAll();
	  List<Document> documents = d.getListDocuments();
	
	  model.addAttribute("listD", documents);

	  model.addAttribute("listDC", documentCategories);
	  return "user/Home/Document";
  }
  @RequestMapping(value = {"/home/documentCategory/{id}"})
  public String homeDocumentCAtegory(Model model ,@PathVariable("id") Long id) {
	  List<DocumentCategory> documentCategories = dd.findAll();

	  List<Document> documentss = d.getListDocumentsFromCategory(id);
	
	  model.addAttribute("listD", documentss);
	  model.addAttribute("listDC", documentCategories);
	  return "user/Home/DocymentCategory";
  }
  @GetMapping("/dowload/file/{id}")
  public void dowloadFile( @PathVariable("id") Long  id) throws IOException{
	  Document document = d.findById(id);
	  if(document!=null) {
		  try {
			
			  String nameFile = text.getRealPath("/static/file/"+document.getLinkFile());
				File file = new File(nameFile);
				  String mimeType= URLConnection.guessContentTypeFromName(file.getName());
			        if(mimeType==null){
			            System.out.println("mimetype is not detectable, will take default");
			            mimeType = "application/octet-stream";
			        }
		      byte[] data = FileUtils.readFileToByteArray(file);
		      // Thiết lập thông tin trả về
		      response.setContentType(mimeType);
		      response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
		      response.setContentLength(data.length);
		      InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
		     
		      FileCopyUtils.copy(inputStream, response.getOutputStream());
		      
				
		    } catch (Exception ex) {
		     System.out.println("");
		    }

	  }
	 
	 }
}
