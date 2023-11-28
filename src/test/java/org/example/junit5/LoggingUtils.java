package org.example.junit5;


import org.example.LogTest;
import org.example.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Base64;

/**
 * Useful for binary data (e.g. sending files to ReportPortal)
 *
 * @author Andrei Varabyeu
 */

//@Slf4j
public class LoggingUtils extends TestBase {
	private final static Logger log = LoggerFactory.getLogger(LogTest.class);


	private LoggingUtils() {
		//statics only
	}

	public static void log(File file, String message) {
		log.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), message);
	}

	public static void log(byte[] bytes, String message) {
		log.info("RP_MESSAGE#BASE64#{}#{}", Base64.getEncoder().encodeToString(bytes), message);
	}

	public static void logBase64(String base64, String message) {
		log.info("RP_MESSAGE#BASE64#{}#{}", base64, message);
	}
}
