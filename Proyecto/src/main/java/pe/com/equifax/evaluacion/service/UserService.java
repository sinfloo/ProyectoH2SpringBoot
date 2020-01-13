package pe.com.equifax.evaluacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.equifax.evaluacion.bean.DataTableBean;
import pe.com.equifax.evaluacion.bean.UserBean;
import pe.com.equifax.evaluacion.dao.IUser;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUser dao;
	
	@Override
	public List<DataTableBean> listar() {		
		return dao.listar();
	}

	@Override
	public List<DataTableBean> listarNameEmail(String name, String email) {		
		return dao.listarNameEmail(name, email);
	}

	@Override
	public int save(UserBean user) {
		dao.save(user);
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
