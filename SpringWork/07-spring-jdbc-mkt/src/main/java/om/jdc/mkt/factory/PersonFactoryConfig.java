package om.jdc.mkt.factory;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class PersonFactoryConfig {
	
	@Bean
	@Qualifier("pInsert")
	public PreparedStatementCreatorFactory insertPersonCreatorFactory(@Value("${p.insert}") String sql) {
		
		return new PreparedStatementCreatorFactory(sql,Types.VARCHAR,Types.INTEGER);
	}
	
	@Bean
	@Qualifier("pUpdate")
	public PreparedStatementCreatorFactory updatePersonCreatorFactory(@Value("${p.update}") String sql) {
		
		return new PreparedStatementCreatorFactory(sql,Types.VARCHAR,Types.INTEGER,Types.INTEGER);
	}

}
