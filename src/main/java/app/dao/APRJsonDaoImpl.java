package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import app.model.APRJson;

@Repository
public class APRJsonDaoImpl {

	@Autowired
	@Qualifier("jdbcTemplate_rms")
	private JdbcTemplate jdbcTemplate;
	
	public List<APRJson> getAllJson() {
		
		String tenantId = "113747855";
		
		String sql = "SELECT aprjson.id,aprjson.body FROM maas_admin.\"AuthorizationPrincipalResourceJSON_" + tenantId
				+ "\" as aprjson LIMIT 5";
		
		List<APRJson> jsonList = jdbcTemplate.query(sql, new JsonRowMapper());
		
		return jsonList;
	}
}

class JsonRowMapper implements RowMapper<APRJson> {

	@Override
	public APRJson mapRow(ResultSet rs, int rowNum) throws SQLException {
		APRJson json = new APRJson();
		json.setBody(rs.getString("body"));
		return json;
	}
	
}
