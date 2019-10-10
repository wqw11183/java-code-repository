package com.wqw.codelibrary.nosql.cassandra;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("cassandra")
@Data
@Builder
public class CassandraEntity {

    @PrimaryKey("id")
    private long id;

    @Column("user_id")
    private String userId;

    @Column("user_name")
    private String userName;

}
