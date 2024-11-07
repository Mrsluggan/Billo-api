package com.idata.eboks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idata.eboks.models.Dispatch;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {

}