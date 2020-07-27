INSERT INTO Categories(id, category) VALUES(1, 'Elektronika');
INSERT INTO Categories(id, category) VALUES(2, 'Irankiai');
INSERT INTO Categories(id, category) VALUES(3, 'Telefonai');
INSERT INTO Categories(id, category) VALUES(4, 'Knygos');

INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Mac', 'Grazus', 263.10, 'mac.jpg', 1);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Playstation 5', 'Gerai atrodo', 197.30, 'playstation 5.jpg', 1);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Siurblys robotas', 'Puikiai siurbia', 199.40, 'siurblys.jpg', 1);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Siurblys sluota', 'Puikiai siurbia', 100.20, 'siurblysSluota.jpg', 1);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Galaxy Z Flip', 'Gerai atrodo', 197.30, 'galaxyZlip.jpg', 3);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('iphoneX', 'Gerai atrodo', 199.40, 'iphonex.jpg', 3);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Nokia', 'Gerai atrodo', 100.20, 'nokia.jpg', 3);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Atsuktuvas', 'Puikiai suka', 12.50, 'screwdriver.jpg', 2);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Graztas', 'Puikiai grezia', 150.50, 'graztas.jpg', 2);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('LG Oled', 'Puikiai rodo', 235.40, 'lg oled.jpg', 1);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Plaktukas', 'Puikiai kala', 12.50, 'hammer.jpg', 2);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Vinis', 'Puikiai laiko', 1.50, 'vinis.jpg', 2);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('LOTR', 'Puikiai skaitosi', 25.40, 'lordofthe.jpg', 4);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('El. Paspirtukas', 'Puikiai vaziuoja', 119.40, 'paspirtukas.jpg', 1);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Stop Smoking', 'Padeda mesti rukyt', 19.60, 'stopsmoking.jpg', 4);
INSERT INTO Products(title, description, price, file_name, category_id) VALUES('Why We Sleep', 'Puikiai skaitosi', 9.40, 'whywesleep.jpg', 4);

INSERT INTO Users(user_id, username, password, name, last_name)
    VALUES(1, 'user', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO', 'John', 'Doe');
INSERT INTO Users(user_id, username, password, name, last_name)
    VALUES(2, 'admin', '{bcrypt}$2y$12$A7x.2lPxE6YdV8ed6OYbDucRiod32wqMF9JNerE.wq4glQWaIjRnO', 'Jack', 'Sparrow');


INSERT INTO Roles(role_id, role) VALUES(1, 'CUSTOMER');
INSERT INTO Roles(role_id, role) VALUES(2, 'ADMIN');

INSERT INTO Users_Roles(user_id, role_id) VALUES(1, 1);
INSERT INTO Users_Roles(user_id, role_id) VALUES(2, 2);
