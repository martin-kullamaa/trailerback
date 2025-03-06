-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-03-05 13:02:52.85

-- tables
-- Table: equipment
CREATE TABLE equipment (
                           id serial  NOT NULL,
                           name varchar(255)  NOT NULL,
                           status varchar(1)  NOT NULL,
                           timestamp timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT equipment_pk PRIMARY KEY (id)
);

-- Table: location_start
CREATE TABLE location_start (
                                id serial  NOT NULL,
                                name varchar(255)  NULL,
                                latitude decimal(10,7)  NOT NULL,
                                longitude decimal(10,7)  NOT NULL,
                                CONSTRAINT location_start_pk PRIMARY KEY (id)
);

-- Table: location_stop
CREATE TABLE location_stop (
                               id serial  NOT NULL,
                               location_start_id int  NOT NULL,
                               latitude decimal(10,7)  NOT NULL,
                               longitude decimal(10,7)  NOT NULL,
                               sequence int  NOT NULL,
                               CONSTRAINT location_stop_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile (
                         id serial  NOT NULL,
                         role_id int  NOT NULL,
                         username varchar(255)  NOT NULL,
                         password varchar(255)  NOT NULL,
                         email varchar(255)  NOT NULL,
                         status varchar(1)  NOT NULL,
                         CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: trail
CREATE TABLE trail (
                       id serial  NOT NULL,
                       profile_id int  NOT NULL,
                       location_start_id int  NOT NULL,
                       name varchar(255)  NOT NULL,
                       description text  NOT NULL,
                       length decimal(4,1)  NOT NULL,
--                        timestamp timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       status varchar(1)  NOT NULL,
                       CONSTRAINT trail_pk PRIMARY KEY (id)
);

-- Table: trail_equipment
CREATE TABLE trail_equipment (
                                 id serial  NOT NULL,
                                 equipment_id int  NOT NULL,
                                 trail_id int  NOT NULL,
                                 CONSTRAINT trail_equipment_pk PRIMARY KEY (id)
);

-- Table: trail_picture
CREATE TABLE trail_picture (
                               id serial  NOT NULL,
                               trail_id int  NOT NULL,
                               data bytea  NOT NULL,
                               name varchar(255)  NULL,
                               status varchar(1)  NOT NULL,
                               CONSTRAINT trail_picture_pk PRIMARY KEY (id)
);

-- Table: trail_type
CREATE TABLE trail_type (
                            id serial  NOT NULL,
                            trail_id int  NOT NULL,
                            type_id int  NOT NULL,
                            CONSTRAINT trail_type_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      status varchar(255)  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: location_stop_location_start (table: location_stop)
ALTER TABLE location_stop ADD CONSTRAINT location_stop_location_start
    FOREIGN KEY (location_start_id)
        REFERENCES location_start (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_equipment_equipment (table: trail_equipment)
ALTER TABLE trail_equipment ADD CONSTRAINT trail_equipment_equipment
    FOREIGN KEY (equipment_id)
        REFERENCES equipment (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_equipment_trail (table: trail_equipment)
ALTER TABLE trail_equipment ADD CONSTRAINT trail_equipment_trail
    FOREIGN KEY (trail_id)
        REFERENCES trail (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_location_start (table: trail)
ALTER TABLE trail ADD CONSTRAINT trail_location_start
    FOREIGN KEY (location_start_id)
        REFERENCES location_start (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_picture_trail (table: trail_picture)
ALTER TABLE trail_picture ADD CONSTRAINT trail_picture_trail
    FOREIGN KEY (trail_id)
        REFERENCES trail (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_profile (table: trail)
ALTER TABLE trail ADD CONSTRAINT trail_profile
    FOREIGN KEY (profile_id)
        REFERENCES profile (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_type_trail (table: trail_type)
ALTER TABLE trail_type ADD CONSTRAINT trail_type_trail
    FOREIGN KEY (trail_id)
        REFERENCES trail (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: trail_type_type (table: trail_type)
ALTER TABLE trail_type ADD CONSTRAINT trail_type_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: profile)
ALTER TABLE profile ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

