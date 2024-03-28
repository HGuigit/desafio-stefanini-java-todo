IF NOT EXISTS (SELECT 1 FROM sys.databases WHERE name='todolistdb')
BEGIN
    CREATE DATABASE todolistdb;
END