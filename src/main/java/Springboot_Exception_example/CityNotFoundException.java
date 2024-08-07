package Springboot_Exception_example;

public class CityNotFoundException extends RuntimeException
{
	String message;

	public CityNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
