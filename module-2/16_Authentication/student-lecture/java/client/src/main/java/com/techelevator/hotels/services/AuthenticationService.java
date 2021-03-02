package com.techelevator.hotels.services;

import com.techelevator.hotels.models.LoginDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

public class AuthenticationService {

    private String BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    private ConsoleService console = new ConsoleService();

    public AuthenticationService(String url) {
        this.BASE_URL = url;
    }

    public ResponseEntity<Map> login(String credentials) throws AuthenticationServiceException {
        LoginDTO loginDTO = new LoginDTO(credentials);			// Instantiate a LoginDTO object with a string passed to use
        HttpHeaders headers = new HttpHeaders();				// Instantiate headers for the HTTP request
        headers.setContentType(MediaType.APPLICATION_JSON);		// Set the content-type (what we are sending) to JSON
        HttpEntity<LoginDTO> entity = new HttpEntity<>(loginDTO, headers);	// Instantiate an HTTP entity to have a properly formatted request
        																	// 		request with the headers and data we want to send
        ResponseEntity<Map> response = null;		// Instantiate a response object to hold the response from the API call
        try {
        	// Make the API call to the server with the "/login" path and the request we set up
            response = restTemplate.exchange(BASE_URL + "/login", HttpMethod.POST, entity, Map.class);
        } catch(RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getResponseBodyAsString().length() == 0) {
                String message = ex.getRawStatusCode() + " : {\"timestamp\":\"" + LocalDateTime.now() + "+00:00\",\"status\":401,\"error\":\"Invalid credentials\",\"message\":\"Login failed: Invalid username or password\",\"path\":\"/login\"}";
                throw new AuthenticationServiceException(message);
            }
            else {
                String message = ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString();
                throw new AuthenticationServiceException(message);
            }
        }
        return response;
    }

}
