package com.bridgelabz.fellowship.utility;

import org.apache.log4j.Logger;

public class LogUtility {
	private static Logger logger;

	public static Logger getLog() {
		return logger;
	}

	public static void setLog(String programName) {
		LogUtility.logger = Logger.getLogger(programName);
	}

}
