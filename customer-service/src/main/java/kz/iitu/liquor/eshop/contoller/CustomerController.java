package kz.app.cart.shopping.contoller;
import kz.app.cart.shopping.dto.CustomerDTO;
import kz.app.cart.shopping.model.Customer;
import kz.app.cart.shopping.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO) {
        log.info("customerDTO : " + customerDTO.toString());
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO) {
        log.info("here");
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getById(id));
    }

    @HystrixCommand(fallbackMethod = "doDummyPay",
            commandProperties = {
                    @HystrixProperty(
                            name= "circuitBreaker.requestVolumeThreshold",
                            value="6"),
                    @HystrixProperty(
                            name= "circuitBreaker.sleepWindowInMilliseconds",
                            value="10000"),
                    @HystrixProperty(
                            name= "circuitBreaker.enabled",
                            value = "false")
            } )

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        customerService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

}
