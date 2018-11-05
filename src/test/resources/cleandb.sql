delete from sample_phonebook;
ALTER TABLE `sample_phonebook` DROP `id`;
ALTER TABLE `sample_phonebook` ADD `id` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
INSERT INTO `sample_phonebook` VALUES
