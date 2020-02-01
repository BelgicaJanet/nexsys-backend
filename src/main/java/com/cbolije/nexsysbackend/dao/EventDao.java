package com.cbolije.nexsysbackend.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cbolije.nexsysbackend.model.entity.Meeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class EventDao {

    private Logger mLog = LoggerFactory.getLogger(EventDao.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;


    }
    
    public void processData(String eventJson) {
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("graph_data", eventJson);
    	SimpleJdbcCall sqlFunction = new SimpleJdbcCall(jdbcTemplate).withFunctionName("process_data");
    	Map<String, Object> result = sqlFunction.execute(params);
        mLog.info("Resultados de la función -> " + result.toString());
    }

    public List<Meeting> getEventsByUser(long userId) {
        List<Meeting> meetings = new ArrayList<>();

        jdbcTemplate.query("select m.* from meeting m inner join attendance att on att.", (rs, rowNum) -> null);

        return meetings;
    }

}
