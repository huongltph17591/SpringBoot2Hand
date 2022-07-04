package AssignmentJava5.model;

import org.hibernate.validator.constraints.NotEmpty;

import AssignmentJava5.entities.Product;

public class CartItem {
	private int id;
    private final Product product;
    @NotEmpty
    private int quantity;
    private double subTotal;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.subTotal = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        subTotal = product.getPrice() * quantity;
        return subTotal;
    }

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + ", subTotal=" + subTotal + "]";
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
