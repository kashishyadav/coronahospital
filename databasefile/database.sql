ALTER TABLE Customer CHANGE Address Addr char(50);
ALTER TABLE Customer RENAME COLUMN Address TO Addr;
-----------------------------------------------
select c.channel_no,d.name,p.name,c.room,c.date 
  from channel c inner join doctor d
  on c.doctorno=d.doctor_no 
  Inner join patient
  on c.patientno=p.patient_no
-----------------------------------
create database coronahospital
------------------------------------
USER TABLE:									
 
create table user(
     id int not null auto_increment,
     name varchar(255) not null,
     username varchar(255) not null,
     password varchar(20) not null,
     usertype varchar(20) not null,
     primary key(id));
--------------------------------------
PATIENT TABLE:                      							
 
create table patient(
     patient_no varchar(255) not null,
     name varchar(255) not null,
     phone varchar(255) not null,
     adress varchar(20) not null,
     primary key(patient_no));
-----------------------------------------
DOCTOR TABLE:
 
create table doctor(
     doctor_no varchar(255) not null,
     name varchar(255) not null,
     specialization varchar(255) not null,
     qualification varchar(20) not null,
     channelfee int,
     phone varchar(255),
     room varchar(255),
     log_id int,
     foreign key(log_id) references user(id),
     primary key(doctor_no));
-----------------------------------------
CHANNEL TABLE:

create table channel(
     channel_no varchar(255) not null,
     doctorno varchar(255) not null,
     patientno varchar(255) not null,
     roomno varchar(20) not null,
     date date not null,
     foreign key(doctorno) references doctor(doctor_no),
     foreign key(patientno) references patient(patient_no),
     primary key(channel_no));
------------------------------------------
ITEM TABLE:

create table item(
     item_no varchar(255) not null,
     item_name varchar(255) not null,
     description varchar(255) not null,
     sellprice int not null,
     buyprice int not null,
     quantity int not null,
     primary key(item_no));
------------------------------------------
PRESCRIPTION TABLE:

create table prescription(
     pre_id varchar(255) not null,
     channel_id varchar(255) not null,
     doctorname varchar(255) not null,
     detype varchar(255) not null,
     prescription varchar(255) not null,
     foreign key(channel_id) references channel(channel_no),
     primary key(pre_id));
------------------------------------------
SALES TABLE:

create table sales(
     id int auto_increment,
     date date,
     subtotal int not null,
     pay int not null,
     balance int not null,
     primary key(id));
------------------------------------------
SALES_PRODUCT TABLE:

create table sales_product(
     sid int auto_increment,
     sales_id int,
     prod_id varchar(255),
     sellprice int not null,
     quantity int not null,
     total int not null,
     foreign key(sales_id) references sales(id),
     primary key(sid));

