package org.jsp.EmpDeptExceptionHandler;

public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "this id is invalid";
	}

}
