package egerton.backend.portfolio.model.user;

import egerton.backend.portfolio.implementation.Budget_Table_Impl;
import jakarta.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "site_section")
    private String siteSection;

    @Column(name = "status")
    private boolean status;

    public Preferences() {
    }

    public Preferences(long id, String siteSection, boolean status) {
        this.id = id;
        this.siteSection = siteSection;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSiteSection() {
        return siteSection;
    }

    public void setSiteSection(String siteSection) {
        this.siteSection = siteSection;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Preferences{" +
                "id=" + id +
                ", siteSection='" + siteSection + '\'' +
                ", status=" + status +
                '}';
    }
}
