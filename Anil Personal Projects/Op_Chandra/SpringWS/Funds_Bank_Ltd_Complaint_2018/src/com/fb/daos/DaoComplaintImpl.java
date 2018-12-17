package com.fb.daos;

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

import com.fb.entities.Complaint;
import com.fb.exceptions.CompException;

@Repository("daoDS")
public class DaoComplaintImpl implements DaoComplaint {
	@Autowired  //By type autowiring
	@Qualifier("ds")
	private DataSource dataSource;

	
/*	@PersistenceContext
	private EntityManager entityManager;*/

	/*@Override
	public List<Complaint> getCompList() throws CompException {
		String sql = "SELECT e FROM compl e";
		Query qry = entityManager.createQuery(sql);
		
		List<Complaint> compList = qry.getResultList();
		return compList;
	}*/

	
	@Override
	public boolean insertNewRecord(Complaint comp) throws CompException {
		String qry = "INSERT INTO complaint (COMPLAINTID,ACCOUNTID,BRANCHCODE,EMAILID,CATEGORY,DESCRIPTION,PRIORITY,STATUS) VALUES (?,?,?,?,?,?,?,?)";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, comp.getComplaintId());
			stmt.setInt(2, comp.getAccountId());
			stmt.setInt(3, comp.getBranchCode());
			stmt.setString(4, comp.getEmialId());
			stmt.setString(5, comp.getCategory());
			stmt.setString(6, comp.getDescription());
			stmt.setString(7, comp.getPriority());
			stmt.setString(8, comp.getStatus());
			

			int recInserted = stmt.executeUpdate();
			return recInserted == 1 ? true : false;

		} catch (SQLException e) {
			throw new CompException("Problem in fetching.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				// factory.closeConnection();
			} catch (SQLException e) {
				throw new CompException("Problem in closing resources.", e);
			}
		}

}

	@Override
	public ArrayList<Complaint> getCompList() throws CompException {
		ArrayList<Complaint> compList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select COMPLAINTID,ACCOUNTID,BRANCHCODE,EMAILID,CATEGORY,DESCRIPTION,PRIORITY,STATUS from complaint");
			while(rs.next()) {
				int complaintId = rs.getInt("COMPLAINTID");
				int accountId = rs.getInt("ACCOUNTID");
				Integer branchCode = rs.getInt("BRANCHCODE");
				String emialId = rs.getString("EMAILID");
				String category = rs.getString("CATEGORY");
				String description = rs.getString("DESCRIPTION");
				String priority = rs.getString("PRIORITY");
				String status = rs.getString("STATUS");
				compList.add(new Complaint(complaintId,accountId, branchCode, emialId,category,description,priority,status));
			}
		} catch (SQLException e) {
			throw new CompException("Problem in fetching.", e);
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
				throw new CompException("Problem in closing resources.", e);
			}
		}
	return compList;
	}

	/*@Override
	public Complaint getCompDetails(int compId) throws CompException {
		String qry = "Select COMPLAINTID,ACCOUNTID,BRANCHCODE,EMAILID,CATEGORY,DESCRIPTION,PRIORITY,STATUS from complaint where COMPLAINTID = ?";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			stmt = connect.prepareStatement(qry);
			stmt.setInt(1, complaintId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String firstNm = rs.getString("FIRST_NAME");
				String lastNm = rs.getString("LAST_NAME");
				return new Complaint(accountId, firstNm, lastNm);
			} else {
				// Id is wrong.
				return null;
			}
		} catch (SQLException e) {
			throw new CompException("Problem in fetching.", e);
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
				throw new CompException("Problem in closing resources.", e);
			}
		}*/
		
	}
