CREATE TABLE `menu_recipe`
(
    `menu_id`   int NOT NULL,
    `recipe_id` int NOT NULL,
    PRIMARY KEY (`menu_id`, `recipe_id`),
    KEY `menu_recipe_fk1` (`menu_id`),
    KEY `menu_recipe_fk2` (`recipe_id`),
    CONSTRAINT `menu_recipe_fk1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
    CONSTRAINT `menu_recipe_fk2` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
);