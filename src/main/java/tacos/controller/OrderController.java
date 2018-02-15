package tacos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Order;
import tacos.domain.User;
import tacos.repository.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping("/current")
	public String orderForm(Model model, @AuthenticationPrincipal User user) {
		System.out.println(user.getId());
		Order order = new Order();
		order.setName(user.getFullname().isEmpty()?user.getUsername():user.getFullname());
		order.setStreet(user.getStreet());
		order.setCity(user.getCity());
		order.setState(user.getState());
		order.setZip(user.getZip());
		model.addAttribute("order", order);
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus,
			@AuthenticationPrincipal User user) {
		if (errors.hasErrors()) {
			return "orderForm";
		}
		order.setUser(user);
		orderRepo.save(order);
		sessionStatus.setComplete();
		
		
		log.info("Order submitted: " + order);
		return "redirect:/";
	}

}
