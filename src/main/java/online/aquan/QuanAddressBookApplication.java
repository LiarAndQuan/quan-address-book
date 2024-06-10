package online.aquan;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.filter.OncePerRequestFilter;

@SpringBootApplication
@MapperScan("online.aquan.dao.mapper")
public class QuanAddressBookApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(QuanAddressBookApplication.class,args);
    }
}
