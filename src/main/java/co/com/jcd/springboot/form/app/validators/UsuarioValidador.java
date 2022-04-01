package co.com.jcd.springboot.form.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.com.jcd.springboot.form.app.models.domain.Usuario;

@Component // para que se pueda inyectar al controlador
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz); // para que el objeto que se vaya a validar sea de la clase que se pasa como argumento (Usuario)
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		// usando la clase utilidades de validación de Spring
		ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.usuario.nombre");
		/**
		 * alternativa:
		 * if(usuario.getNombre().isEmpty()){
		 * 		errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
		 * }
		 */
		// validación de expresón regular
		if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			errors.rejectValue("identificador", "Pattern.usuario.identificador");
		}
		
		
		
	}

}
