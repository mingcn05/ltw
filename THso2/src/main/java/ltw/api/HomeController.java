package ltw.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ltw.dao.ProductDao;
import ltw.model.Product;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ProductDao pDao;
	
	@GetMapping
	public String indexHTML(Model model) {
		return "index";
	}
	
	@GetMapping("/view")
	public String index(Model model) {
		List<Product> products = pDao.getList();
		model.addAttribute("products", products);
		return "productView";
	}
	
	@GetMapping("/getProduct")
	public String view(@ModelAttribute("code")String code,Model model) {
		if(code.equals("null")) {
			Product product = new Product();
			product.setCode("");
			product.setDescription("");
			product.setPrice((float) 0.0);
			model.addAttribute("product", new Product());
		}
		else {
			Product product = pDao.getProduct(code);
			model.addAttribute("product", product);
		}
		return "updateProduct";
	}
	
	@GetMapping("/getProductDelete")
	public String delete(@ModelAttribute("code")String code,Model model) {
		Product product = pDao.getProduct(code);
		model.addAttribute("product", product);
		return "deleteProduct";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request,@ModelAttribute("product")Product product,Model model) {
		if((boolean) request.getAttribute("update")) {
			pDao.addProduct(product);
		}
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String deleteP (HttpServletRequest request,@ModelAttribute("product")Product product,Model model) {
		if((boolean) request.getAttribute("yes")) {
			pDao.addProduct(product);
		}
		return "redirect:/";
	}
}
