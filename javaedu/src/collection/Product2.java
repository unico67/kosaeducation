package collection;

import java.util.Objects;

public class Product2 implements Comparable<Product2> {
	private String ProductID;
	private String ProductName;
	private String ProductPrice;

	Product2() {	}

	Product2(String ProductID, String ProductName, String ProductPrice) {
		this.ProductID = ProductID;
		this.ProductName = ProductName;
		this.ProductPrice = ProductPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ProductID);
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Product2) {
			Product2 m = (Product2) o;
			if (ProductID == m.ProductID)
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Product2 p) {
		if (Integer.parseInt(ProductPrice) < Integer.parseInt(p.ProductPrice))
			return 1;
		else if (ProductPrice == p.ProductPrice)
			return 0;
		else
			return -1;
	}

	@Override
	public String toString() {
		return String.format("|%-10s|%-16s|%,10d원|", ProductID, ProductName, Integer.parseInt(ProductPrice));
	}
	
	public String getProductID() {
		return ProductID;
	}
	public String getProductName() {
		return ProductName;
	}
	public String getProductPrice() {
		return ProductPrice;
	}
}
