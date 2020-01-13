package pe.com.equifax.evaluacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.equifax.evaluacion.bean.DataTableBean;
import pe.com.equifax.evaluacion.bean.UserBean;

@Repository
public class UserDAO implements IUser {

	DataTableBean bean = new DataTableBean();;
	List<DataTableBean> lista = new ArrayList<DataTableBean>();

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<DataTableBean> listar() {
		lista = new ArrayList<DataTableBean>();
		String sql = "select * from user";
		List<UserBean> users = this.template.query(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class));
		bean.setData(users);
		lista.add(bean);
		return lista;
	}

	@Override
	public List<DataTableBean> listarNameEmail(String name, String email) {
		lista = new ArrayList<DataTableBean>();
		String sql = "";
		if (name.equals("")) {
			sql = "select * from user where email='" + email + "'";
		} else if (email.equals("")) {
			sql = "select * from user where name='" + name +"'";
		} else {
			sql = "select * from user where name='" + name + "'and email='" + email + "'";
		}
		List<UserBean> users = this.template.query(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class));
		bean.setData(users);
		lista.add(bean);
		return lista;
	}

	@Override
	public int save(UserBean user) {
		String sql = "INSERT INTO user(name,age,email,phone,year)values(?,?,?,?,?)";
		int res = template.update(sql, user.getName(), user.getAge(), user.getEmail(), user.getPhone(), user.getYear());
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
