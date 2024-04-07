package egerton.backend.portfolio.controller;

import egerton.backend.portfolio.common.HttpRequestHandler;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("usajobs/")
public class USAJobsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(USAJobsController.class);

    @Value("${usa.jobs.api.authorizationKey}")
    private String authorizationKey;

    @Value("${usa.jobs.user.agent}")
    private String userAgent;

    @Value("${usa.jobs.api.url}")
    private String url;

    @Value("${usa.jobs.api.LocationName}")
    private String LocationName;

    @Value("${usa.jobs.api.search}")
    private String search;  

     @Value("${usa.jobs.api.Keyword}")
    private String Keyword; 

    @GetMapping("current-jobs")
    public String getUSAJobs(HttpServletRequest req, @RequestParam(required = false) String title,
                              @RequestParam(required = false) String location) {
        LOGGER.info(String.format("***** getUSAJobs *****" , req.getRequestURL().toString()));
        LOGGER.info(String.format("Received GET request with title: " + title + " and location: " + location));

        String locationURL = url + LocationName + location;
        String titleLocationURL = url + search + "&Keyword=" + title + "&LocationName=" + location;
        String keywordURL = url + Keyword + title;                 
        
        if (title.isEmpty() && location.length() > 0){
            return HttpRequestHandler.sendGetRequestUSAJobs(locationURL, userAgent, authorizationKey);
        }
        else if(title.length() > 0 && location.isEmpty()){
            return HttpRequestHandler.sendGetRequestUSAJobs(keywordURL, userAgent, authorizationKey);
        }
        else {
            return HttpRequestHandler.sendGetRequestUSAJobs(titleLocationURL, userAgent, authorizationKey);
        }
    }
}
