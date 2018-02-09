package com.mock_cti.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class XmlParsingService {
	private final Logger LOGGER = LogManager.getLogger(XmlParsingService.class);
	private static LinkedHashMap<String, Integer> errorMap = new LinkedHashMap<>();

	static {
		String WRONG_MESSAGE_204 = "INVALID TOKEN:NO_CONTENT_STATUS_204";
		String WRONG_MESSAGE_420 = "INVALID SENDER:STATUS_420";
		String WRONG_MESSAGE_421 = "MODULE WASN’T FOUND:STATUS_421";
		String WRONG_MESSAGE_422 = "INVALID STRUCTURE:STATUS_422";
		String WRONG_MESSAGE_423 = "DATA ERROR:STATUS_423";
		String WRONG_MESSAGE_500 = "UNEXPECTED ERROR:INTERNAL_SERVER_ERROR_STATUS_500";

		errorMap.put(WRONG_MESSAGE_204, 204);
		errorMap.put(WRONG_MESSAGE_420, 420);
		errorMap.put(WRONG_MESSAGE_421, 421);
		errorMap.put(WRONG_MESSAGE_422, 422);
		errorMap.put(WRONG_MESSAGE_423, 423);
		errorMap.put(WRONG_MESSAGE_500, 500);
	}

	public ResponseEntity parseXml(final String xml) {

		return errorMap.entrySet().stream()
				.filter(errorEntry -> isContainsError(xml, errorEntry.getKey()))
				.findFirst()
				.map(errorEntry -> ResponseEntity.status(errorEntry.getValue()).body(null))
				.orElse(new ResponseEntity(HttpStatus.OK));
	}

	private boolean isContainsError(String xml, String errorText) {
		if (xml.contains(errorText)) {
			LOGGER.error("We have got message with the mark: '" + errorText + "'");
			return true;
		}
		return false;
	}
}
