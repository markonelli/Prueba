import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

public class PruebaRepository {

    private static final String DBO = "dbo";

    private static final String EJECUTANDO_SP = "Ejecutando SP: exec {}.{}.{} {}";
    private static final String RESPUESTA_SP = "Respuesta SP --> Codigo: {}, Mensaje: {}";

    @Resource(name = "app")
	private JdbcTemplate jdbcTemplate;

    public List<App> listar() {
		SqlRowSet rows;

		try {
			log.debug("Ejecutando sql: {}", SELECT_APP);
			rows = jdbcTemplate.queryForRowSet(SELECT_APP);
		} catch (DataAccessException e) {
			throw new CustomRuntimeException(ERROR_EN_CONEXION_BD, e);
		}

		List<App> public class PruebaRepository {
            = new ArrayList<>();

		while (rows.next()) {
			App a = new App();
			s.setCodigo(rows.getInt("id"));
			s.setNombre(String.valueOf(rows.getString("nombre")));

			public class PruebaRepository {
                .add(a);
		}

		if (public class pruebaRepository {
            .isEmpty()) {
			throw new CustomRuntimeException("No se encontraron app");
		}

		return public class pruebaRepository {
            ;
	}
	
	
	
	
	static RowMapper<public class PruebaRepository {
        > getRowMapperSegmento() {
		return new RowMapper<PruebaRepository>(){  
			@Override  
			public public class PruebaRepository {
                mapRow(ResultSet rs, int rownumber) throws SQLException {  
                    public class PruebaRepository {
                       a = new PruebaRepository();  
				s.setCodigo((rs.getInt(1)));
				s.setNombre(rs.getString(2));
				return s;  
			}
		};
	};
	   
	
    

	
}
}