package co.com.jcd.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import co.com.jcd.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {	
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Vista Form");
		model.addAttribute("usuario", usuario); // porque se puede dar un nullPointerException cuando se refresca la vista
		return "form";
	}
	
	/**
	//método handler que recibe las peticiones POST del front
	@PostMapping("/form")
	public String procesar(Model model, 
			@RequestParam(name="username") String username, // opcional para indicar a que parametro de la vista hace referencia
			@RequestParam String password, 
			@RequestParam String email) {
		
		Usuario usuario = new Usuario(); // pojo: no se inyecta porque no presta logica sobre los datos o no tiene configuraciones 
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		model.addAttribute("titulo", "Resultado Form");
		model.addAttribute("usuario", usuario);
		
		return "resultado"; // vista que muestra los datos enviados
	}
	**/
	// forma más adecuada usando el pojo como parametro
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {	// retorna el resultado de la validacion, siempre va despues del objeto a validar
		
		if(result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{ 
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			}); //getFieldErrors es una lista que se itera en este ejemplo con una funcion lambda
			model.addAttribute("error",errores);
			return "form";
		}
		
		model.addAttribute("titulo", "Resultado Form");
		model.addAttribute("usuario", usuario); // se recibe el ususario desde el front
		
		return "resultado"; // vista que muestra los datos enviados
	}
	
	

}
