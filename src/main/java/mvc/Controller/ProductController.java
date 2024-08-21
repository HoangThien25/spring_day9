package mvc.Controller;

import mvc.model.ProductEntity;
import mvc.Sevice.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class ProductController {
    @Autowired
private ProductSevice productSevice;

    @RequestMapping(value ="/product", method = RequestMethod.GET)
    public String productList(Model model) {
        List<ProductEntity> products = productSevice.getAllProducts();
        model.addAttribute("products", products);
        return "ProductList";
    }

}
