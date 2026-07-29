package com.kalatuwagama.kalatuwagama_backend.repository.common;

import com.kalatuwagama.kalatuwagama_backend.entity.common.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DonationRepository extends JpaRepository<Donation, UUID>, JpaSpecificationExecutor<Donation> {
    List<Donation> findByOrganizationId(UUID organizationId);
    List<Donation> findByOrganizationIdAndStatus(String status);
    Optional<Donation> findByTransactionId(String transactionId);
    List<Donation> findByOrganizationIdAndDonationDateBetween(UUID organizationId, LocalDate start, LocalDate end);
}
