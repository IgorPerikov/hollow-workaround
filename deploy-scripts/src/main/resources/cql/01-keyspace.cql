CREATE KEYSPACE IF NOT EXISTS online_scoring
 WITH REPLICATION {'class':'SimpleStrategy', 'replication_factor' : 1}
 AND DURABLE_WRITES = TRUE