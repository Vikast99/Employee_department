package org.jsp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.EmpDeptExceptionHandler.IdNotFoundException;
import org.jsp.Entity.Department;
import org.jsp.Entity.Employee;
import org.jsp.Entity.ResponseStructure;
import org.jsp.dao.DeptDao;
import org.jsp.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeptService<Threadpool> {
	
	@Autowired
	private DeptDao dao;
	
	@Autowired
	private EmpDao empDao;
	
	
	
	
	public ResponseEntity<ResponseStructure<Department>> saveDept(Department d){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		structure.setData(dao.saveDept(d));
		structure.setMessage("dept saved with id:"+d.getId());
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Department>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Department>> updateDept(Department d){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		structure.setData(dao.updateDept(d));
		structure.setMessage("dept updated");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Department>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Department>> findById(int id){
		Optional<Department> recDept=dao.findById(id);
		ResponseStructure<Department> structure=new ResponseStructure<>();
		if(recDept.isPresent()) {
			structure.setData(recDept.get());
			structure.setMessage("departement fetched");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Department>>> findAll(){
		
		ResponseStructure<List<Department>> structure=new ResponseStructure<>();
		structure.setData(dao.findAll());
		structure.setMessage("list of departments");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Department>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteDept(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<Department> recDept=dao.findById(id);
		if(recDept.isPresent()) {
			structure.setData("department found");
			structure.setMessage("dept deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			dao.deleteDept(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData("dept not found");
		structure.setMessage("dept not deleted");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Department>> updateSal(double sal,int id){
		ResponseStructure<Department> structure=new ResponseStructure<>();
		Optional<Employee> recEmp=empDao.findById(id);
		if(recEmp.isPresent()) {
			structure.setData(dao.updateSal(sal));
			structure.setMessage("sal updated");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
//	
//	public ResponseEntity<ResponseStructure<Department>> updateSalary(double sal,int id){
//		ResponseStructure<Department> structure=new ResponseStructure<>();
//		Optional<Employee> recEmp=empDao.findById(id);
//		if(recEmp.isPresent()) {
//			structure.setData(dao.updateSal(sal));
//			
//			structure.setMessage("sal updated");
//			structure.setStatuscode(HttpStatus.OK.value());
//			Thread t1=new Thread();
//			t1.start();
//			return new ResponseEntity<ResponseStructure<Department>>(structure, HttpStatus.OK);
//		}
//		throw new IdNotFoundException();
//	}
	
	
	

	
	
	
	

}
