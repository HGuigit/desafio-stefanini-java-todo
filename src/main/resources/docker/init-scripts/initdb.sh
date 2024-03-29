sleep 30s
echo "rodando script de set up"
/opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P ProjectTodoStefanini#2024 -d master -i initdb.sql