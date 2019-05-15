package com.ikth.apps.reservation.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.ikth.apps.reservation.typehandle.CustomEnumTypeHandler;
import com.ikth.apps.reservation.typehandle.CustomOffSetDateHandler;

@Configuration
@MapperScan("com.ikth.apps.reservation.dao")
@PropertySource({"classpath:application.properties", "classpath:datasource.properties"})
public class DataAccessObjectConfiguration 
{
	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource)
	{
		SqlSessionFactoryBean sqlSessionFactory= new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setTypeHandlers(new TypeHandler[] {
				new CustomEnumTypeHandler()
				, new CustomOffSetDateHandler()
		});
		
		try {
			return sqlSessionFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Bean
	public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("getSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
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
	public static PropertySourcesPlaceholderConfigurer getPropertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	@Profile("PRODUCT")
	public DataSource getDataSource()
	{
		return loadJdbcDataSource();
	}
	
	@Bean("h2DataSource")
	@Profile("DEVELOP")
	public DataSource getEmbeddedDataSource()
	{
		EmbeddedDatabaseBuilder builder= new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db= builder
								.setType(EmbeddedDatabaseType.H2)
								.setName("reservationDB;DATABASE_TO_UPPER=false;MODE=MYSQL")
								.addScript("classpath:sqls/reservation_ddl.sql")
								.addScript("classpath:sqls/reservation_dml.sql")
								.build();
		
		return db;
	}
	
	/**
	 * Spring boot에선 UI로 제공 해준다(application.properties 참고) http://localhost:8080/${context_name}/${configured_uri}
	 */
//	@Bean
//	@DependsOn(value="h2DataSource")
//	@Profile("DEVELOP")
//	public MethodInvokingBean openDatabaseManager() {
//		MethodInvokingBean manager= new MethodInvokingBean();
//		manager.setTargetClass(DatabaseManagerSwing.class);
//		manager.setTargetMethod("main");
//		manager.setArguments(new Object[] {"--url", "jdbc:h2:mem:reservationDB", "--user", "sa", "--password", ""});
//		
//		return manager;
//	}

	private DataSource loadJdbcDataSource() {
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		
		return dataSource;
	}
}
