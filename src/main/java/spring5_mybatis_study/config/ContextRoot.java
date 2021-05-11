package spring5_mybatis_study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
public class ContextRoot {

}
