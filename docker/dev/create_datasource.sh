#!/bin/bash

function check_is_jboss_cli_ready() {
  until `./jboss-cli.sh -c ":read-attribute(name=server-state)" 2>/dev/null | grep -q running`; do
    sleep 1
  done
}

echo "=> Starting WildFly in standalone mode "
./standalone.sh > /dev/null &

echo "=> Checking is jboss cli ready"
check_is_jboss_cli_ready 

echo "=> adding datasource"
sh jboss-cli.sh --connect --command="module add --name=org.postgres --resources=postgresql-42.2.5.jar --dependencies=javax.api,javax.transaction.api" 
sh jboss-cli.sh --connect --command="/subsystem=datasources/jdbc-driver=postgres:add(driver-name=postgres, driver-module-name=org.postgres, driver-class-name=org.postgresql.Driver, driver-datasource-class-name=org.postgresql.ds.PGSimpleDataSource, driver-xa-datasource-class-name=org.postgresql.xa.PGXADataSource)" 
sh jboss-cli.sh --connect --command="xa-data-source add \
                 										--name=bookShopXADS \
 								                		--driver-name=postgres \
										                --jndi-name=java:/PostgresXADS \
										                --user-name=admin \
										                --password=admin111 \
										                --valid-connection-checker-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker \
										                --exception-sorter-class-name=org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter \
										                --xa-datasource-properties={ \
										                  \"ServerName\" => \"bookShopDB\", \
										                  \"PortNumber\" => \"5432\", \
										                  \"DatabaseName\" => \"book_shop_db\"}"

echo "shutting down temp wildfly"
sh jboss-cli.sh --connect :shutdown