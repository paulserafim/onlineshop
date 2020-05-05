package com.online.shop.onlineshop;

import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.config.ConfigProperties;
import com.online.shop.onlineshop.model.Inventory;
import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.model.user.dto.ClientRequestDTO;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.repository.ProductRepository;
import com.online.shop.onlineshop.service.InventoryService;
import com.online.shop.onlineshop.service.user.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class OnlineShopApplication implements CommandLineRunner {

	private InventoryService inventoryService;
	private ClientService clientService;
	@Autowired
	ConfigProperties configProperties;

	public OnlineShopApplication  (
			InventoryService inventoryService,
			ClientService clientService,
			ConfigProperties configProperties) {
		this.configProperties = configProperties;
		this.clientService = clientService;
		this.inventoryService = inventoryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception, URISyntaxException {
		Path path = Paths.get(getClass().getClassLoader().getResource("testdata.txt").toURI());
		File file = new File(String.valueOf(path));
		Scanner scanner = new Scanner(file);

		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] splitArray = line.split("\t");
			inventoryService.save(new Inventory(new Product(splitArray[0], Double.parseDouble(splitArray[2]), splitArray[3]), Integer.parseInt(splitArray[1])));

		}
		ClientRequestDTO client = new ClientRequestDTO (
				"Paul",
				"Serafim",
				"serafim.paul@gmail.com",
				"Vaslui",
				"Vaslui",
				"Romania",
				"Crangului",
				"15",
				"def-123-ddc",
				26.5,
				"0748435380"
		);
		clientService.save(client);

	}
}
