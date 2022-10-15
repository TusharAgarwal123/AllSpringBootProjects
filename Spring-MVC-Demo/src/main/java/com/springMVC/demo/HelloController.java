
package com.springMVC.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")    //parent mapping
public class HelloController {

	@RequestMapping("/hello-world")
	public String sayHello() {
		return "hello";
	}

	@RequestMapping("/showForm")
	public String showForm() {
		return "hello-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}

	// in this method we will retrieve the name enter on the form and convert it in
	// Capital form.
	@RequestMapping("/processFormVersionTwo")
	public String letsShutDude(HttpServletRequest request, Model model) {

		String nn = request.getParameter("stdName");
		nn = nn.toUpperCase();
		String rs = "YO " + nn;
		model.addAttribute("message", rs);

		return "process-form";
	}

	@RequestMapping("/processFormVersionThree")
	public String letsShutDude2(@RequestParam("stdName") String nn, Model model) {

		nn = nn.toUpperCase();
		String rs = "Superb " + nn;
		model.addAttribute("message", rs);

		return "process-form";
	}

}
