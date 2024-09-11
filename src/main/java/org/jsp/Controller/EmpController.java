package org.jsp.Controller;

import org.jsp.Entity.Employee;
import org.jsp.Entity.ResponseStructure;
import org.jsp.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@PostMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmp(@RequestBody Employee e,@PathVariable int dept_id){
		return service.saveEmp(e, dept_id);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmp(@RequestBody Employee e,@PathVariable int dept_id){
		return service.updateEmp(e, dept_id);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmp(@PathVariable int id){
		return service.deleteEmp(id);
	}
	
	@GetMapping("/employee/bydept-id")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByDeptId(@PathVariable int dept_id){
		return service.findEmployeeByDeptId(dept_id);
	}

}
