package ltw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ltw.model.Product;

@Repository
public interface ProductDao {
	List<Product> getList();
	Product getProduct(String code);
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(String code);
}
