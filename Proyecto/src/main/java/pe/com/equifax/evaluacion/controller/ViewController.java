package pe.com.equifax.evaluacion.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.equifax.evaluacion.bean.DataTableBean;
import pe.com.equifax.evaluacion.bean.UserBean;
import pe.com.equifax.evaluacion.service.IUserService;

@Controller
public class ViewController {

	@Autowired
	private IUserService service;

	private String mensaje = "Not Found";

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("fecha", fecha());
		return "welcome";
	}

	@GetMapping("/start")
	public String welcome(Model model, @RequestParam String name) {
		if (name.equals("")) {
			model.addAttribute("name", mensaje);
		} else {
			mensaje = name;
			model.addAttribute("name", mensaje);
		}
		model.addAttribute("users", listarusuarios());
		return "evaluation";
	}

	@PostMapping("/buscar")
	public String buscar(Model model, @RequestParam String name, @RequestParam String email) {
		if (name.equals("") && email.equalsIgnoreCase("")) {
			model.addAttribute("users", listarusuarios());
		} else {
			model.addAttribute("users", listarusuariosName(name, email));
		}
		model.addAttribute("name", mensaje);
		return "evaluation";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		return "include/modal";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid UserBean user) {
		service.save(user);
		model.addAttribute("users", listarusuarios());
		model.addAttribute("name", mensaje);
		return "evaluation";
	}

	public String fecha() {
		String fecha = new SimpleDateFormat("DD/MM/YYYY").format(new Date());
		return fecha;
	}

	public List<UserBean> listarusuarios() {
		List<DataTableBean> lista = service.listar();
		List<UserBean> users = new ArrayList<UserBean>();
		for (DataTableBean dataTableBean : lista) {
			users = (List<UserBean>) dataTableBean.getData();
		}
		return users;
	}

	public List<UserBean> listarusuariosName(String name, String email) {
		List<DataTableBean> lista = service.listarNameEmail(name, email);
		List<UserBean> users = new ArrayList<UserBean>();
		for (DataTableBean dataTableBean : lista) {
			users = (List<UserBean>) dataTableBean.getData();
		}
		return users;
	}
}
