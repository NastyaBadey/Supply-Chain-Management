 SET NAMES utf8;
 CREATE DATABASE IF NOT EXISTS scm DEFAULT CHARACTER SET utf8;
 
 DROP TABLE IF EXISTS scm.rate_delivery_method;
 DROP TABLE IF EXISTS scm.transportation_waypoint;
 DROP TABLE IF EXISTS scm.transportation;
 DROP TABLE IF EXISTS scm.ticket;
 DROP TABLE IF EXISTS scm.waypoint;
 DROP TABLE IF EXISTS scm.route;
 DROP TABLE IF EXISTS scm.locality;
 DROP TABLE IF EXISTS scm.cargo;
 DROP TABLE IF EXISTS scm.rate;
 DROP TABLE IF EXISTS scm.delivery_method;
 DROP TABLE IF EXISTS scm.carrier;
 DROP TABLE IF EXISTS scm.cargo_owner;
 DROP TABLE IF EXISTS scm.user;
 
 
 CREATE TABLE IF NOT EXISTS scm.user(
   user_id INT(5) PRIMARY KEY,
   user_login VARCHAR(25) NOT NULL,
   user_password VARCHAR(25) NOT NULL,
   user_email VARCHAR(25) NOT NULL,
   user_role VARCHAR(2)
 );
 
 CREATE TABLE IF NOT EXISTS scm.cargo_owner(
   cargo_owner_id INT(5) PRIMARY KEY,
   cargo_owner_name VARCHAR(60) NOT NULL,
   cargo_owner_desc VARCHAR(255),
   cargo_owner_phone VARCHAR(20),
   user_id INT(5) NOT NULL,
   
   FOREIGN KEY (user_id) REFERENCES user(user_id)
 );
 
 CREATE TABLE IF NOT EXISTS scm.carrier(
   carrier_id INT(5) PRIMARY KEY,
   carrier_name VARCHAR(60) NOT NULL,
   carrier_desc VARCHAR(255),
   carrier_phone VARCHAR(20),
   user_id INT(5) NOT NULL,
   
   FOREIGN KEY (user_id) REFERENCES user(user_id)
);

  CREATE TABLE IF NOT EXISTS scm.delivery_method(
   delivery_method_id INT(5) PRIMARY KEY,
   delivery_method_name VARCHAR(40) NOT NULL,
   delivery_method_desc VARCHAR(255)
);

 CREATE TABLE IF NOT EXISTS scm.rate(
   rate_id INT(5) PRIMARY KEY,
   rate_price_per_kg FLOAT(10,2) NOT NULL,
   carrier_id INT(5) NOT NULL,
   
   FOREIGN KEY (carrier_id) REFERENCES carrier(carrier_id)
);

 CREATE TABLE IF NOT EXISTS scm.cargo(
   cargo_id INT(5) PRIMARY KEY,
   cargo_name VARCHAR(50) NOT NULL,
   cargo_length FLOAT(8,2),
   cargo_width FLOAT(8,2),
   cargo_height FLOAT(8,2),
   cargo_weight FLOAT(10,2),
   cargo_dangerous TINYINT,
   cargo_fragile TINYINT
);

  CREATE TABLE IF NOT EXISTS scm.locality(
   locality_id INT(5) PRIMARY KEY,
   locality_name VARCHAR(50) NOT NULL,
   country VARCHAR(30) NOT NULL
);

  CREATE TABLE IF NOT EXISTS scm.route(
   route_id INT(5) PRIMARY KEY,
   departure_locality_id INT(5) NOT NULL,
   destination_locality_id INT(5) NOT NULL,
   
   FOREIGN KEY (departure_locality_id) REFERENCES locality(locality_id),
   FOREIGN KEY (destination_locality_id) REFERENCES locality(locality_id)
);

  CREATE TABLE IF NOT EXISTS scm.waypoint(
   waypoint_id INT(5) PRIMARY KEY,
   route_id INT(5) NOT NULL,
   rate_id INT(5),
   from_locality_id INT(5) NOT NULL,
   to_locality_id INT(5) NOT NULL,
   backward TINYINT,
   
   FOREIGN KEY (route_id) REFERENCES route(route_id),
   FOREIGN KEY (from_locality_id) REFERENCES locality(locality_id),
   FOREIGN KEY (to_locality_id) REFERENCES locality(locality_id),
   FOREIGN KEY (rate_id) REFERENCES rate(rate_id)
);

  CREATE TABLE IF NOT EXISTS scm.ticket(
   ticket_id INT(5) PRIMARY KEY,
   cargo_owner_id INT(5) NOT NULL, 
   cargo_id INT(5) NOT NULL,
   cargo_quantity INT(7) NOT NULL,
   departure_date DATETIME NOT NULL,
   route_id INT(5) NOT NULL,
   status VARCHAR(30),
   date_of_creation DATETIME NOT NULL,
   
   FOREIGN KEY (cargo_owner_id) REFERENCES cargo_owner(cargo_owner_id),
   FOREIGN KEY (cargo_id) REFERENCES cargo(cargo_id),
   FOREIGN KEY (route_id) REFERENCES route(route_id)
);

  CREATE TABLE IF NOT EXISTS scm.transportation(
   transportation_id INT(5) PRIMARY KEY,
   ticket_id INT(5) NOT NULL,
   carrier_id INT(5) NOT NULL,
   status VARCHAR(30),
   destination_date DATETIME NOT NULL,
   total_price FLOAT(10,2) NOT NULL,
   
   FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id), 
   FOREIGN KEY (carrier_id) REFERENCES carrier(carrier_id)
);

  CREATE TABLE IF NOT EXISTS scm.transportation_waypoint(
   transportation_waypoint_id INT(5) PRIMARY KEY,
   transportation_id INT(5) NOT NULL,
   waypoint_id INT(5) NOT NULL,
   
   FOREIGN KEY (transportation_id) REFERENCES transportation(transportation_id),
   FOREIGN KEY (waypoint_id) REFERENCES waypoint(waypoint_id)
);   
  
  CREATE TABLE IF NOT EXISTS scm.rate_delivery_method(
   rate_delivery_method_id INT(5) PRIMARY KEY,
   rate_id INT(5) NOT NULL,
   delivery_method_id INT(5) NOT NULL,
   
   FOREIGN KEY (rate_id) REFERENCES rate(rate_id),
   FOREIGN KEY (delivery_method_id) REFERENCES delivery_method(delivery_method_id)
);
