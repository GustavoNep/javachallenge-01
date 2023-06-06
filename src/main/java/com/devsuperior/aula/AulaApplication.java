package com.devsuperior.aula;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;


@SpringBootApplication
public class AulaApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("code: ");
		int code = sc.nextInt();

		System.out.print("basic: ");
		double basic = sc.nextDouble();

		System.out.print("discount: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		double totalCalc = orderService.total(order);
		System.out.printf("Pedido código " + code );
		System.out.println();
		System.out.printf("Valor Total : R$ %.2f%n", totalCalc);

		sc.close();
		System.exit(0);
	}
}
