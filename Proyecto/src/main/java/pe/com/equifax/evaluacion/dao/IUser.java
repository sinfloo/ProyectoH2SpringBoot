package pe.com.equifax.evaluacion.dao;

import java.util.List;

import pe.com.equifax.evaluacion.bean.DataTableBean;
import pe.com.equifax.evaluacion.bean.UserBean;

public interface IUser {
	public List<DataTableBean>listar();	
	public List<DataTableBean> listarNameEmail(String name, String email);
	public int save(UserBean user);
	public void delete(int id);
}
