package com.esage.Logger;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class.getName());

	public static void main(String[] args) {
		logger.info("Current Time: {}", System.currentTimeMillis());
		logger.warn("æØ∏Ê–≈œ¢£∫{}", new Date().toString());
		
	}

}
