package warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productData")
public class ProductData {

	@Id
	private String ID;

	private String warehouseID;
	private String productName;
	private String productCategory;
	private double productQuantity;

	public ProductData() {}

	public ProductData(String warehouseID, String productName, String productCategory, double productQuantity) {
		this.warehouseID = warehouseID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return String.format(
				"Product Info: WarehouseID = %s, ProductName = %s, ProductCategory = %s, ProductQuantity = %4.1f",
				warehouseID, productName, productCategory, productQuantity
		);
	}
}
