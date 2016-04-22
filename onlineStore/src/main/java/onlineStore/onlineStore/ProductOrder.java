package onlineStore.onlineStore;

public class ProductOrder {
	
	private String productName;
	private String productQuantity;
	private String productPrice;
	private String productCategory;

	

	public String getProductCategory ()
	{
		return productCategory;
	}

	public void setProductCategory (String  productCategory)
	{
		this.productCategory =  productCategory;
	}


	public String getProductName ()
	{
		return productName;
	}

	public void setProductName (String  productName)
	{
		this.productName =  productName;
	}
	
	public String getProductQuantity ()
	{
		return productQuantity;
	}

	
	public void setProductQuantity (String  productQuantity)
	{
		this.productQuantity =  productQuantity;
	}
	

	public String getProductPrice ()
	{
		return productPrice;
	}

	
	public void setProductPrice (String  productPrice)
	{
		this.productPrice =  productPrice;
	}
	
	


}
