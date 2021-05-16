package spring5_mybatis_study.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement // transaction p206 때문에 추가
public class ContextDataSource {  // 이거는 dbcp설정
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		HikariDataSource dataSource = null;
		try {
			Properties prop = Resources.getResourceAsProperties("application.properties");
			HikariConfig cfg = new HikariConfig(prop);
			dataSource = new HikariDataSource(cfg);
			dataSource.setMinimumIdle(10);
			dataSource.setMaximumPoolSize(100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
