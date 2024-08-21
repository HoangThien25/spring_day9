package mvc.test;

import mvc.Config.CogFig;
import mvc.Reponsitory.CustomerRepon;
import mvc.model.Customer;
import mvc.model.ProductEntity;
import mvc.Reponsitory.ProductRepon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static ApplicationContext context=new AnnotationConfigApplicationContext(CogFig.class);
    static ProductRepon productRepon = (ProductRepon) context.getBean("productRepon");
    static CustomerRepon customerRepon = (CustomerRepon) context.getBean("customerRepon");
    public static void main(String[] args) {
//        createCustomer();
        create();
    }
    public static void create(){
        ProductEntity pr= new ProductEntity();
        pr.setId(2);
        pr.setName("sach Toán");
        pr.setPrice(300.0);
        ProductEntity pd=productRepon.save(pr);
        if(pd!=null){
            System.out.println("them thanh cong "+pd);
        }
    }
    public static void createCustomer(){
        Customer pr= new Customer();
        pr.setId(3);
        pr.setName("sach Toán");
        pr.setAddress("hue");
        Customer pd=customerRepon.save(pr);
        if(pd!=null){
            System.out.println("them thanh cong "+pd);
        }
    }


}
