CREATE TABLE IF NOT EXISTS person (
  id BIGINT AUTO_INCREMENT NOT NULL,
   first_name VARCHAR(80) NOT NULL,
   last_name VARCHAR(80) NOT NULL,
   address VARCHAR(255) NULL,
   gender VARCHAR(255) NULL,
   CONSTRAINT pk_person PRIMARY KEY (id)
);