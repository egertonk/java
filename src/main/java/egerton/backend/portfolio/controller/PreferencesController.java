// package egerton.backend.portfolio.controller;

// import egerton.backend.portfolio.model.user.Preferences;
// import egerton.backend.portfolio.repository.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @CrossOrigin(origins = "http://localhost:3000/")
// @RestController
// @RequestMapping("preferences/")
// public class PreferencesController {
// 	private static final Logger LOGGER = LoggerFactory.getLogger(PreferencesController.class);
// 	@Autowired
// 	private Preferences_Repository preferences_Repository;

// 	@PostMapping(value = "/update-preferences", consumes = "application/json", produces = "application/json")
// 	public void savePreferences(@RequestBody Preferences preferences) {
// 		try {
// 			preferences_Repository.save(preferences);
// 		} catch (Exception e) {
// 			// Get the cause of the exception
// 			Throwable cause = e.getCause();

// 			// Print the stack trace of the exception
// 			cause.printStackTrace();
// 		}
// 	}

// 	@GetMapping("/get-preferences")
// 	public List<Preferences> getBudgetDetails() {
// 		List<Preferences> tables = this.preferences_Repository.findAll();
// 		return tables;
// 	}
// }
