package org.jsp.Controller;

import java.util.List;

import org.jsp.Entity.Department;
import org.jsp.Entity.ResponseStructure;
import org.jsp.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@PostMapping("/department")
	public ResponseEntity<ResponseStructure<Department>> saveDept(@RequestBody Department d){
		return service.saveDept(d);
	}
	
	@PutMapping("/department")
	public ResponseEntity<ResponseStructure<Department>> updateDept(@RequestBody Department d){
		return service.updateDept(d);
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<ResponseStructure<Department>> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDept(@PathVariable int id){
		return service.deleteDept(id);
	}
	
	@GetMapping("/department")
	public ResponseEntity<ResponseStructure<List<Department>>> findAll(){
		return service.findAll();
	}
	
	@PutMapping("/department")
	public ResponseEntity<ResponseStructure<Department>> updateSal(@RequestParam double sal,@PathVariable int id){
		return service.updateSal(sal, id);
	}
	
	
	


}
