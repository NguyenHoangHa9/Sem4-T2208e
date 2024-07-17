package org.example.dto;

public class CompanyDto {
    private Long id;
    private String name;
    private CorporationDto corporation;

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

    public CorporationDto getCorporation() {
        return corporation;
    }

    public void setCorporation(CorporationDto corporation) {
        this.corporation = corporation;
    }
}
