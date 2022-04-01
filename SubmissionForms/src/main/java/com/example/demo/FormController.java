package com.example.demo;

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
public class FormController {
///Request for specific URL @RequestMapping("/")
	//for specific page use get mapping
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String NewFile() {
		return "NewFile";
	}
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "NewFile";
	}
	@RequestMapping("/getdetails")
	public String getdetails(Customers customers) {
		
		return "ViewCustomerDetails";
	}

@PostMapping("/getdetails")
public ModelAndView getdetails(@RequestParam("cid") int cid) {
	//retrieving from database
	
	ModelAndView mv = new ModelAndView("Retrive");
	Customers customers = repo.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
	//modelMap.put("cid", cid);
	//modelMap.put("cname", cname);
	//modelMap.put("cemail", cemail);
	//return "ViewCustomerDetails";
	
}
@RequestMapping("/customers")
@ResponseBody
public List<Customers> getCustomers(){
	return repo.findAll();
	
}
@RequestMapping("/customers/{cid}")
@ResponseBody
//to tell we need to take from parameter passed in url
public Optional<Customers> getCustomers2(@PathVariable("cid") int cid){
	return repo.findById(cid);
	
}
@DeleteMapping("/customers/{cid}")
@ResponseBody
public Customers getCustomers4(@PathVariable("cid") int cid){
Customers cust = repo.getOne(cid);
repo.delete(cust);
return cust;
	
}

@PutMapping(path="/customers", consumes = {"application/json"})
@ResponseBody
public Customers getCustomers5(@RequestBody Customers customers){
repo.save(customers);
return customers;
	
}

}
