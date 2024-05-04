package egerton.backend.portfolio.controller;

import egerton.backend.portfolio.common.HttpRequestHandler;
import egerton.backend.portfolio.weather.IPData;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000/")
// @CrossOrigin(origins = "https://fullstack-portflio-app.scm.azurewebsites.net/")
@RestController
@RequestMapping("weather/")
public class WeatherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    @Value("${api.weatherapi.com.weatherKey}")
    private String weatherKey;

    @Value("${api.weatherapi.com.forecast}")
    private String forecast;

    @Value("${api.weatherapi.com.current}")
    private String current;

    @Value("${api.weatherapi.com.s}")
    private String weatherapis;

     @Value("${api.weatherapi.com}")
    private String weatherapi;

    @Value("${api.ipify.org.ip}")
    private String userIPAddress;

    @GetMapping("/")
    public String getWeatherData(HttpServletRequest req, @RequestParam(required = false) String weatherLocation) throws JsonMappingException, JsonProcessingException {
        LOGGER.info(String.format("***** getWeatherData *****" , req.getRequestURL().toString()));
        LOGGER.info(String.format("Received GET request with weatherLocation: " + weatherLocation));

        if (weatherLocation != null && weatherLocation.length() > 0){
            String locationName = weatherapis + forecast + ".json?q=" + weatherLocation  + "&days=7&key=" + weatherKey;
            return HttpRequestHandler.sendGetRequestWeather(locationName);
        }
        else{
            String jsonString = HttpRequestHandler.sendGetRequestWeather(userIPAddress);
            ObjectMapper objectMapper = new ObjectMapper();
            IPData ipData = objectMapper.readValue(jsonString, IPData.class);
            String ipWeather = weatherapi + forecast + ".json?key=" + weatherKey + "&q=" + ipData.getIp() + "&days=7&aqi=no";
            return HttpRequestHandler.sendGetRequestWeather(ipWeather);
        }
    }
}
