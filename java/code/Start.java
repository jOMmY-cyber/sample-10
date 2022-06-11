import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Method 2
class Start{
    public static void main(String[] data){
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(Initialize.class);
        
        Cashier c = (Cashier)context.getBean("main");
        double total = c.calculateTotal(180);
        System.out.println(total);
    }
}



@Configuration
class Initialize{
    @Bean("main")
    Cashier m1(){
        Cashier c = new Cashier();
        c.setTax(15.0);
        return c;
    }
}
//Method 1
// class Start {
//    public static void main(String[] data) {
//        ApplicationContext context;
//        context = new ClassPathXmlApplicationContext
//        ("configure.xml");
//        Cashier c = (Cashier)context.getBean("main");
//        double total = c.calculateTotal(160);
//        System.out.printf("%.2f\n",  total);
//    }
//}



class Cashier{
    
    double multiplier = 1.0; //not a property
    
    double calculateTotal(double price){
        return price * multiplier;
    }//is an ordinary method , not a property
    
    public void setTax(double x){
        multiplier = 1.0 + (x/100);
    }// Property is "tax" , x is not related
    // tax is a writeable property
    
    String getCompany(){
        return "Duty Free";
    }// "Company" is a readable property
}