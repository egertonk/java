package egerton.backend.portfolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long project_id;

	@Column(name = "name")
	private String name;

	@Column(name = "link")
	private String link;

	@Column(name = "link_target")
	private String link_target;

	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projects(long project_id, String name, String link, String link_target) {
		super();
		this.project_id = project_id;
		this.name = name;
		this.link = link;
		this.link_target = link_target;
	}

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink_target() {
		return link_target;
	}

	public void setLink_target(String link_target) {
		this.link_target = link_target;
	}
}
