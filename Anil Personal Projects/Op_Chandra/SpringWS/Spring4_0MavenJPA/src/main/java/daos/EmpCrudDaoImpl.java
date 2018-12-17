package daos;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dto.Emp;

@Repository("empDao")
public class EmpCrudDaoImpl implements EmpCrudDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Get a list of all emps.
		@Override
		public List<Emp> getAllEmps() {
			String sql = "SELECT e FROM empRec e";
			Query qry = entityManager.createQuery(sql);
			
			List<Emp> empList = qry.getResultList();
			return empList;
		}
		
	/*
	// Get a record on given EmpId.- MapResultSet
	public Emp getEmpOnId(int empId){
		String sql = "SELECT empNo, eName, sal FROM emp WHERE empNo=?";
		Object[] params = new Object[]{empId};
		MyRowMapper mapper = new MyRowMapper(ctx);
		
		Emp emp = jdbcTemplate.queryForObject(sql, params, mapper);
		return emp;
	}
	
	// Insert a record.
	
	// Delete
	// Update
	// Batch Insert
	// Page Fetching
	// Queries with Joins
}

class MyRowMapper implements ParameterizedRowMapper<Emp> {
	private ConfigurableApplicationContext ctx;
	
	public MyRowMapper(ConfigurableApplicationContext ctx){
		this.ctx = ctx;
	}
	
	@Override
	public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
		Emp emp = ctx.getBean("emp", Emp.class);
		
		emp.setEmpNo(rs.getInt("empNo"));
		emp.setEmpNm(rs.getString("eName"));
		emp.setEmpSal(rs.getFloat("sal"));
		
		return emp;
	}*/
}
