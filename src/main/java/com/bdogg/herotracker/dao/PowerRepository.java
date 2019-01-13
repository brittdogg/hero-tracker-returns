package com.bdogg.herotracker.dao;

import com.bdogg.herotracker.model.Power;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface PowerRepository extends PagingAndSortingRepository<Power, Long> {
}