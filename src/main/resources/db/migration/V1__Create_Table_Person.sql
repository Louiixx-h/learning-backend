CREATE TABLE IF NOT EXISTS `person`
(
    `id`         bigint(20)   NOT NULL AUTO_INCREMENT,
    `first_name` varchar(100) NOT NULL,
    `last_name`  varchar(80)  NOT NULL,
    `birthday`   varchar(20)  NOT NULL,
    `address`    varchar(150) NOT NULL,
    `gender`     varchar(8)   NOT NULL,
    PRIMARY KEY (`id`)
);