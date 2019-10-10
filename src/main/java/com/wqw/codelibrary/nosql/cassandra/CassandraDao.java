package com.wqw.codelibrary.nosql.cassandra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassandraDao extends CrudRepository<CassandraEntity, Long> {

    CassandraEntity findByUserId(String userId);

}
