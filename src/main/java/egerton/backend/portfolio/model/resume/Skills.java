package egerton.backend.portfolio.model.resume;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long skill_id;

	@Column(name = "skill_category")
	private String skillCategory;

	@Column(name = "list_of_skills")
	private String[] listOfSkills;

	public long getSkill_id() {
		return skill_id;
	}

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skills(long skill_id, String skillCategory, String[] listOfSkills) {
		super();
		this.skill_id = skill_id;
		this.skillCategory = skillCategory;
		this.listOfSkills = listOfSkills;
	}

	public void setSkill_id(long skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	public String[] getListOfSkills() {
		return listOfSkills;
	}

	public void setListOfSkills(String[] listOfSkills) {
		this.listOfSkills = listOfSkills;
	}

}
