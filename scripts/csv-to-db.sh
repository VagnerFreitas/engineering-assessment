#!/bin/bash

CSV_FILE=Mobile_Food_Facility_Permit.csv

PGHOST=localhost
PGPORT=5432
PGDATABASE=foodtruck
PGUSER=postgres
PGPASSWORD=password

#awk -f scripts/csv-to-db.awk $CSV_FILE | psql -h $PGHOST -p $PGPORT -d $PGDATABASE -U $PGUSER -W $PGPASSWORD
#awk -F ',' 'NR==1 {for(i=1; i<=NF; i++) {ix[$i] = i}} NR>1 {print "INSERT INTO truck (id, name, food_type, latitude, longitude) VALUES (" $ix["id"] ", '\''" $ix["name"] "'\'', '\''" $ix["food_type"] "'\'', " $ix["latitude"] ", " $ix["longitude"] ");"}' trucks.csv

declare -A column_map=(
  ["Latitude"]="latitude"
  ["Longitude"]="longitude"
  ["Applicant"]="applicant"
  ["FacilityType"]="facility_type"
  ["FoodItems"]="food_items"
)


# Gerar novo arquivo CSV com as colunas selecionadas
awk -F, -v OFS=, 'NR==1 {for(i=1;i<=NF;i++) { if ($i in col_map) {cols[i]=col_map[$i]} }} NR>1 {for(i=1;i<=NF;i++) {if(i in cols) {out[i]=$i}}} NR==1 {print OFS,$(NF-1),$NF} NR>1 {print OFS,out[$(NF-1)],out[$NF]}' $CSV_FILE > new.csv
