package com.curd.dao;

import java.sql.SQLException;
import java.util.List;

import com.curd.model.department;

public interface DaoInterface {
	public void addDepartment(department dept);
	department getDepartmentbyId(int id) throws SQLException;
	List<department> getAllDepartments();
	public void updateDepartment(department dept);
	public void deleteDepartment(int id);
}
