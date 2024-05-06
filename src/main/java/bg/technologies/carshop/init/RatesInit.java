package bg.technologies.carshop.init;

import bg.technologies.carshop.config.OpenExchangeRateConfig;
import bg.technologies.carshop.model.dto.ExchangeRatesDTO;
import bg.technologies.carshop.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class RatesInit implements CommandLineRunner {

    private final OpenExchangeRateConfig openExchangeRateConfig;
    private final RestTemplate restTemplate;
    private final CurrencyService currencyService;


    public RatesInit(OpenExchangeRateConfig exchangeRateConfig,
                     RestTemplate restTemplate, CurrencyService currencyService) {
        this.openExchangeRateConfig = exchangeRateConfig;
        this.restTemplate = restTemplate;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {

        if (openExchangeRateConfig.isEnabled()) {
            String openExchangeRateUrlTemplate =
                    openExchangeRateConfig.getSchema()
                            + "://"
                            + openExchangeRateConfig.getHost()
                            + openExchangeRateConfig.getPath()
                            + "?app_id={app_id}&symbols={symbols}"; // параметрите, които се изискват от open exchange rate

            Map<String, String> requestParams = Map.of(
                    "app_id", openExchangeRateConfig.getAppId(),
                    "symbols", String.join(",", openExchangeRateConfig.getSymbols())
            );

            ExchangeRatesDTO exchangeRatesDTO = restTemplate
                    .getForObject(openExchangeRateUrlTemplate,
                            ExchangeRatesDTO.class,
                            requestParams);


            System.out.println(exchangeRatesDTO);

            currencyService.refreshRates(exchangeRatesDTO);
        }
    }

}
