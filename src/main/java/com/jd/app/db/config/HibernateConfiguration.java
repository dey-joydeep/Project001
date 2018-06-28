package com.jd.app.db.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import lombok.extern.log4j.Log4j2;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Log4j2
@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	private Properties props;

	public HibernateConfiguration() {
		props = new Properties();
		try {
			props.load(this.getClass().getClassLoader()
					.getResourceAsStream("hibernate.properties"));
		} catch (IOException e) {
			log.error("Could not load hibernate properties", e);
		}
	}

	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(props.getProperty(Environment.DRIVER));
			dataSource.setJdbcUrl(props.getProperty(Environment.URL));
			dataSource.setUser(props.getProperty(Environment.USER));
			dataSource.setPassword(props.getProperty(Environment.PASS));
			dataSource.setMaxStatementsPerConnection(Integer.parseInt(props
					.getProperty(Environment.C3P0_MAX_STATEMENTS)));
			dataSource.setMinPoolSize(Integer.parseInt(props
					.getProperty(Environment.C3P0_MIN_SIZE)));
			dataSource.setMaxPoolSize(Integer.parseInt(props
					.getProperty(Environment.C3P0_MAX_SIZE)));
			dataSource.setLoginTimeout(Integer.parseInt(props
					.getProperty(Environment.C3P0_TIMEOUT)));
		} catch (PropertyVetoException | SQLException e) {
			log.error("Could not obtain hibernate one or more properties", e);
		}
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.jd.app.db.entity");
		sessionFactory.setHibernateProperties(props);

		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
