package onlineStore.onlineStore;

public class CustomerOrderInfo {
	
	
	private String shippingCountry;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String billingCountry;
	private String postalCode;
	private String phone;
	private String email;
	private boolean shippingSameAsBiling;
	
	public String getEmail(){
		return email;
	}
	

	public void setEmail(String email){
		this.email=email;
	}
	
	
	public String getShippingCountry(){
		return shippingCountry;
	}
	

	public void setShippingCountry(String shippingCountry){
		this.shippingCountry=shippingCountry;
	}



	public String getFirstName(){
		return firstName;
	}
	

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	

	public String getLastName(){
		return lastName;
	}
	

	public void setLastName(String lastName){
		this.lastName=lastName;
	}

	

	public String getAddress(){
		return address;
	}
	

	public void setAddress(String address){
		this.address=address;
	}


	public String getCity(){
		return city;
	}
	

	public void setCity(String city){
		this.city=city;
	}



	public String getBillingCountry(){
		return billingCountry;
	}
	

	public void setBillingCountry(String billingCountry){
		this.billingCountry=billingCountry;
	}
	

	public String getPostalCode(){
		return  postalCode;
	}
	

	public void setPostalCode(String  postalCode){
		this.postalCode= postalCode;
	}

	

	public String getPhone(){
		return  phone;
	}
	

	public void setPhone(String  phone){
		this.phone= phone;
	}

	

	public boolean  getShippingSameAsBiling(){
		return  shippingSameAsBiling;
	}
	

	public void  setShippingSameAsBiling(boolean shippingSameAsBiling){
		this.shippingSameAsBiling=  shippingSameAsBiling;
	}
	
	

}
