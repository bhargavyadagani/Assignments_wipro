package com.curd.service;

import java.sql.SQLException;
import java.util.List;

import com.curd.dao.DeptImplDao;
import com.curd.model.department;
public class DeptImplService implements Deptinterface
{
	DeptImplDao dep=new DeptImplDao();

	@Override
	public void addDepartment(department dept) {
		// TODO Auto-generated method stub
		dep.addDepartment(dept);
		System.out.println("added Succesfully");
	}

	@Override
	public department getDepartmentbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return dep.getDepartmentbyId(id);
	}

	@Override
	public List<department> getAllDepartments() {
		// TODO Auto-generated method stub
		return dep.getAllDepartments();
	}

	@Override
	public void updateDepartment(department dept) {
		// TODO Auto-generated method stub
		dep.updateDepartment(dept);
		System.out.println("updated Sucessfully");
		
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		dep.deleteDepartment(id);
		System.out.println("Deleted Sucessfully");

		
	}
	
}
