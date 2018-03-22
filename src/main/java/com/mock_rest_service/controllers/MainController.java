package com.mock_rest_service.controllers;


import com.mock_rest_service.services.XmlParsingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class MainController {
	private static final String OAUTH_RESPONSE_BODY = "<ResponseMessage>" +
				"<AccessToken>" +
					"Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ0ZW5hbnQiLCJpYXQiOjE1MTc1NTU0MzAsImV4cCI6MTUxNzU1NTQzNH0.GmFApUzZbcug2xMpeMMxRMf268IT5zsTIvKPnzEumGEJGRwPtnKF6Rikfw1mYYEoqObBBZrdNJv3_-L8_XbjD_9urSI51Cir6g3xO4hef9FKMMH0boLZF7zDjcKmLKSdUlC1mfDBmRdSZ0XfHFP7OocvCFM2kprFVQDQlBoHYH2GLk055utyfHQox6ibkipokz9TptKN4LiziOnfuMNnarxFPUS-vmgQBZf64spzzVuuOtqEGPM6Rptb0WrQ-pplUMVKMNyoPbjVa-auCUAOhXRF3kEX3mmQ95PrZSSeKGB1Yvn-_gebNyBoi9-Gp62xFPovtctPwC5FOB1ZGgfSmw" +
				"</AccessToken>" +
				"<ExpiresInMinutes>" +
					"3600" +
				"</ExpiresInMinutes >" +
			"</ResponseMessage>";
	private static final String RESPONSE_ON_TRIP_CRATION = "{  \n" +
			"   \"Id\":331,\n" +
			"   \"TripNumber\":\"310012507@52\",\n" +
			"   \"Stops\":[  \n" +
			"      {  \n" +
			"         \"Id\":\"0f076f29-4654-4217-8abc-3a83efe91a44\",\n" +
			"         \"ExternalId\":\"310012507@0@7@52\",\n" +
			"         \"FreightBills\":[  \n" +
			"            {  \n" +
			"               \"Id\":\"20906666-8e9a-4b0d-85b9-bbd8493733d2\",\n" +
			"               \"BillNumber\":\"310024586@1@1\",\n" +
			"               \"Existing\":true,\n" +
			"               \"Pallets\":[  \n" +
			"                  {  \n" +
			"                     \"Barcode\":\"Unit310024586\",\n" +
			"                     \"Id\":\"13eccce4-17b0-4178-a480-d3067e111008\",\n" +
			"                     \"Existing\":true\n" +
			"                  }\n" +
			"               ]\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {  \n" +
			"         \"Id\":\"0e5e6d3f-1921-48ba-b983-acd02ed4bd70\",\n" +
			"         \"ExternalId\":\"310012507@0@8@52\",\n" +
			"         \"FreightBills\":[  \n" +
			"            {  \n" +
			"               \"Id\":\"20906666-8e9a-4b0d-85b9-bbd8493733d2\",\n" +
			"               \"BillNumber\":\"310024586@1@1\",\n" +
			"               \"Existing\":true,\n" +
			"               \"Pallets\":[  \n" +
			"                  {  \n" +
			"                     \"Barcode\":\"Unit310024586\",\n" +
			"                     \"Id\":\"13eccce4-17b0-4178-a480-d3067e111008\",\n" +
			"                     \"Existing\":true\n" +
			"                  }\n" +
			"               ]\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {  \n" +
			"         \"Id\":\"e3a1109f-f94e-4131-ba45-a002885e4477\",\n" +
			"         \"ExternalId\":\"310012507@0@9@52\",\n" +
			"         \"FreightBills\":[  \n" +
			"            {  \n" +
			"               \"Id\":\"583127b2-251b-4d3a-950b-63ca1691c83c\",\n" +
			"               \"BillNumber\":\"310024587@1@1\",\n" +
			"               \"Existing\":true,\n" +
			"               \"Pallets\":[  \n" +
			"                  {  \n" +
			"                     \"Barcode\":\"Unit310024587\",\n" +
			"                     \"Id\":\"448acf85-0c43-44e9-bd87-455e52d89685\",\n" +
			"                     \"Existing\":true\n" +
			"                  }\n" +
			"               ]\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {  \n" +
			"         \"Id\":\"a9afb5ef-fee4-4f58-9bc0-96fb21e89828\",\n" +
			"         \"ExternalId\":\"310012507@0@10@52\",\n" +
			"         \"FreightBills\":[  \n" +
			"            {  \n" +
			"               \"Id\":\"583127b2-251b-4d3a-950b-63ca1691c83c\",\n" +
			"               \"BillNumber\":\"310024587@1@1\",\n" +
			"               \"Existing\":true,\n" +
			"               \"Pallets\":[  \n" +
			"                  {  \n" +
			"                     \"Barcode\":\"Unit310024587\",\n" +
			"                     \"Id\":\"448acf85-0c43-44e9-bd87-455e52d89685\",\n" +
			"                     \"Existing\":true\n" +
			"                  }\n" +
			"               ]\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {  \n" +
			"         \"Id\":\"152f6d2f-d66d-4f92-b47c-a0080e168ebf\",\n" +
			"         \"ExternalId\":\"310012507@0@11@52\",\n" +
			"         \"FreightBills\":[  \n" +
			"            {  \n" +
			"               \"Id\":\"347cef2f-c93f-4522-8051-be062ba48389\",\n" +
			"               \"BillNumber\":\"310024588@1@1\",\n" +
			"               \"Existing\":true,\n" +
			"               \"Pallets\":[  \n" +
			"                  {  \n" +
			"                     \"Barcode\":\"Unit310024588\",\n" +
			"                     \"Id\":\"745d4dc6-aa22-4f8f-a91f-4a1e36c6cd89\",\n" +
			"                     \"Existing\":true\n" +
			"                  }\n" +
			"               ]\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {  \n" +
			"         \"Id\":\"dc0741f2-3f08-4543-baa8-c4a8655da086\",\n" +
			"         \"ExternalId\":\"310012507@0@12@52\",\n" +
			"         \"FreightBills\":[  \n" +
			"            {  \n" +
			"               \"Id\":\"347cef2f-c93f-4522-8051-be062ba48389\",\n" +
			"               \"BillNumber\":\"310024588@1@1\",\n" +
			"               \"Existing\":true,\n" +
			"               \"Pallets\":[  \n" +
			"                  {  \n" +
			"                     \"Barcode\":\"Unit310024588\",\n" +
			"                     \"Id\":\"745d4dc6-aa22-4f8f-a91f-4a1e36c6cd89\",\n" +
			"                     \"Existing\":true\n" +
			"                  }\n" +
			"               ]\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	private static final String AUTHORITHATION_TOKEN = "\"f782d936-8c68-4dea-af7f-412fee461ea4\"";
	private final Logger LOGGER = LogManager.getLogger(MainController.class);

	@Autowired
	XmlParsingService xmlParsingService;

	@PostMapping
	public ResponseEntity printXmlToLog(@RequestHeader HttpHeaders headers, @RequestBody String xmlBody) {
		return xmlParsingService.parseXml(xmlBody);
	}

	@GetMapping
	public String returnOAuth2Token(@RequestHeader HttpHeaders headers) {
		LOGGER.info("OAuth2 token request received");
		return OAUTH_RESPONSE_BODY;
	}

	@PostMapping(path = "/auth")
	public String authorization(String json){
		return AUTHORITHATION_TOKEN;
	}

	@PostMapping(path = "/trip")
	public String trip(String trip){
		return RESPONSE_ON_TRIP_CRATION;
	}
}
