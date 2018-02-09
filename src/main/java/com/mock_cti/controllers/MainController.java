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
	private static final String OAUTH_RESPONSE_BODY = "<ResponseMessage>\n" +
			"<AccessToken>\n" +
			"Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ0ZW5hbnQiLCJpYXQiOjE1MTc1NTU0MzAsImV4cCI6MTUxNzU1NTQzNH0.GmFApUzZbcug2xMpeMMxRMf268IT5zsTIvKPnzEumGEJGRwPtnKF6Rikfw1mYYEoqObBBZrdNJv3_-L8_XbjD_9urSI51Cir6g3xO4hef9FKMMH0boLZF7zDjcKmLKSdUlC1mfDBmRdSZ0XfHFP7OocvCFM2kprFVQDQlBoHYH2GLk055utyfHQox6ibkipokz9TptKN4LiziOnfuMNnarxFPUS-vmgQBZf64spzzVuuOtqEGPM6Rptb0WrQ-pplUMVKMNyoPbjVa-auCUAOhXRF3kEX3mmQ95PrZSSeKGB1Yvn-_gebNyBoi9-Gp62xFPovtctPwC5FOB1ZGgfSmw\n" +
			"</AccessToken>\n" +
			"<ExpiresInMinutes>\n" +
			"3600\n" +
			"</ExpiresInMinutes >\n" +
			"</ResponseMessage>\n";
	private final Logger LOGGER = LogManager.getLogger(MainController.class);

	@Autowired
	XmlParsingService xmlParsingService;

	@PostMapping
	public ResponseEntity printxmlToLog(@RequestHeader("Tenant-Ref") String module,
										@RequestBody String xmlBody) throws Exception {
		LOGGER.info("Application: have got new post request with body: " + xmlBody);

		return xmlParsingService.parseXml(xmlBody);
	}

	@GetMapping
	public String returnOAuth2Token(@RequestHeader("Tenant-Ref") String tenantRef,
									@RequestHeader("Username") String username,
									@RequestHeader("Password") String password
	) {
		LOGGER.info("OAuth2 token request received");


		return OAUTH_RESPONSE_BODY;
	}
}
