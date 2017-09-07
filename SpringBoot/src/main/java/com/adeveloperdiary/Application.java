package com.adeveloperdiary;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = "com.adeveloperdiary")
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
		hmStudent = new HashMap<Long, Student>();

		Student one = new Student("John", "math");
		hmStudent.put(new Long(one.getId()), one);

		SpringApplication.run(Application.class, args);

		Student two = new Student("Jane", "history");
		hmStudent.put(new Long(two.getId()), two);
	}
}

@RestController
@RequestMapping(value="/rest/student")
class StudentService{

   @RequestMapping(value="/",method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return Application.hmStudent;
   }
}
