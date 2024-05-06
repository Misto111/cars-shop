package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.ExchangeRatesDTO;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);
}
