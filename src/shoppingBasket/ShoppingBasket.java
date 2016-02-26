package shoppingBasket;

import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingBasket {

	private int totalItems;
	private int totalProduct;
	private double totalBasketPrice;
	int availableSlot = 0;

	private ArrayList<ItemOrder> basket = new ArrayList();

	public void addItem(String item, double price,int qty){
		basket.add(new ItemOrder(item,price,qty));
		totalItems+= qty;
		totalProduct++;
		totalBasketPrice += basket.get(availableSlot).getTotalPrice();
		availableSlot++;
	}
	
	public boolean findItem(String itemName){
		for (ItemOrder o : basket) {
			if (o.getProductName().equals(itemName)){
				System.out.println("found");
				return true;
			}
		}
		return false;
	}
	
	public void addExistingItem(String itemName,int qty){
		for (ItemOrder o : basket) {
			if (o.getProductName().equals(itemName)){
				o.setQuantity(o.getQuantity() + qty);
				totalItems += qty;
				totalBasketPrice += (qty * o.getLatestPrice());
			}
		}
	}
	
	public void removeItemQuantity(String itemName, int quantity){
		if (findItem(itemName)){	
			for (ItemOrder o : basket) {
				if (o.getProductName().equals(itemName)){
					o.removeProductQuantity(quantity);	
					totalItems -= quantity;
					totalBasketPrice -= (o.getLatestPrice() * quantity);
				}
			}
		}
	}
	public void removeAllItem(String itemName){
		if (findItem(itemName)){	
			for (ItemOrder o : basket) {
				if (o.getProductName().equals(itemName)){
					totalItems -= o.getQuantity();
					totalBasketPrice -= (o.getLatestPrice() * o.getQuantity());
					basket.remove(o);
					totalProduct--;
					availableSlot--;
				}
			}
		}
	}
	public void clearList(){
		basket.clear();		
	}
	public ArrayList<ItemOrder> getBasket() {
		return basket;
	}
	public String showBasket() {
		String sb_list = "";
		for (ItemOrder o : basket) {
			sb_list += o.getProductName() + "\t " + o.getLatestPrice() + "\t " + o.getQuantity() + "\n";
		}
		return sb_list;
	}
	public double getTotalBasketPrice() {
		return totalBasketPrice;
	}
	public int getTotalProduct() {
		return totalProduct;
	}
	public int getTotalItems() {
		return totalItems;
	}	
}