#!/bin/bash

DB_ROOT=""
DB_ROOT_PASS=""
DB_NAME="inmobiliaria"
 
# Recogemos el input del usuario
read -p "Usuario root del servidor mysql: " DB_ROOT
read -p "Contraseña root para el servidor mysql: " DB_ROOT_PASS; 

# Creamos la nueva base de datos
mysql -u ${DB_ROOT} -p${DB_ROOT_PASS} -e "CREATE DATABASE IF NOT EXISTS ${DB_NAME} DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;"
echo "Base de datos creada correctamente."

exit
