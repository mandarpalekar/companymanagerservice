package com.springsynergy.companymanagerservice.company.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyDto {

    private String name;
    private String description;
    private String location;
}