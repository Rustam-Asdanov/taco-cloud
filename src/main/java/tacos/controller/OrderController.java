package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.data.OrderRepository;
import tacos.model.TacoOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors, SessionStatus sessionStatus){
        // test retrieve
//        log.info("Our message {}",message);
        log.info("Order submitted: {}", order);

        if(errors.hasErrors()){
            return "orderForm";
        }

        orderRepository.save(order);

        log.info("Our session before: {}", sessionStatus.isComplete());
        sessionStatus.setComplete();
        log.info("Our session after: {}", sessionStatus.isComplete());
        return "redirect:/";
    }
}
