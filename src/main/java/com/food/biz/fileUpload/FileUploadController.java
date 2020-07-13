package com.food.biz.fileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.food.biz.food.FoodService;

@Controller
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;

	@Autowired
	FoodService foodService;
	
	@RequestMapping("/upload.do")
	public String upload(Model model, @RequestParam("file1") MultipartFile file) {
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		return "foodInsert.jsp";
	}
	
	@RequestMapping("/upload2.do")
	public ModelAndView upload2(ModelAndView model, @RequestParam("file1") MultipartFile file) {
		String url = fileUploadService.restore(file);
		model.addObject("data", foodService.getFoodList());
		model.addObject("page","test.jsp");
		model.addObject("url", url);
		model.setViewName("index.jsp");
		return model;
	}
}