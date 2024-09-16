package br.com.fiap.exemploMVC.Doracorde;

import org.springframework.boot.SpringApplication;

public class TestUserManagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(DoracordeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
