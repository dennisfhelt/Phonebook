delete from sample_phonebook;
ALTER TABLE `sample_phonebook` DROP `id`;
ALTER TABLE `sample_phonebook` ADD `id` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
INSERT INTO `sample_phonebook` VALUES (1,'Head First Java, 2nd Edition','Kathy Sierra','978-0596009205',2005),(2,'Beginning Hibernate','joseph ottinger','978-1-4842-2319-2',2016),(3,'Java: A Beginner’s Guide (Sixth Edition)','Herbert Schilt','978-0071809252',2014);
