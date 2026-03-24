CREATE TABLE Users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username varchar(256) NOT NULL,
    password varchar(256) NOT NULL,
    PRIMARY KEY (id)
);