package com.app.miaaw.repos;

import com.app.miaaw.Domain.VideoOpties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 23/04/2019
*/
@Repository
public interface VideoOptiesRepository extends JpaRepository<VideoOpties, Long>, JpaSpecificationExecutor<VideoOpties> {

}
