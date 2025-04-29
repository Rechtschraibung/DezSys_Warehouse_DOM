package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import warehouse.model.ProductData;
import warehouse.model.Warehouse;
import warehouse.service.ProductService;
import warehouse.service.WarehouseService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private WarehouseService warehouseService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Bestehende Daten leeren (optional, falls du neu anfangen willst)
		productService.deleteAllProducts();
		warehouseService.deleteAllWarehouses();

		Warehouse wh_hb = new Warehouse("Lager Nord", "Hamburg");
		Warehouse wh_mn = new Warehouse("Lager Süd", "München");
		Warehouse wh_dd = new Warehouse("Lager Ost", "Dresden");

		// Lagerhäuser anlegen
		warehouseService.createWarehouse(wh_hb);
		warehouseService.createWarehouse(wh_mn);
		warehouseService.createWarehouse(wh_dd);

		// Produkte anlegen
		productService.addProduct(new ProductData(wh_hb.getId(), "Bio Orangensaft Sonne", "Getraenk", 2500));
		productService.addProduct(new ProductData(wh_hb.getId(), "Bio Apfelsaft Gold", "Getraenk", 3420));
		productService.addProduct(new ProductData(wh_hb.getId(), "Ariel Waschmittel Color", "Waschmittel", 478));
		productService.addProduct(new ProductData(wh_hb.getId(), "Mampfi Katzenfutter Rind", "Tierfutter", 1324));
		productService.addProduct(new ProductData(wh_mn.getId(), "Saugstauberbeutel Ingres", "Reinigung", 7390));
		productService.addProduct(new ProductData(wh_mn.getId(), "Mineralwasser Classic", "Getraenk", 4800));
		productService.addProduct(new ProductData(wh_mn.getId(), "Bio Hafermilch", "Getraenk", 1500));
		productService.addProduct(new ProductData(wh_dd.getId(), "Hundeknochen Beef", "Tierfutter", 920));
		productService.addProduct(new ProductData(wh_dd.getId(), "WC Reiniger Ultra", "Reinigung", 1120));
		productService.addProduct(new ProductData(wh_dd.getId(), "Essigreiniger Natur", "Reinigung", 870));

		// Konsolenausgabe
		System.out.println();
		System.out.println("Erstellte Lagerhäuser:");
		warehouseService.getAllWarehouses().forEach(System.out::println);

		System.out.println();
		System.out.println("Erstellte Produkte:");
		productService.getAllProducts().forEach(System.out::println);

		System.out.println();
	}
}
