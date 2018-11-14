-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-14 18:33:55.904

-- tables
-- Table: Locations
CREATE TABLE Locations (
  id int NOT NULL,
  street varchar(30) NOT NULL,
  city varchar(30) NOT NULL,
  state varchar(30) NOT NULL,
  zip int NOT NULL,
  CONSTRAINT Locations_pk PRIMARY KEY (id)
);

-- Table: PhoneNumbers
CREATE TABLE PhoneNumbers (
  id int NOT NULL,
  number int NOT NULL,
  Users_id int NOT NULL,
  PhoneType_id int NOT NULL,
  CONSTRAINT PhoneNumbers_pk PRIMARY KEY (id)
);

-- Table: PhoneType
CREATE TABLE PhoneType (
  id int NOT NULL,
  type varchar(20) NOT NULL,
  CONSTRAINT PhoneType_pk PRIMARY KEY (id)
);

-- Table: Role
CREATE TABLE Role (
  id int NOT NULL,
  role varchar(30) NOT NULL,
  Users_id int NOT NULL,
  CONSTRAINT Role_pk PRIMARY KEY (id)
);

-- Table: Users
CREATE TABLE Users (
  id int NOT NULL,
  firstName varchar(30) NOT NULL,
  lastName varchar(30) NOT NULL,
  password varchar(100) NOT NULL,
  Locations_id int NOT NULL,
  username varchar(100) NOT NULL,
  CONSTRAINT id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: PhoneNumbers_PhoneType (table: PhoneNumbers)
ALTER TABLE PhoneNumbers ADD CONSTRAINT PhoneNumbers_PhoneType FOREIGN KEY PhoneNumbers_PhoneType (PhoneType_id)
REFERENCES PhoneType (id);

-- Reference: PhoneNumbers_Users (table: PhoneNumbers)
ALTER TABLE PhoneNumbers ADD CONSTRAINT PhoneNumbers_Users FOREIGN KEY PhoneNumbers_Users (Users_id)
REFERENCES Users (id);

-- Reference: Role_Users (table: Role)
ALTER TABLE Role ADD CONSTRAINT Role_Users FOREIGN KEY Role_Users (Users_id)
REFERENCES Users (id);

-- Reference: Users_Locations (table: Users)
ALTER TABLE Users ADD CONSTRAINT Users_Locations FOREIGN KEY Users_Locations (Locations_id)
REFERENCES Locations (id);

-- End of file.

