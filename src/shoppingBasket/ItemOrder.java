package shoppingBasket;

public class ItemOrder {

	private String productName;
	private double latestPrice;
	private int quantity;

	public ItemOrder(String productName, double latestPrice, int quantity) {
		this.productName = productName;
		this.latestPrice = latestPrice;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getLatestPrice() {
		return latestPrice;
	}

	public void setLatestPrice(double latestPrice) {
		if(latestPrice >= 0){
			this.latestPrice = latestPrice;
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity >= 0){
			this.quantity = quantity;
		}
	}

	public double getTotalPrice(){
		return latestPrice * quantity;
	}

	public void addOneProductQuantity(){

		++quantity;
	}	

	public void addMoreProductQuantity(int quantity){

		this.quantity += quantity;
	}	
	public void removeOneProductQuantity(){
		if(quantity > 0 )
			--quantity;
	}
	public void removeProductQuantity(int quantity){
		if(this.quantity > quantity )
			this.quantity -= quantity;
	}
	public void removeAllProductQuantity(){
		quantity = 0;
	}

}
