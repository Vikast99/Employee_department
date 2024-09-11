package org.jsp.Repository;


import java.util.List;
import java.util.Optional;

import org.jsp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select e from Employee e where e.dept.id=?1")
	Employee findEmployeeByDeptId(int dept_id);
	


}
