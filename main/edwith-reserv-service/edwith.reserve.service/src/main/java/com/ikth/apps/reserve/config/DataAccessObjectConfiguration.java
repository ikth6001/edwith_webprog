package com.ikth.apps.reserve.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@MapperScan("com.ikth.apps.reserve")
@PropertySource({"classpath:application.properties", "classpath:datasource.properties"})
public class DataAccessObjectConfiguration 
{
	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource)
	{
		SqlSessionFactoryBean sqlSessionFactory= new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
//		sqlSessionFactory.setMapperLocations(
//				new ClassPathResource[] { new ClassPathResource("com/ikth/apps/reserve/**/*.xml")});
		try {
			return sqlSessionFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Bean
	public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Value("${datasource.type}")
	private String dataSourceType;
	
	@Value("${jndiName}")
	private String jndiName;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.user}")
	private String user;
	
	@Value("${jdbc.pass}")
	private String password;
	
	@Bean
	public DataSource getDataSource()
	{
		if("jdbc".equals(dataSourceType)) {
			return loadJdbcDataSource();
		} else if("jndi".equals(dataSourceType)) {
			return null;
		} else {
			return loadJdbcDataSource();
		}
	}

	private DataSource loadJdbcDataSource() {
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		
		return dataSource;
	}
}
