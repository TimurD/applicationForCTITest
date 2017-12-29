package com.example.service;

import com.example.domain.Response;

import java.util.HashMap;

public class MockedService {
	private HashMap<Integer, Response> responses;

	public MockedService() {
		responses = new HashMap<>();
		responses.put(0, new Response(200, "Success"));
		responses.put(1, new Response(204, "Unauthorized, Invalid token"));
		responses.put(2, new Response(420, "Invalid Sender (Tenant name)"));
		responses.put(3, new Response(421, "The requested module wasn’t found."));
		responses.put(4, new Response(422, "Invalid structure."));
		responses.put(5, new Response(423, "Request partially processed (Data Error)."));
		responses.put(6, new Response(500, "Other unexpected error occurred."));
	}


	public Response findById(Integer id) {
		return responses.get(id);
	}
}
