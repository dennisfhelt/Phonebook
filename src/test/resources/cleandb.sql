delete from user;
INSERT INTO user VALUES (1,'Joe','Coyne','jcoyne','supersecret1','1964-04-01'),(2,'Fred','Hensen','fhensen','supersecret2','1988-05-08'),(3,'Barney','Curry','bcurry','supersecret3','1947-11-11'),(4,'Karen','Mack','kmack','supersecret4','1986-07-08'),(5,'Dianne','Klein','dklein','supersecret5','1991-09-22'),(6,'Dawn','Tillman','dtillman','supersecret6','1979-08-30');
delete from role;
INSERT INTO role VALUES (1, 'admin', 1, 'jcoyne'), (2, 'admin', 2, 'fhensen');delete from sample_phonebook;

--ALTER TABLE `sample_phonebook` DROP `id`;
--ALTER TABLE `sample_phonebook` ADD `id` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
--INSERT INTO `sample_phonebook` VALUES
