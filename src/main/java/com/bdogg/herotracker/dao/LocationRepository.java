package com.bdogg.herotracker.dao;

import com.bdogg.herotracker.model.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {
}