package com.online.shop.onlineshop.model.dto;

import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientOrderResponseDTO {
    private Long orderId;
    private ClientResponseDTO clientResponseDTO;
    private LocalDate placedDate;
    private LocalDate dueDate;
    private String status;
    private String additionalInfo;
    private BasketResponseDTO basketResponseDTO;
}
