// package egerton.backend.portfolio.service;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import egerton.backend.portfolio.model.user.User;
// import egerton.backend.portfolio.repository.user.UserRepository;

// @Service
// public class UserService {
// 	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
// 	@Autowired
// 	private final UserRepository userRepository;
	
// 	@Autowired
// 	public UserService(UserRepository userRepository) {
// 		this.userRepository = userRepository;
// 	}
	
// 	@Transactional
// 	public void saveUser(User user) {
// 		LOGGER.info("***** userRepository.save(user) ***** " + user.toString());
// 		userRepository.save(user);
// 	}

// }
