package com.javabykiran.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.Admin;
import com.javabykiran.model.RegisterAdmin;
import com.javabykiran.model.StateAdmin;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	  private Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }

	@Override
	public List<Admin> getAdmins() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Admin");
		
		List<Admin> admins = query.list();
		return admins;
	}

	@Override
	public List<RegisterAdmin> checkLogin(String email, String pass) {
		Session currentSession = sessionFactory.getCurrentSession();

		List<RegisterAdmin> admin = currentSession
				.createQuery("from RegisterAdmin where " + "email='" + email + "' and password='" + pass + "'").list();

		return admin;
	}

	@Override
	public Admin saveAdmin(Admin theAdmin) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(theAdmin);
		currentSession.saveOrUpdate(theAdmin);

		return theAdmin;
	}

	@Override
	public boolean delete(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Admin admin = (Admin) currentSession.get(Admin.class, theId);
		String isDefault = admin.getIsDefault();
		
		if(isDefault.equals("Y")) {
			return false;
		}else {
			currentSession.delete(admin);
			return true;
			
		}
	}

	@Override
	public RegisterAdmin saveRegisterAdmin(RegisterAdmin theAdmin) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(theAdmin);

		return theAdmin;
	}

	@Override
	public Admin getAdmin(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Admin admin = (Admin) currentSession.get(Admin.class, theId);
		System.out.println(admin);

		return admin;
	}

	@Override
	public List<StateAdmin> loadState() {
	        return getCurrentSession().createQuery("from StateAdmin").list();
	    }
	
	public String getState(int sid){
		Query query = getCurrentSession().createQuery(" select sa.state from StateAdmin sa where sa.sid="+sid);
		return query.list().get(0).toString();
	}

}
