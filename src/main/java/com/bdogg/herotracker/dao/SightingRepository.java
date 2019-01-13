package com.bdogg.herotracker.dao;

import com.bdogg.herotracker.model.Sighting;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface SightingRepository extends PagingAndSortingRepository<Sighting, Long> {
}