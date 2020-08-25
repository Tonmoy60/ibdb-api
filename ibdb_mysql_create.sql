CREATE TABLE `author` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`details` VARCHAR(255) NOT NULL,
	`rating` FLOAT NOT NULL,
	`type` VARCHAR(50) NOT NULL,
	`image_url` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `banner` (
	`id` INT NOT NULL,
	`title` VARCHAR(255) NOT NULL,
	`img_url` VARCHAR(255) NOT NULL,
	`promo_url` VARCHAR(255) NOT NULL
);

CREATE TABLE `book` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(100) NOT NULL,
	`details` VARCHAR(255) NOT NULL,
	`price` INT NOT NULL,
	`rating` FLOAT NOT NULL,
	`type` VARCHAR(50) NOT NULL,
	`img_url` VARCHAR(255) NOT NULL,
	`author` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `review` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`comment` VARCHAR(255) NOT NULL,
	`rating` FLOAT NOT NULL,
	`user` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`img_url` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `section` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `section_book` (
	`section_id` INT NOT NULL,
	`book_id` INT NOT NULL
);

ALTER TABLE `book` ADD CONSTRAINT `book_fk0` FOREIGN KEY (`author`) REFERENCES `author`(`id`);

ALTER TABLE `review` ADD CONSTRAINT `review_fk0` FOREIGN KEY (`user`) REFERENCES `user`(`id`);

ALTER TABLE `section_book` ADD CONSTRAINT `section_book_fk0` FOREIGN KEY (`section_id`) REFERENCES `section`(`id`);

ALTER TABLE `section_book` ADD CONSTRAINT `section_book_fk1` FOREIGN KEY (`book_id`) REFERENCES `book`(`id`);

