package pe.com.equifax.evaluacion.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.equifax.evaluacion.bean.DataTableBean;
import pe.com.equifax.evaluacion.bean.UserBean;
import pe.com.equifax.evaluacion.service.IUserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	private IUserService service;
	
	@GetMapping("/listar")
	public List<DataTableBean>listar(){		
		return service.listar();
	}
	
	@PostMapping("/add")
	public UserBean add(@RequestBody UserBean user) {		
		service.save(user);
		return user;
	}
	@RequestMapping("/buscar")
	public List<DataTableBean> buscar(@PathParam(value = "name") String name,@PathParam(value = "email")String email) {		
		return service.listarNameEmail(name, email);
	}
}
