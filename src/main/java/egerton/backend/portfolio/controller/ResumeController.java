// package egerton.backend.portfolio.controller;

// import java.util.List;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import egerton.backend.portfolio.model.resume.Jobs;
// import egerton.backend.portfolio.model.Projects;
// import egerton.backend.portfolio.model.resume.Skills;
// import egerton.backend.portfolio.model.user.User;
// import egerton.backend.portfolio.repository.resume.JobsRepository;
// import egerton.backend.portfolio.repository.ProjectsRepository;
// import egerton.backend.portfolio.repository.resume.SkillsRepository;
// import egerton.backend.portfolio.repository.user.UserRepository;
// import egerton.backend.portfolio.service.UserService;

// @CrossOrigin(origins = "http://localhost:3000/")
// @RestController
// @RequestMapping("resume/")
// public class ResumeController {

// 	private static final Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);

// 	@Autowired
// 	private UserRepository userRepository;

// 	@Autowired
// 	private UserService userService;

// 	@Autowired
// 	private JobsRepository jobsRepository;

// 	@Autowired
// 	private SkillsRepository skillsRepository;

// 	@Autowired
// 	private ProjectsRepository projectsRepository;
	
// 	@GetMapping("jobs")
// 	public List<Jobs> getJobs() {
// 		LOGGER.info("***** getJobs *****");
// 		return this.jobsRepository.findAll();
// 	}

// 	@GetMapping("users")
// 	public List<User> getUsers() {
// 		LOGGER.info("***** getJobs *****");
// 		return this.userRepository.findAll();
// 	}

// 	@PostMapping(value = "/addusers", consumes = "application/json", produces = "application/json")
// 	public void SaveUser(@RequestBody User user) {
// 		LOGGER.info("***** SaveUser *****", user);
// 		userService.saveUser(user);
// 	}

// 	@GetMapping("skills")
// 	public List<Skills> getSkills() {
// 		LOGGER.info("***** getSkills *****");
// 		return this.skillsRepository.findAll();
// 	}

// 	@GetMapping("projects")
// 	public List<Projects> getProjects() {
// 		LOGGER.info("***** getProjects *****");
// 		return this.projectsRepository.findAll();
// 	}
	
// }
