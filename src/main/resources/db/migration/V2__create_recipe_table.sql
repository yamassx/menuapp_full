CREATE TABLE `recipe`
(
    `recipe_id`   int          NOT NULL AUTO_INCREMENT,
    `recipe_name` varchar(255) NOT NULL,
    `cal`         float        NOT NULL,
    PRIMARY KEY (`recipe_id`)
);