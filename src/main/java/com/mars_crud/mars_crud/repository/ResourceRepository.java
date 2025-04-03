package com.mars_crud.mars_crud.repository;

import com.mars_crud.mars_crud.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer> {

}
