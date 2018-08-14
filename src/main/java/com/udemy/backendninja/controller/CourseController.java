package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	
	@Autowired
	@Qualifier("CourseServiceImpl")
	private CourseService courseService;
	
	@GetMapping(value= "/listCourses")
	public ModelAndView listCourses(){
		ModelAndView model = new ModelAndView(COURSES_VIEW);
		model.addObject("courses", courseService.listAllCourses());
		return model;
	}
	
	@PostMapping(value = "/addCourse")
	public String postMethodName(@ModelAttribute("course") Course course) {
		courseService.addCourse(course);
		
		//Finally we will show the new course added in the listCourses view.
		return "redirect:/listCourses";
	}

}
