INSERT INTO BUILDING(id,name) VALUES (12,'buildingA');
INSERT INTO BUILDING(id,name) VALUES (11,'buildingB');

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature,BUILDING_ID) VALUES(-10, 'Room1', 1, 22.3, 20.0,12);
INSERT INTO ROOM(id, name, floor,BUILDING_ID) VALUES(-9, 'Room2', 1,11);

INSERT INTO HEATER(id, heater_status, name, power, room_id,BUILDING_ID) VALUES(-10, 'ON', 'Heater1', 2000, -10,12);
INSERT INTO HEATER(id, heater_status, name, power, room_id,BUILDING_ID) VALUES(-9, 'ON', 'Heater2', null, -10,11);

INSERT INTO RWINDOW(id, window_status, name, room_id,BUILDING_ID) VALUES(-10, 'CLOSED', 'Window 1', -10,11);
INSERT INTO RWINDOW(id, window_status, name, room_id,BUILDING_ID) VALUES(-9, 'CLOSED', 'Window 2', -10,11);
INSERT INTO RWINDOW(id, window_status, name, room_id,BUILDING_ID) VALUES(-8, 'OPEN', 'Window 1', -9,12);
INSERT INTO RWINDOW(id, window_status, name, room_id,BUILDING_ID) VALUES(-7, 'CLOSED', 'Window 2', -9,12);
