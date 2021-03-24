package app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Bean(name = "rmsDB")
	@ConfigurationProperties(prefix = "spring.ds-rms")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcTemplate_rms")
	public JdbcTemplate jdbcTemplate(@Qualifier("rmsDB") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}

	@Bean(name = "emsDB")
	@ConfigurationProperties(prefix = "spring.ds-ems")
	public DataSource postgresDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcTemplate_ems")
	public JdbcTemplate postgresJdbcTemplate(@Qualifier("emsDB") DataSource dsPostgres) {
		return new JdbcTemplate(dsPostgres);
	}

}
