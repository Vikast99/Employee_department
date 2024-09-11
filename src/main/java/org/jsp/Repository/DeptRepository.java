package org.jsp.Repository;

import java.util.List;

import org.jsp.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeptRepository extends JpaRepository<Department, Integer> {

	@Query("select d from Department d where d.employees.id=?1")
	Department updateSal(double sal);


	
	
	

}
