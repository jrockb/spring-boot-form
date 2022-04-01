package co.com.jcd.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.com.jcd.springboot.form.app.validators.IdentificadorRegexp;

public class Usuario {
	
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") // validación por expresión regular
	@IdentificadorRegexp // usando la anotación creada 
	private String identificador;
	
	//@NotEmpty(message = "el nombre no puede ser vacío") // personalización de mensajes
	private String nombre;
	
	@NotEmpty
	private String apellido;	
	
	@NotBlank // valida si el campo quedó vacío
	@Size(min=3, max=8, message = "el username debe tener entre 3 y 8 caracteres") 
	private String username;
	
	@NotEmpty
	private String password;
	
	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	

}
