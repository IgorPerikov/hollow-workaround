package org.clayman.scoring.common.cassandra;

public abstract class CassandraRepository<T> {

    private String tableName;

    /**
     * method override should be marked as {@link javax.annotation.PostConstruct} method or equivalent
     */
    protected abstract void setup();

    protected final String getTableName() {
        return tableName;
    }

    protected final void init(Class<T> clazz) {
        tableName = CassandraHelper.getTableName(clazz);
    }
}
