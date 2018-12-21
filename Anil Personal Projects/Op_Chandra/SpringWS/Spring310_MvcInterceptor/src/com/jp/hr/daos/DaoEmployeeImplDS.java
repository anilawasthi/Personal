package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

@Repository("daoDS")
public class DaoEmployeeImplDS implements DaoEmployee {
	@Autowired // By Type autowiring.
	@Qualifier("ds")
	private DataSource dataSource;
	
	@Override
	public ArrayList<Employee> getEmpList() throws HrException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery("SELECT empno,ename,sal FROM EMP");
			
			while(rs.next()){
				int empId = rs.getInt("empno");
				String firstNm = rs.getString("ename");
				String salary = rs.getString("sal");
				empList.add(new Employee(empId, firstNm, salary));
			}
			
		} catch (SQLException e) {
			throw new HrException("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empNo) throws HrException {
		String qry = "SELECT empno,ename,sal FROM EMP WHERE empno = ?";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, empNo);
			
			rs = stmt.executeQuery();
			if(rs.next()){
				String firstNm = rs.getString("ename");
				String salary = rs.getString("sal");
				return new Employee(empNo, firstNm, salary);
			} else {
				// Id is wrong.
				return null;
			}
			
		} catch (SQLException e) {
			throw new HrException("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		String qry = "INSERT INTO  EMP (empno,ename,sal) VALUES (?, ?, ?)";
		Connection connect = null;
		PreparedStatement stmt = null;
		
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getLastName());
			
			int recInserted = stmt.executeUpdate();
			return recInserted==1? true : false;
			
		} catch (SQLException e) {
			throw new HrException("Problem in fetching.", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
	}
}
