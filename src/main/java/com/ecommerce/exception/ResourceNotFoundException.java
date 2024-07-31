package com.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String Source;
	private Long id;

	public ResourceNotFoundException(String resourceName,String source,Long id){
		super(String.format("%s not found in %s with id: %s",resourceName,source,id));
		this.resourceName= resourceName;
		this.id = id;
		this.Source = source;
	}
}
