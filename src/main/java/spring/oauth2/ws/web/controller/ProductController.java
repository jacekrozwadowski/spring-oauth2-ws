package spring.oauth2.ws.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import spring.oauth2.ws.web.dto.Product;

@Controller
public class ProductController {

	private List<Product> list = new ArrayList<Product>();
	
	
	public ProductController() {
		list.add(new Product(1, "First Product", 9.99, "Active"));
    }

    @PreAuthorize("#oauth2.hasScope('product') and #oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/prods/{id}")
    @ResponseBody
    public Product findById(@PathVariable final long id) {
        return list.stream().filter(p -> p.getId()==id).findAny().orElse(new Product(0, "Dummy product", 0.01, "Inactive"));
    }
    
    @PreAuthorize("#oauth2.hasScope('product') and #oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/prods")
    @ResponseBody
    public List<Product> findAll() {
        return list;
    }

    @PreAuthorize("#oauth2.hasScope('product') and #oauth2.hasScope('write')")
    @RequestMapping(method = RequestMethod.POST, value = "/prods")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Product create(@RequestBody final Product product) {
    	//product.setId(Long.parseLong(randomNumeric(2)));
    	list.add(product);
        return product;
    }

	
}
