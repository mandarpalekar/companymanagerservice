package com.springsynergy.companymanagerservice.company.repository;

import com.springsynergy.companymanagerservice.company.entity.Company;

import java.util.Optional;

public interface CompanyRepositoryCustom {

    Optional<Company> findByCompanyName(String companyName);
}
