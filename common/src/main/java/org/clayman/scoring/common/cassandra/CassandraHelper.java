package org.clayman.scoring.common.cassandra;

import com.datastax.driver.mapping.annotations.Table;

public class CassandraHelper {

    public static String getTableName(Class<?> clazz) {
        Table annotation = clazz.getAnnotation(Table.class);
        return annotation.name();
    }
}
