package org.jsp.Entity;





import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private T data;
	private String message;
	private int statuscode;
	
	

}
