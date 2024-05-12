INSERT INTO users (id, active, email, first_name, last_name, password)
VALUES
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (2, 1, 'user@example.com', 'User', 'Userov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (3, 1, 'kon.konov@gmail.com', 'Kon', 'Konov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');

INSERT INTO roles (`id`, `role`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles(`user_id`, `role_id`)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);


INSERT INTO `brands` (`id`, `name`)
VALUES
    (1, 'Toyota'),
    (2, 'Ford'),
    (3, 'Lamborghini');

INSERT INTO `models` (`id`, `category`, `brand_id`, `name`)
VALUES
    (1, 'CAR', 1, 'Camry'),
    (2, 'CAR', 1, 'Corolla'),
    (3, 'CAR', 2, 'Focus'),
    (4, 'CAR', 2, 'Fiesta'),
    (5, 'CAR', 3, 'Aventador');

INSERT INTO `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `uuid`, `year`, `model_id`)
VALUES
    (1,	'Много бързо!',	'PETROL', 'https://www.motortrend.com/uploads/sites/5/2020/02/2020-Lamborghini-Aventador-SVJ-Roadster-32.jpg', '7', '7.00',	'AUTOMATIC', '553bce77-f50c-48b1-a3d3-29206f51ae8e', '2020', '5'),
    (2,	'Много бързо!',	'PETROL', 'https://www.motortrend.com/uploads/sites/5/2020/02/2020-Lamborghini-Aventador-SVJ-Roadster-32.jpg', '7', '7.00',	'AUTOMATIC', '553bce77-f50c-48b1-a3d3-29206f51ae8e', '2021', '5'),
    (3,	'Много бързо!',	'PETROL', 'https://www.motortrend.com/uploads/sites/5/2020/02/2020-Lamborghini-Aventador-SVJ-Roadster-32.jpg', '7', '7.00',	'AUTOMATIC', '553bce77-f50c-48b1-a3d3-29206f51ae8e', '2022', '5'),
    (4,	'Много бързо!',	'PETROL', 'https://www.motortrend.com/uploads/sites/5/2020/02/2020-Lamborghini-Aventador-SVJ-Roadster-32.jpg', '7', '7.00',	'AUTOMATIC', '553bce77-f50c-48b1-a3d3-29206f51ae8e', '2023', '5'),
    (5,	'Много бързо!',	'PETROL', 'https://www.motortrend.com/uploads/sites/5/2020/02/2020-Lamborghini-Aventador-SVJ-Roadster-32.jpg', '7', '7.00',	'AUTOMATIC', '553bce77-f50c-48b1-a3d3-29206f51ae8e', '2024', '5');
