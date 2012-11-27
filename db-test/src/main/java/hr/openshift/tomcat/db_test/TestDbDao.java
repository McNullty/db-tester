package hr.openshift.tomcat.db_test;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDbDao implements InitializingBean {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on ContactDao");
		}
	}

	public String test() {
		String sql = "select 'Test str' as test";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
}
