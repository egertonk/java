// package egerton.backend.portfolio.model.resume;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "jobs")
// public class Jobs {

// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private long job_id;

// 	@Column(name = "company_name")
// 	private String companyName;

// 	@Column(name = "job_title")
// 	private String jobTitle;

// 	@Column(name = "location")
// 	private String location;

// 	@Column(name = "duration")
// 	private String duration;

// 	@Column(name = "job_description")
// 	private String[] jobDescription;

// 	@Column(name = "contractor_name")
// 	private String contractorName;

// 	public Jobs() {
// 		super();
// 		// TODO Auto-generated constructor stub
// 	}

// 	public Jobs(long job_id, String companyName, String jobTitle, String location, String duration,
// 			String[] jobDescription, String contractorName) {
// 		super();
// 		this.job_id = job_id;
// 		this.companyName = companyName;
// 		this.jobTitle = jobTitle;
// 		this.location = location;
// 		this.duration = duration;
// 		this.jobDescription = jobDescription;
// 		this.contractorName = contractorName;
// 	}

// 	public long getJob_id() {
// 		return job_id;
// 	}

// 	public void setJob_id(long job_id) {
// 		this.job_id = job_id;
// 	}

// 	public String getCompanyName() {
// 		return companyName;
// 	}

// 	public void setCompanyName(String companyName) {
// 		this.companyName = companyName;
// 	}

// 	public String getJobTitle() {
// 		return jobTitle;
// 	}

// 	public void setJobTitle(String jobTitle) {
// 		this.jobTitle = jobTitle;
// 	}

// 	public String getLocation() {
// 		return location;
// 	}

// 	public void setLocation(String location) {
// 		this.location = location;
// 	}

// 	public String getDuration() {
// 		return duration;
// 	}

// 	public void setDuration(String duration) {
// 		this.duration = duration;
// 	}

// 	public String[] getJobDescription() {
// 		return jobDescription;
// 	}

// 	public void setJobDescription(String[] jobDescription) {
// 		this.jobDescription = jobDescription;
// 	}

// 	public String getContractorName() {
// 		return contractorName;
// 	}

// 	public void setContractorName(String contractorName) {
// 		this.contractorName = contractorName;
// 	}

// }
