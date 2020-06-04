package com.online.shop.onlineshop.model;

import com.online.shop.onlineshop.model.dto.BasketItemRequestDTO;
import com.online.shop.onlineshop.model.dto.BasketResponseDTO;
import com.online.shop.onlineshop.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.online.shop.onlineshop.model.user.Client;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = "client")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToOne(mappedBy = "basket")
    private ClientOrder clientOrder;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketItem> basketItems = new ArrayList<>();

    public Basket(Client client, List<BasketItem> basketItems) {
        this.client = client;
        this.basketItems = basketItems;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
