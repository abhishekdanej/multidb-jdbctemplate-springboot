package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Person;

@Transactional
@Repository
public class PersonDaoImpl {

	@Autowired
	@Qualifier("jdbcTemplate_ems")
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> getAllPerson() {
		
		String tenantId = "113747855";
		
		String sql = "select p.\"UPN\", p.\"EMAIL\", p.\"FIRSTNAME\", p.\"LASTNAME\", p.\"NAME\", pg.\"NAME\" as \"Group\""
				+ " FROM " 
				+ " view_" + tenantId + ".person as p," + " view_" + tenantId + ".persongroup as pg,"
				+ " view_" + tenantId + ".r_persontogroup as rel" 
				+ " where p.\"EMAIL\" like '%innovationai.in' and"
				+ " rel.personid = p.\"ID\" and" + " rel.persongroupid = pg.\"ID\" " + " LIMIT 5";
		
		List<Person> userList = jdbcTemplate.query(sql, new PersonRowMapper());
		
		return userList;
	}
	
}

class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Person p = new Person();
		p.setUpn(rs.getString("UPN"));
		p.setEmail(rs.getString("EMAIL"));
		return p;
	}

}