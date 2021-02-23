package com.spring;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeesRepo repo;
	@RequestMapping("/")
	public String details()
	{
		return "employee";
		
	}
	@RequestMapping("/details")
	public String details(Employees employees)
	{
		repo.save(employees);
		return "employee";
		
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		return "ViewEmployees";
		
	}
	

	@PostMapping("/getdetails")

	public ModelAndView getdetails(@RequestParam int eid)
	{
		ModelAndView mv = new ModelAndView("Retrieve");
		Employees employees = repo.findById(eid).orElse(null);
		mv.addObject(employees);
		return mv;
	}
	
	@RequestMapping("/employees")
	@ResponseBody
	public List<Employees> getEmployees()
	{
	return repo.findAll();
	}
	
	@RequestMapping("/employees/{eid}")
	@ResponseBody
	public Optional<Employees> getEmployees2(@PathVariable("eid") int eid)
	{
	return repo.findById(eid);
	}
	@PostMapping("/employees")
	public Employees getEmployees3(@RequestBody Employees employees)
	{
		repo.save(employees);
		return employees;
	}
	@DeleteMapping("/employees/{eid}")
	public Employees getEmployees4(@PathVariable("eid")int eid)
	{
		Employees emp = repo.getOne(eid);
		repo.delete(emp);
		return emp;
	}
	
	@PutMapping(path="/employees",consumes= {"application/json"})
	public Employees getEmployees5(@RequestBody Employees employees)
	{
		repo.save(employees);
		return employees;
	}
	
		
	}
	
		
	
