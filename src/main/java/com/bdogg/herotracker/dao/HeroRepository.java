package com.bdogg.herotracker.dao;

import com.bdogg.herotracker.model.Hero;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeroRepository extends PagingAndSortingRepository<Hero, Long> {
}