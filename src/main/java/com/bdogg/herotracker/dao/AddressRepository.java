package com.bdogg.herotracker.dao;

import com.bdogg.herotracker.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}