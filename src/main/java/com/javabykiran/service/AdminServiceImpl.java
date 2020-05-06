package com.javabykiran.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabykiran.dao.AdminDAO;
import com.javabykiran.model.Admin;
import com.javabykiran.model.RegisterAdmin;
import com.javabykiran.model.StateAdmin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO adminDAO;

	@Override
	@Transactional
	public List<Admin> getAdmins() {
		List<Admin> updatedAdminList = new ArrayList<>();
		List<Admin> daoAdminList = adminDAO.getAdmins();    ///get list of user table rows in form of list of admins.
		for(Admin admin:daoAdminList){		//retrieving single row/admin object from list of admins
			int sid = admin.getSid(); //fetching sid values from each admin object/row
			String state = adminDAO.getState(sid);//fetching corresponding state value for each sid
			System.out.println(state);
			admin.setState(state);// updating a admin object/row by setting state value 
			System.out.println(admin);
			updatedAdminList.add(admin); //adding a updated admin object/ row into updated list of admins, hence generating the new list of admins
	       System.out.println(updatedAdminList);
		}
		
		return updatedAdminList;//returning a updated list that would correspond to "admins" of model in getlist method of controller class
	}

	@Override
	@Transactional
	public List<RegisterAdmin> checkLogin(String email, String pass) {

		return adminDAO.checkLogin(email,pass);
	}

	@Override
	@Transactional
	public Admin saveAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub
		return adminDAO.saveAdmin(theAdmin);
	}

	@Override
	@Transactional
	public boolean delete(int theId) {

		return adminDAO.delete(theId);
	}

	@Override
	@Transactional
	public RegisterAdmin saveRegisterAdmin(RegisterAdmin theAdmin) {

		return adminDAO.saveRegisterAdmin(theAdmin);
	}

	@Override
	@Transactional
	public Admin getAdmin(int theId) {
		return adminDAO.getAdmin(theId);
	}

	@Override
	@Transactional
	public List<StateAdmin> loadState() {
		return adminDAO.loadState();
	}

}
