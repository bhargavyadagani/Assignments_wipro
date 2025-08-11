package com.curd.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curd.exception.DeptException;
import com.curd.model.department;
import com.curd.util.Database_con;

public class DeptImplDao implements DaoInterface 
{
	private Connection con=Database_con.getConnection();
	@Override
	public void addDepartment(department dept) {
		int rows=0;
		try {
			PreparedStatement pst=con.prepareStatement("insert into department values(?,?,?)");
			pst.setInt(1, dept.getDeptId());
			pst.setString(2, dept.getDeptName());
			pst.setString(3, dept.getLocation());
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DeptException(e.getMessage());
		}
		
		System.out.println(rows);		
	}

	@Override
	public department getDepartmentbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
		department dept=null;
        try {
            PreparedStatement pre = con.prepareStatement("SELECT * FROM department WHERE deptId = ?");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                dept = new department(
                        rs.getInt("deptId"),
                        rs.getString("deptName"),
                        rs.getString("location") );
            } else {
                throw new DeptException("Department with id " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new DeptException("Error retrieving department: " + e.getMessage());
        }
        return dept;
	}

	@Override
	public List<department> getAllDepartments() {
		// TODO Auto-generated method stub
		List<department> deptList = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM department");
            while (rs.next()) {
                department dept = new department(
                        rs.getInt("deptId"),
                        rs.getString("deptName"),
                        rs.getString("location")
                );
                deptList.add(dept);
            }
        } catch (SQLException e) {
            throw new DeptException("Error fetching departments: " + e.getMessage());
        }
        return deptList;
	}

	@Override
	public void updateDepartment(department dept) {
		// TODO Auto-generated method stub
		try
		{
			PreparedStatement pst=con.prepareStatement("update department set deptName=?, location=? where deptId=?");
			pst.setString(1, dept.getDeptName());
			pst.setString(2, dept.getLocation());
			pst.setInt(3, dept.getDeptId());
			int row=pst.executeUpdate();
			if(row==0)
			{
				System.out.println(dept.getDeptId()+"not found in the database");
			}
			else
			{
				System.out.println("Successfully updated");
			}
		}
		catch(Exception ex)
		{
            throw new DeptException("Error updating department: " + ex.getMessage());

		}
		
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		try
		{
			PreparedStatement pst=con.prepareStatement("delete from department where DeptId=?");
			pst.setInt(1, id);
			int row=pst.executeUpdate();
			if(row==0)
			{
				System.out.println(id+"not exist in the database");
			}
			else
			{
				System.out.println("sucessfully deleted");
			}

		}
		catch(Exception ex)
		{
			throw new DeptException("Error deleting department: " + ex.getMessage());
		}
		
	}

}
