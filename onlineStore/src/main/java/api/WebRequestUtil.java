package api;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebRequestUtil {
	
	/***
	 * 
	 * @param t, The type of object to be returned used to creating the  List<T> 
	 * @param sEndPoint, the endPoint where the object t will be searched 
	 * @return the object found that matched the given t object
	 * @throws Exception
	 */
	public <T> T  requestBuilderTypeGet(T t,String sEndPoint) throws Exception{
		
		
		Client client = ClientHelper.AcceptAllCertificatesAllHosts.createClient();
		WebTarget webTarget = client.target(sEndPoint);
		
		Invocation.Builder invocationBuilder =webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response=invocationBuilder.get();
		System.out.println(String.valueOf(response.getStatus()));

		//validating success
		if(response.getStatus()!=200){
			throw new Exception("Endpoint get request "+sEndPoint +" failed with status "+String.valueOf(response.getStatus()));
		}

		String s=response.readEntity(String.class);


		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);	
		//JSON from file to Object

		

		mapper.setSerializationInclusion(Include.NON_NULL);	
		System.out.println(s);
		return (T) mapper.readValue(s, t.getClass());

	}




}
