package com.tripmanagement.asdc.dao;

import com.tripmanagement.asdc.model.FuelEconomy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuelEconomyDAOImpl implements FuelEconomyDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(FuelEconomyDAOImpl.class);

}










