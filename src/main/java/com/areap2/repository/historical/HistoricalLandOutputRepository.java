package com.areap2.repository.historical;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class HistoricalLandOutputRepository {
	private final NamedParameterJdbcTemplate jdbc;

	public HistoricalLandOutputRepository(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public List<Map<String, Object>> findAll(String table) {
		return jdbc.queryForList("SELECT * FROM " + table + " ORDER BY id", new MapSqlParameterSource());
	}

	public Map<String, Object> findById(String table, long id) {
		List<Map<String, Object>> rows = jdbc.queryForList("SELECT * FROM " + table + " WHERE id=:id",
				new MapSqlParameterSource("id", id));
		return rows.isEmpty() ? null : rows.get(0);
	}

	public long insert(String table, Map<String, Object> values) {
		String columns = String.join(", ", values.keySet());
		String params = values.keySet().stream().map(k -> ":" + k).reduce((a, b) -> a + ", " + b).orElseThrow();
		KeyHolder holder = new GeneratedKeyHolder();
		jdbc.update("INSERT INTO " + table + " (" + columns + ") VALUES (" + params + ")",
				new MapSqlParameterSource(values), holder, new String[] { "id" });
		Number key = holder.getKey();
		if (key == null)
			throw new IllegalStateException("Could not retrieve generated id");
		return key.longValue();
	}

	public int update(String table, long id, Map<String, Object> values) {
		String set = values.keySet().stream().map(k -> k + "=:" + k).reduce((a, b) -> a + ", " + b).orElseThrow();
		MapSqlParameterSource params = new MapSqlParameterSource(values).addValue("id", id);
		return jdbc.update("UPDATE " + table + " SET " + set + " WHERE id=:id", params);
	}

	public int delete(String table, long id) {
		return jdbc.update("DELETE FROM " + table + " WHERE id=:id", new MapSqlParameterSource("id", id));
	}
}
