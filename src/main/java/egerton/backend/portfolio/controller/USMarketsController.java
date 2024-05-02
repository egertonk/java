package egerton.backend.portfolio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import egerton.backend.portfolio.common.HttpRequestHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@Api(value = "USMarketsController", description = "REST APIs for US Markets")
@RequestMapping("us-markets/")
public class USMarketsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(USMarketsController.class);

    @Value("${api.stock.com.stockKey}")
    private String stockKey;

    @Value("${api.stock.com.vOneUrl}")
    private String vOneUrl;
    
    @GetMapping("/")
    @ApiOperation(value = "Get a stock ticker info", response = String.class)
    public String getUSMarkets(HttpServletRequest req, @RequestParam(required = false) String sticker) {
        LOGGER.info(String.format("***** getUSMarkets *****" , req.getRequestURL().toString()));
        LOGGER.info(String.format("Received GET request with sticker: " + sticker));

        String v1URL = vOneUrl + "data/quote?symbols=" + sticker + "&api_token=" + stockKey;
        String newsURL = vOneUrl + "news/all?filter_entities=true&language=en&api_token=" + stockKey;
        String newsWithSYmbolURL = vOneUrl + "news/all?symbols=" + sticker + "&filter_entities=true&language=en&api_token=" + stockKey;
        String fullDetailsURL = vOneUrl + "data/quote?symbols=" + sticker + "&api_token=" + stockKey;                 
        
        // API objects
        String apiObject1 = HttpRequestHandler.sendGetRequestStocks(newsWithSYmbolURL).toString();
        String apiObject2 = HttpRequestHandler.sendGetRequestStocks(fullDetailsURL).toString();

        // Convert API objects to JsonObject
        Gson gson = new Gson();
        JsonObject jsonObject1 = gson.fromJson(apiObject1, JsonObject.class);
        JsonObject jsonObject2 = gson.fromJson(apiObject2, JsonObject.class);

        // Combine the two JsonObjects
        JsonObject combinedObject = new JsonObject();
        combinedObject.add("news", jsonObject1);
        combinedObject.add("fullData", jsonObject2);

        // Convert the combined JsonObject to a string
        String combinedJsonString = gson.toJson(combinedObject);
        
        return combinedJsonString;
    }
}
