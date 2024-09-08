package com.springsynergy.companymanagerservice.company.util;

import com.springsynergy.companymanagerservice.company.entity.Company;
import com.springsynergy.companymanagerservice.company.model.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyEntityDtoMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public CompanyDto companyToCompanyDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    public Company companyDtoToCompany(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }
}

