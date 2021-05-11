package spring5_mybatis_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
@ComponentScan(basePackages = {"spring5_mybatis_study.mapper"}) // mapper 위치 알려주는 것
public class ContextRoot {

}
