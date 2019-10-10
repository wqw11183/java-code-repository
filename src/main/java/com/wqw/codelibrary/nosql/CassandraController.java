package com.wqw.codelibrary.nosql;


import com.wqw.codelibrary.nosql.cassandra.CassandraDao;
import com.wqw.codelibrary.nosql.cassandra.CassandraEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cassandra")
@Api(value = "/cassandra", description = "c*测试类")
@Slf4j
public class CassandraController {

    @Autowired
    private CassandraDao cassandraDao;

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @GetMapping("/test")
    @ApiOperation("测试cassandra")
    public void test(){

        CassandraEntity cassandraEntity =
                CassandraEntity.builder().id(123).userId("123").userName("wqw").build();
        cassandraDao.save(cassandraEntity);
        log.info(cassandraDao.findByUserId("123").toString());


    }



}
