package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.model.TacoOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes({"tacoOrder","message"})
public class OrderController {

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@SessionAttribute("message") String message, @Valid TacoOrder order,
                               Errors errors, SessionStatus sessionStatus){
        // test retrieve
        log.info("Our message {}",message);

        if(errors.hasErrors()){
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        log.info("Our session before: {}", sessionStatus.isComplete());
        sessionStatus.setComplete();
        log.info("Our session after: {}", sessionStatus.isComplete());

        return "redirect:/";
    }
}
