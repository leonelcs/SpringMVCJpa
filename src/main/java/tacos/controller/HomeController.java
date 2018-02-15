package tacos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Order;
import tacos.repository.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	OrderRepository repo;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Order> orders = new ArrayList<>();
		repo.findAll().forEach(o -> orders.add(o));
		model.addAttribute("orders", orders);
		return "home";
	}

}
