package org.example.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user_table")
public class User {
    // Mapping : attribute , relation
    // Mapping class name <==> table name
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // note : Long  ! Long
    @Column(name = "user_name")
    private String username;
    @Column(name = "first_name")
    private String firstname;
    @Column(name =  "last_name")
    private String lastname;
    @Column(name = "address")
    private String address;

    // common field
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column (name = "update_time")
    private Date updatedTime;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;



    @Transient
    private String attribute;

    @PrePersist
    public void PrePersist() {
        this.createdTime = new Date();
        this.updatedTime = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
