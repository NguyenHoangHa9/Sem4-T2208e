package org.example.entity;
import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "corporation_id", nullable = false)
    private Corporation corporation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }
}
