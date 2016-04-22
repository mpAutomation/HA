package onlineStore.onlineStore;

import java.util.ArrayList;
import java.util.List;



import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.DescObject;
import api.Fuel_stations;
import api.WebRequestUtil;

public class APITestCases {
	
	/*
	Requirements:
		You can write your tests in any language, but the test must be coded (no cURL or POSTMan directions please).
		Specify JSON as the output format
		Please provide us with the information required to recreate a test environment to run your tests against
		
		Directions:
		Sign up for an API key here: https://api.data.gov/signup/
		Using this endpoint: https://api.data.gov/docs/nrel/transportation/alt-fuel-stations-v1/ write a test to:
		Query for nearest stations to Austin, TX that are part of the “ChargePoint Network”. Verify that “HYATT AUSTIN” appears in the results. Store/save the Station Id of the HYATT AUSTIN station.
	
		
		Use the Station ID from previous test to query the API and return the Street Address of that station. Verify the Station Address is 208 Barton Springs, Austin, Texas, USA, 78704

		Once you’ve written your tests, run them successfully, and are happy with the results:
		Push your tests to a public GitHub repository and provide us with the link to it
		Briefly document any test pre-requisites, assumptions made and any issues found in the read me file for your Repository

		This exercise should take ~60 minutes, but it’s fine to spend longer if you prefer.
	*/

	DescObject actualData=null;
	String hyattStationId="";
	
	
	@BeforeTest
	public void getData() throws Exception{
		DescObject pcActual=new DescObject();
		WebRequestUtil webReq=new WebRequestUtil();
		actualData=webReq.requestBuilderTypeGet(pcActual,"https://api.data.gov/nrel/alt-fuel-stations/v1/nearest.json?api_key=Lq2mSHFTGHZrPtLNVcnIy2zpHles0x8IO910CCNx&location=Austin+TX");

	}
	
	@Test
	public void getKeyForStation(){
		boolean validateFound=false;
		System.out.println("Hello");
		/*Query for nearest stations to Austin, TX that are part of the “ChargePoint Network”. 
		 * Verify that “HYATT AUSTIN” appears in the results. Store/save the Station Id of the HYATT AUSTIN station.
		 * 
		 */
		
		//"ev_network": "ChargePoint Network"  
		List<Fuel_stations> fuelStations_ChargePointNetwork=new ArrayList<Fuel_stations>();
		List<Fuel_stations> fuelStations=actualData.getFuel_stations();
		for(Fuel_stations fuelStation : fuelStations){
			if(fuelStation.getEv_network().equalsIgnoreCase("ChargePoint Network")){
				fuelStations_ChargePointNetwork.add(fuelStation);
			}
		}
		
		System.out.println("This is the number of fuel Stations in the charge point network "+fuelStations_ChargePointNetwork.size());
		
		//verify that the “HYATT AUSTIN” appears in the resultset
		for(Fuel_stations fuelStationResultItem : fuelStations_ChargePointNetwork){
			if(fuelStationResultItem.getStation_name().equalsIgnoreCase("HYATT AUSTIN")){
				validateFound=true;
				hyattStationId=fuelStationResultItem.getId();
				break;
			
			}
		}
		
		Assert.assertEquals(true, validateFound,"Validating that the Hyatt Austin station is in the result set");
		
		
		
	}
	
	
	@Test

	/*Use the Station ID from previous test to query the API and return the Street Address of that station. 
	 * Verify the Station Address is 208 Barton Springs, Austin, Texas, USA, 78704
	 */

	public void getAddressForStation(){
		
		//here just make the request to the end point using the stored value for hyattStationId .
		//
		
	}
	
	
	
	
	

}



