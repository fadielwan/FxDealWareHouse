package com.fadi.insightwarehouse.rest.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fadi.insightwarehouse.rest.entity.FXDeal;

public interface FxDealRepo extends JpaRepository<FXDeal, Long> {

	Optional<FXDeal> findById(String id);

}
