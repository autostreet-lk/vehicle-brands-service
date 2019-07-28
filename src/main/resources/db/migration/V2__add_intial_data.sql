insert into hibernate_sequence(next_val) values(1);

insert into vehicle_brands(id,name) values(1,'Toyota');
insert into vehicle_brands(id,name) values(2,'Nissan');
insert into vehicle_brands(id,name) values(3,'Micro');


insert into vehicle_models(id,manufacturer_id,name) values(1,1,'Allion');
insert into vehicle_models(id,manufacturer_id,name) values(2,1,'Vitz');
insert into vehicle_models(id,manufacturer_id,name) values(3,1,'Prius');

insert into vehicle_models(id,manufacturer_id,name) values(4,2,'Sunny');
insert into vehicle_models(id,manufacturer_id,name) values(5,2,'TIDA');

insert into vehicle_models(id,manufacturer_id,name) values(6,3,'Panda');
insert into vehicle_models(id,manufacturer_id,name) values(7,3,'Kyron');
insert into vehicle_models(id,manufacturer_id,name) values(8,3,'Rexton');
