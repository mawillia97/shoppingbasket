package shoppingBasket;

public class TestShoppingBasket {

	public static void main(String[] args) {
		
		ShoppingBasket sb = new ShoppingBasket();
		
		sb.addItem("Shirt", 10, 7);
		sb.addItem("Shoe", 40, 2);
		
		sb.addExistingItem("Shirt", 3);
		sb.addExistingItem("Shoe", 4);
		
		sb.removeAllItem("Shirt");
		sb.removeItemQuantity("Shoe", 2);
		
		System.out.println(sb.showBasket());
		System.out.println(sb.getTotalBasketPrice());
		System.out.println(sb.getTotalProduct());
		System.out.println(sb.getTotalItems());
		

	}

}
