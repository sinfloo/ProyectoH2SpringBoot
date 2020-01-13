package pe.com.equifax.evaluacion.service;

import java.util.List;

import pe.com.equifax.evaluacion.bean.DataTableBean;
import pe.com.equifax.evaluacion.bean.UserBean;

public interface IUserService {
	public List<DataTableBean> listar();

	public List<DataTableBean> listarNameEmail(String name, String email);

	public int save(UserBean user);

	public void delete(int id);
}
