package com.mock_cti.controllers;


import com.mock_cti.services.XmlParsingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class MainController {
	private final Logger LOGGER = LogManager.getLogger(MainController.class);

	@Autowired
	XmlParsingService xmlParsingService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity printmlToLog(@RequestHeader("Tenant-Ref") String module,
									   @RequestBody String xmlBody) throws Exception {
		LOGGER.info("Application: have got new post request with body: " + xmlBody);

		return xmlParsingService.parseXml(xmlBody);
	}
}
