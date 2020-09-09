#!/bin/bash

SQL_FILE=$1

PGPASSWORD=postgres psql -U postgres -d atendo_em_libras -f ${SQL_FILE}