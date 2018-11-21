SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM Locations;
INSERT INTO Locations VALUES (1,'3302 Sweet Rd','Madison','Wisconsin',53704),(2,'3301 Portage Rd','Madison','Wisconsin',53704),(3,'333 web avn','Madison','Wisconsin',53704);

DELETE FROM Users;
INSERT INTO Users VALUES (1,'Aseng','Vue','Sweets8787',1,'asevue'),(2,'Robert','Curry','Rcurryburry123',2,'rcurry'),(3,'Steve','Winslow','SteSlow123',2,'Sslow'),(4,'Carrie','Barry','CBarns',3,'Cbarry');

DELETE FROM PhoneNumbers;
INSERT INTO PhoneNumbers VALUES (1,'608-628-9124',1,1),(2,'608-333-4568',2,1),(3,'608-444-5678',3,1),(4,'608-555-7895',4,2);

DELETE FROM Role;
INSERT INTO Role VALUES (1, 'admin', 'asevue', 1);

SET FOREIGN_KEY_CHECKS = 1;

