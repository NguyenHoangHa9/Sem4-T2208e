package org.example.dto;
import java.util.List;

public class DepartmentDto {
    private Long id;
    private String name;
    private CompanyDto company;
    private List<UserDto> userDto;

    public void setUserDto(List<UserDto> userDto) {
        this.userDto = userDto;
    }

    public List<UserDto> getUserDto() {
        return userDto;

    }
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

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }
}
