package com.springsynergy.jobapp.company.service;

import com.springsynergy.jobapp.company.model.CompanyDto;

import java.util.Set;
import java.util.UUID;

public interface CompanyService {
    Set<CompanyDto> getAllCompanies();

    CompanyDto getCompanyById(UUID companyId);

    void createCompany(CompanyDto companyDto);

    boolean updateCompanyById(String companyId, CompanyDto companyDto);

    CompanyDto getCompanyByName(String companyName);

    boolean deleteCompanyById(String companyId);
}
