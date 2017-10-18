package com.icare.ing.service_examples;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import antlr.collections.List;

import com.google.common.collect.ImmutableMap;
import com.icare.ing.dto.CH;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CREATE TABLE TEST1 (MYKEY VARCHAR NOT NULL PRIMARY KEY, A.COL1 VARCHAR, A.COL2 VARCHAR, B.COL3 VARCHAR)
 * @author kandhasamyr
 *
 */
public class SparkConnection implements Serializable {

    public static void main(String args[]) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("spark-phoenix-df");
        sparkConf.setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
//        Dataset<Row> fromPhx = sqlContext.read().format("jdbc")
//                .options(ImmutableMap.of("driver", "org.apache.phoenix.jdbc.PhoenixDriver", "url",
//                        "jdbc:phoenix:127.0.0.1:2181:/hbase-unsecure", "dbtable", "javatest"))
//                .load();
//        fromPhx.registerTempTable("tt");
//        sqlContext.sql("select * from tt where mykey=1").show();
        
//        Encoder<CD> segmentEncoder = Encoders.bean(CD.class);
//
//        ArrayList<CD> data = new ArrayList<CD>();
//        data.add(new CD());
//
//        Dataset<CD> ds = sqlContext.createDataset(data, segmentEncoder);
//        ds.write().mode("error").jdbc("jdbc:phoenix:127.0.0.1:2181:/hbase-unsecure", where, dbProperties);
    }
}