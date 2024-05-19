package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.ConvertRequestDTO;
import bg.technologies.carshop.model.dto.ExchangeRatesDTO;
import bg.technologies.carshop.model.dto.MoneyDTO;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);

    MoneyDTO convert(ConvertRequestDTO convertRequestDTO);
}
