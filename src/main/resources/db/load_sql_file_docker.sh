#!/bin/bash

SQL_FILE=$1

docker exec atendo_em_libras psql -U postgres -d atendo_em_libras -f ${SQL_FILE}