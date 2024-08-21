    package mvc.Sevice;

    import mvc.Reponsitory.CustomerRepon;
    import mvc.model.Customer;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.orm.jpa.JpaTransactionManager;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;
@Service
    public class CustomerSevice {

        private JpaTransactionManager transactionManager;
        public CustomerSevice(JpaTransactionManager transactionManager){
            this.transactionManager=transactionManager;
        }

        public CustomerSevice() {
        }

        @Autowired
        private CustomerRepon customerRepon;

        // Phương thức để thêm khách hàng vào danh sách sau khi mua hàng
        public void addCustomer(Customer customer) {
            customerRepon.save(customer); // Lưu khách hàng vào cơ sở dữ liệu
        }

        // Phương thức để lấy danh sách khách hàng
        public List<Customer> getAllCustomers() {
            return customerRepon.findAll(); // Assuming you're using Spring Data JPA
        }
    }
