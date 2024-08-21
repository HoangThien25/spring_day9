package mvc.Controller;

import mvc.Sevice.CustomerSevice;
import mvc.model.CartSession;
import mvc.model.Customer;
import mvc.model.ProductEntity;
import mvc.Sevice.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private ProductSevice productService;
    @Autowired
  private CustomerSevice customerSevice;
    @RequestMapping(value ="/addToCart")
    public String addToCart(@RequestParam("productId") int productId, HttpSession session) {
        ProductEntity product = productService.getProductById(productId);
        CartSession cart = (CartSession) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartSession();
            session.setAttribute("cart", cart);
        }
        cart.addItem(product, 1);
        return "Cart";
    }

    @RequestMapping(value ="/updateCart")
    public String updateCart(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity, HttpSession session) {
        CartSession cart = (CartSession) session.getAttribute("cart");
        if (cart != null) {
            cart.updateItem(productId, quantity);
        }
        return "Cart";
    }

    @RequestMapping(value ="/removeFromCart")
    public String removeFromCart(@RequestParam("productId") int productId, HttpSession session) {
        CartSession cart = (CartSession) session.getAttribute("cart");
        if (cart != null) {
            cart.removeItem(productId);
        }
        return "Cart";
    }
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkOutFormCart(@ModelAttribute("customerForm") Customer customer, HttpSession session, Model model) {
        CartSession cart = (CartSession) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            model.addAttribute("error", "Your cart is empty!");
            return "Cart";
        }


        customerSevice.addCustomer(customer);


        // Clear the session cart after checkout
        session.removeAttribute("cart");

        // Redirect to the customer list page
        return "Checkout";
    }

    @RequestMapping("/listCustomers")
    public String showCustomerList(Model model) {
        // Fetch the customer list from the database
        List<Customer> customerList = customerSevice.getAllCustomers();
        model.addAttribute("customers", customerList);
        return "List"; // Ensure the view name matches your JSP
    }



}
