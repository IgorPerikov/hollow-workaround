CREATE KEYSPACE online_scoring
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 3}
    AND durable_writes = 'true';
