package com.kalatuwagama.repository;

import com.kalatuwagama.entity.DonationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DonationInfoRepository extends JpaRepository<DonationInfo, UUID> {
}