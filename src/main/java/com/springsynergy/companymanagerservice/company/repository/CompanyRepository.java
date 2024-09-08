package com.springsynergy.jobapp.company.repository;

import com.springsynergy.jobapp.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID>, CompanyRepositoryCustom {

        Optional<Company> findByName(String companyName);
}
