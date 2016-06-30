package com.tkhts.webservices.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tkhts.entity.User;
import com.tkhts.webservices.getuserservices.GetUserRequest;
import com.tkhts.webservices.getuserservices.GetUserResponse;
import com.tkhts.webservices.saveuserservices.SaveUserRequest;
import com.tkhts.webservices.saveuserservices.SaveUserResponse;


@Endpoint
public class UserServiceEndpoints {

	private static final String GET_TARGET_NAMESPACE = "http://com/tkhts/webservices/getUserServices";
	private static final String SAVE_TARGET_NAMESPACE = "http://com/tkhts/webservices/saveUserServices";
	
	
	
	  @PayloadRoot(localPart = "GetUserRequest", namespace = GET_TARGET_NAMESPACE)  
      public @ResponsePayload GetUserResponse getUserDetails(@RequestPayload GetUserRequest request)  
      {  
		  System.out.println("Get User !");
		  GetUserResponse response = new GetUserResponse();  
		  User user = new User();
		  user.setUserName("ravi");
		  user.setUserStatus("A");
		  user.setUserId("1");
		  user.setUserGender("M");
		  response.setUserDetails(user);
          return response;  
      } 
	  
	  @PayloadRoot(localPart = "SaveUserRequest", namespace = SAVE_TARGET_NAMESPACE)  
      public @ResponsePayload SaveUserResponse saveUserDetails(@RequestPayload SaveUserRequest request)  
      {  
		  System.out.println("Save User !");
		  SaveUserResponse response = new SaveUserResponse();  
		  response.setUserId("1");
          return response;  
      }

	
	  
}
