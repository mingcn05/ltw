package ltw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ltw.model.Product;

@Repository
public class ProductDaoAPI implements ProductDao{
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<Product> getList() {
		String sql = "select * from sanpham";
		return jdbc.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public Product getProduct(String code) {
		String sql = "select * from sanpham where code = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<Product>(Product.class),code).get(0);
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into sanpham values(?,?,?)";
		jdbc.update(sql,product.getCode(),product.getDescription(),product.getPrice());
	}

	@Override
	public void deleteProduct(String code) {
		String sql = "delete from sanpham where code = ?";
		jdbc.update(sql,code);
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update from sanpham set description = ? and price = ? where code = ?";
		jdbc.update(sql,product.getDescription(),product.getPrice(),product.getCode());
	}

}
