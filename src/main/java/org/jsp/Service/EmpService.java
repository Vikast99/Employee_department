package org.jsp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.EmpDeptExceptionHandler.IdNotFoundException;
import org.jsp.EmpDeptExceptionHandler.InvalidCredentialsException;
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
public class EmpService {
	
	@Autowired
	private EmpDao dao;
	
	@Autowired
	private DeptDao deptDao;
	
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmp(Employee emp,int dept_id){
		Optional<Department> recDept=deptDao.findById(dept_id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		if(recDept.isPresent()) {
			Department d=recDept.get();
			d.getEmployees().add(emp);
			deptDao.updateDept(recDept.get());
			dao.saveEmployee(emp);
			structure.setData(emp);
			structure.setMessage("employee saved");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
			
			
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmp(Employee emp,int dept_id){
		Optional<Department> recDept=deptDao.findById(dept_id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		if(recDept.isPresent()) {
			deptDao.updateDept(recDept.get());
			dao.updateEmployee(emp);
			structure.setData(emp);
			structure.setMessage("employee updated");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
		}
		throw new InvalidCredentialsException();
		
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findById(int id){
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> recEmp=dao.findById(id);
		if(recEmp.isPresent()) {
			structure.setData(recEmp.get());
			structure.setMessage("employee found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
		
	}
	

	public ResponseEntity<ResponseStructure<String>> deleteEmp(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<Employee> recEmp=dao.findById(id);
		if(recEmp.isPresent()) {
			structure.setData("employee found");
			structure.setMessage("employee deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			dao.deleteEmp(id);
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByDeptId(int dept_id){
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		structure.setData(dao.findEmployeeByDeptId(dept_id));	
		structure.setMessage("employee fetched through depatment");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
	
	}


}
