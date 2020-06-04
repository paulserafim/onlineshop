package com.online.shop.onlineshop;

import com.online.shop.onlineshop.model.Basket;
import com.online.shop.onlineshop.model.dto.BasketItemRequestDTO;
import com.online.shop.onlineshop.model.dto.BasketRequestDTO;
import com.online.shop.onlineshop.model.dto.InventoryRequestDTO;
import com.online.shop.onlineshop.config.ConfigProperties;
import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.model.dto.ProductRequestDTO;
import com.online.shop.onlineshop.model.user.dto.ClientRequestDTO;
import com.online.shop.onlineshop.service.BasketService;
import com.online.shop.onlineshop.service.ClientOrderService;
import com.online.shop.onlineshop.service.InventoryService;
import com.online.shop.onlineshop.service.ProductService;
import com.online.shop.onlineshop.service.user.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class OnlineShopApplication implements CommandLineRunner {

	private InventoryService inventoryService;
	private ClientService clientService;
	private ClientOrderService clientOrderService;
	private BasketService basketService;
	private ProductService productService;
	@Autowired
	ConfigProperties configProperties;

	public OnlineShopApplication  (
			InventoryService inventoryService,
			ClientService clientService,
			ConfigProperties configProperties,
			ClientOrderService clientOrderService,
			BasketService basketService,
			ProductService productService) {
		this.configProperties = configProperties;
		this.clientService = clientService;
		this.inventoryService = inventoryService;
		this.clientOrderService = clientOrderService;
		this.basketService = basketService;
		this.productService = productService;
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
			inventoryService.save(new InventoryRequestDTO(new Product(splitArray[0], Double.parseDouble(splitArray[2]), splitArray[3]), Integer.parseInt(splitArray[1])));

		}
		log.info("Inventory created and saved");
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

		log.info("Client created and saved");

		Product product = productService.getProductByBarcode("8695122005662");
		Product product2 = productService.getProductByBarcode("1234567089997");
		log.info("Product created");
		ProductRequestDTO productRequestDTO = new ProductRequestDTO(
				"PERIE PANTOFI TP566=7LEI",
				"8695122005662",
				7.0,
				0.0
		);

		BasketItemRequestDTO basketItemRequestDTO = new BasketItemRequestDTO(
				productRequestDTO,
				3
		);

		List<BasketItemRequestDTO> basketItemRequestDTOS = new ArrayList<BasketItemRequestDTO>();
		basketItemRequestDTOS.add(basketItemRequestDTO);

		BasketRequestDTO basketRequestDTO = new BasketRequestDTO(
				31L,
				basketItemRequestDTOS
		);

		basketService.save(basketRequestDTO);

	}

}
