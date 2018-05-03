package com.ignacio.vila.subwaystatuscheck.repository;

import com.ignacio.vila.subwaystatuscheck.model.Line;
import org.springframework.data.repository.CrudRepository;

public interface LineStatusRepository extends CrudRepository<Line, Integer> {
}