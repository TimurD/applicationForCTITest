package com.example.webservice;

import com.example.domain.Response;
import com.example.domain.Test;
import com.example.service.MockedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockedCT {

	private MockedService mockedService;

	public MockedCT() {
		mockedService = new MockedService();
	}

	@PostMapping("/status")
	public ResponseEntity status(@RequestHeader("Tenant-Ref") String tenantName,
								 @RequestHeader("Module-Code") String module,
								 @RequestHeader("Authorization") String OAuthToken,
								 @RequestBody Test test) {
		Response response = mockedService.findById(test.getId());

		return ResponseEntity
				.status(response.getStatus())
				.body("Description: " + response.getDescription());
	}
}
