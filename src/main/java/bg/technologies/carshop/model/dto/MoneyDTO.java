package bg.technologies.carshop.model.dto;

import java.math.BigDecimal;

public record MoneyDTO(String currency, BigDecimal amount) {
}
