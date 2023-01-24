DROP DATABASE IF EXISTS THEATER;
CREATE DATABASE THEATER;
USE THEATER;

DROP USER IF EXISTS 'student'@'localhost';
CREATE USER 'student'@'localhost' IDENTIFIED BY 'ensf480';
GRANT ALL PRIVILEGES ON * . * TO 'student'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE REGISTERED_USERS (
	UserID		int NOT NULL AUTO_INCREMENT UNIQUE,
	Fname			varchar(255) NOT NULL,
	Lname		varchar(255) NOT NULL,
	address	    varchar(255) NOT NULL,
    payment_card	bigint NOT NULL,
    fees_paid		int NOT NULL,
    date_paid		varchar(255),
    email			varchar(255) UNIQUE NOT NULL,
    password		varchar(255) NOT NULL,
	PRIMARY KEY (UserID, email)
);

INSERT INTO REGISTERED_USERS (UserID, Fname, Lname, address, payment_card, fees_paid, date_paid, email, password)
VALUES
(1, 'Rayan', 'Khalil', '724 Rundleside Dr NE', 4724060789654321, 1, '', 'rayan.khalil@ucalgary.ca', 'MyPassword1'),
(2, 'Dyson', 'Davis', '1015 Rundleside Dr NE', 4724060789564789, 1, '', 'dyson.davis@ucalgary.ca', 'MyPassword2'),
(3, 'Mohammad', 'Mustafa', '72 Temple View NE', 6543789223564351, 0, NULL, 'mohammad.mustafa@ucalgary.ca', 'MyPassword3'),
(4, 'Alex', 'Yeap', '2024 Whitehorn Dr NE', 4134256376542908, 0, NULL, 'alex.yeap@ucalgary.ca', 'MyPassword4');


CREATE TABLE THEATERS (
	TheaterID			int NOT NULL AUTO_INCREMENT UNIQUE,
	theater_name			varchar(255) NOT NULL,
	address				varchar(255) NOT NULL,
	PRIMARY KEY (theater_name)
);

INSERT INTO THEATERS (TheaterID, theater_name, address)
VALUES
(1, 'Cineplex', '2555 32nd Street, Calgary, Alberta T1Y 7J6'),
(2, 'LandMark', '3412 49th Street NW, Calgary, Alberta T3A 2Y9'),
(3, 'Globe Cinema', '617 8 Ave. S.W., Calgary, Alberta T2P 1H1');

CREATE TABLE SHOW_ROOMS (
	room_id		int NOT NULL AUTO_INCREMENT UNIQUE,
    room_name	varchar(255) NOT NULL,
    theater_name	varchar(255) NOT NULL,
    PRIMARY KEY(room_id),
    FOREIGN KEY (theater_name) REFERENCES THEATERS (theater_name)
);

INSERT INTO SHOW_ROOMS (room_id, room_name, theater_name)
VALUES
(1, 'CSHR 1', 'Cineplex'),
(2, 'CSHR2', 'Cineplex'),
(3, 'CSHR 3', 'Cineplex'),
(4, 'LSHR 1', 'LandMark'),
(5, 'LSHR 2', 'LandMark'),
(6, 'LSHR 3', 'LandMark'),
(7, 'GSHR 1', 'Globe Cinema'),
(8, 'GSHR 2', 'Globe Cinema'),
(9, 'GSHR 3', 'Globe Cinema');

CREATE TABLE SEAT (
	seatID		int NOT NULL AUTO_INCREMENT UNIQUE,
    seat_number		varchar(10) NOT NULL,
    available		int NOT NULL,
    room_id			int NOT NULL,
    theaterID		int NOT NULL,
    PRIMARY KEY (seatID),
    FOREIGN KEY (room_id) REFERENCES SHOW_ROOMS (room_id),
    FOREIGN KEY (theaterID) REFERENCES THEATERS (TheaterID)
);

INSERT INTO SEAT (seatID, seat_number, available, room_id, theaterID)
VALUES
(1, 'A1', 1, 1, 1),
(2, 'A2', 1, 1, 1),
(3, 'A3', 1, 1, 1),
(4, 'A4', 1, 1, 1),
(5, 'A5', 1, 1, 1),
(6, 'A6', 1, 1, 1),
(7, 'B1', 1, 1, 1),
(8, 'B2', 1, 1, 1),
(9, 'B3', 1, 1, 1),
(10, 'B4', 1, 1, 1),
(11, 'B5', 1, 1, 1),
(12, 'B6', 1, 1, 1),
(13, 'C1', 1, 1, 1),
(14, 'C2', 1, 1, 1),
(15, 'C3', 1, 1, 1),
(16, 'C4', 1, 1, 1),
(17, 'C5', 1, 1, 1),
(18, 'C6', 1, 1, 1),
(19, 'D1', 1, 1, 1),
(20, 'D2', 1, 1, 1),
(21, 'D3', 1, 1, 1),
(22, 'D4', 1, 1, 1),
(23, 'D5', 0, 1, 1),
(24, 'D6', 1, 1, 1),
(25, 'E1', 1, 1, 1),
(26, 'E2', 1, 1, 1),
(27, 'E3', 1, 1, 1),
(28, 'E4', 1, 1, 1),
(29, 'E5', 1, 1, 1),
(30, 'E6', 1, 1, 1),
(31, 'A1', 1, 2, 1),
(32, 'A2', 1, 2, 1),
(33, 'A3', 0, 2, 1),
(34, 'A4', 1, 2, 1),
(35, 'A5', 1, 2, 1),
(36, 'A6', 1, 2, 1),
(37, 'B1', 1, 2, 1),
(38, 'B2', 1, 2, 1),
(39, 'B3', 1, 2, 1),
(40, 'B4', 1, 2, 1),
(41, 'B5', 1, 2, 1),
(42, 'B6', 1, 2, 1),
(43, 'C1', 1, 2, 1),
(44, 'C2', 0, 2, 1),
(45, 'C3', 1, 2, 1),
(46, 'C4', 1, 2, 1),
(47, 'C5', 1, 2, 1),
(48, 'C6', 1, 2, 1),
(49, 'D1', 1, 2, 1),
(50, 'D2', 1, 2, 1),
(51, 'D3', 1, 2, 1),
(52, 'D4', 1, 2, 1),
(53, 'D5', 1, 2, 1),
(54, 'D6', 1, 2, 1),
(55, 'E1', 1, 2, 1),
(56, 'E2', 1, 2, 1),
(57, 'E3', 1, 2, 1),
(58, 'E4', 1, 2, 1),
(59, 'E5', 1, 2, 1),
(60, 'E6', 1, 2, 1),
(61, 'F1', 1, 2, 1),
(62, 'F2', 1, 2, 1),
(63, 'F3', 1, 2, 1),
(64, 'F4', 1, 2, 1),
(65, 'F5', 1, 2, 1),
(66, 'F6', 1, 2, 1),
(67, 'G1', 1, 2,  1),
(68, 'G2', 1, 2, 1),
(69, 'G3', 1, 2, 1),
(70, 'G4', 1, 2, 1),
(71, 'A1', 1, 3, 1),
(72, 'A2', 1, 3, 1),
(73, 'A3', 1, 3, 1),
(74, 'A4', 1, 3, 1),
(75, 'A5', 1, 3, 1),
(76, 'B1', 1, 3, 1),
(77, 'B2', 1, 3, 1),
(78, 'B3', 1, 3, 1),
(79, 'B3', 1, 3, 1),
(80, 'B5', 1, 3, 1),
(81, 'C1', 1, 3, 1),
(82, 'C2', 1, 3, 1),
(83, 'C3', 1, 3, 1),
(84, 'C4', 1, 3, 1),
(85, 'C5', 1, 3, 1),
(86, 'D1', 1, 3, 1),
(87, 'D2', 1, 3, 1),
(88, 'D3', 1, 3, 1),
(89, 'D4', 1, 3, 1),
(90, 'D5', 1, 3, 1),
(91, 'A1', 1, 4, 2),
(92, 'A2', 1, 4, 2),
(93, 'A3', 1, 4, 2),
(94, 'A4', 1, 4, 2),
(95, 'A5', 1, 4, 2),
(96, 'A6', 1, 4, 2),
(97, 'B1', 1, 4, 2),
(98, 'B2', 1, 4, 2),
(99, 'B3', 1, 4, 2),
(100, 'B4', 1, 4, 2),
(101, 'B5', 1, 4, 2),
(102, 'B6', 1, 4, 2),
(103, 'C1', 1, 4, 2),
(104, 'C2', 1, 4, 2),
(105, 'C3', 1, 4, 2),
(106, 'C4', 1, 4, 2),
(107, 'C5', 1, 4, 2),
(108, 'C6', 1, 4, 2),
(109, 'D1', 1, 4, 2),
(110, 'D2', 1, 4, 2),
(111, 'D3', 1, 4, 2),
(112, 'D4', 1, 4, 2),
(113, 'D5', 1, 4, 2),
(114, 'D6', 1, 4, 2),
(115, 'E1', 1, 4, 2),
(116, 'E2', 1, 4, 2),
(117, 'E3', 1, 4, 2),
(118, 'E4', 1, 4, 2),
(119, 'E5', 1, 4, 2),
(120, 'E6', 1, 4, 2),
(121, 'A1', 1, 5, 2),
(122, 'A2', 1, 5, 2),
(123, 'A3', 0, 5, 2),
(124, 'A4', 1, 5, 2),
(125, 'A5', 1, 5, 2),
(126, 'A6', 1, 5, 2),
(127, 'B1', 1, 5, 2),
(128, 'B2', 1, 5, 2),
(129, 'B3', 1, 5, 2),
(130, 'B4', 1, 5, 2),
(131, 'B5', 1, 5, 2),
(132, 'B6', 1, 5, 2),
(133, 'C1', 1, 5, 2),
(134, 'C2', 1, 5, 2),
(135, 'C3', 1, 5, 2),
(136, 'C4', 1, 5, 2),
(137, 'C5', 1, 5, 2),
(138, 'C6', 1, 5, 2),
(139, 'D1', 1, 5, 2),
(140, 'D2', 1, 5, 2),
(141, 'D3', 1, 5, 2),
(142, 'D4', 1, 5, 2),
(143, 'D5', 1, 5, 2),
(144, 'D6', 1, 5, 2),
(145, 'E1', 1, 5, 2),
(146, 'E2', 1, 5, 2),
(147, 'E3', 1, 5, 2),
(148, 'E4', 1, 5, 2),
(149, 'E5', 1, 5, 2),
(150, 'E6', 1, 5, 2),
(151, 'F1', 1, 5, 2),
(152, 'F2', 1, 5, 2),
(153, 'F3', 1, 5, 2),
(154, 'F4', 1, 5, 2),
(155, 'F5', 1, 5, 2),
(156, 'F6', 1, 5, 2),
(157, 'G1', 1, 5, 2),
(158, 'G2', 1, 5, 2),
(159, 'G3', 1, 5, 2),
(160, 'G4', 1, 5, 2),
(161, 'A1', 1, 6, 2),
(162, 'A2', 1, 6, 2),
(163, 'A3', 1, 6, 2),
(164, 'A4', 1, 6, 2),
(165, 'A5', 1, 6, 2),
(166, 'B1', 1, 6, 2),
(167, 'B2', 1, 6, 2),
(168, 'B3', 1, 6, 2),
(169, 'B3', 1, 6, 2),
(170, 'B5', 1, 6, 2),
(171, 'C1', 1, 6, 2),
(172, 'C2', 1, 6, 2),
(173, 'C3', 1, 6, 2),
(174, 'C4', 1, 6, 2),
(175, 'C5', 1, 6, 2),
(176, 'D1', 1, 6, 2),
(177, 'D2', 1, 6, 2),
(178, 'D3', 1, 6, 2),
(179, 'D4', 1, 6, 2),
(180, 'D5', 1, 6, 2);


CREATE TABLE MOVIES (
	MovieID int NOT NULL AUTO_INCREMENT UNIQUE,
    movie_name		varchar(255) NOT NULL,
    releaseDate		varchar(255) NOT NULL,
    released	int NOT NULL,
    theater_name	varchar(255) NOT NULL,
    room_id		int NOT NULL,
    PRIMARY KEY (MovieID),
    FOREIGN KEY (theater_name) REFERENCES THEATERS (theater_name),
    FOREIGN KEY (room_id) REFERENCES SHOW_ROOMS (room_id)
);

INSERT INTO MOVIES (MovieID, movie_name, releaseDate, released, theater_name, room_id)
VALUES
(1, 'WALL-E', '2019-08-19', 1, 'Cineplex', 3),
(10, 'WALL-E', '2019-08-19', 1, 'Cineplex', 2),
(2, 'AVATAR', '2016-07-12', 1, 'Cineplex', 2),
(3, 'FINDING-NEMO', '2022-12-30', 0, 'Cineplex', 1),
(4, 'STAR-WARS', '2022-06-15', 1, 'LandMark', 5),
(5, 'MATRIX', '2023-01-18', 0, 'Globe Cinema', 8),
(6, 'BAMBI', '2020-07-28', 1, 'LandMark', 6),
(7, 'BATMAN', '2023-03-14', 0, 'Globe Cinema', 7),
(8, 'SMILE', '2022-02-02', 1, 'LandMark', 4),
(9, 'WALL-E', '2019-08-19', 1, 'LandMark', 5);

CREATE TABLE TICKET (
	ticketID	int NOT NULL AUTO_INCREMENT UNIQUE,
    for_registered_user	int NOT NULL,
    userID		int,
    seatID	int NOT NULL,
    date_purchased	varchar(255) NOT NULL,
    date_of_show	varchar(255) NOT NULL,
    PRIMARY KEY (ticketID),
    FOREIGN KEY (seatID) REFERENCES SEAT (seatID),
    FOREIGN KEY (userID) REFERENCES REGISTERED_USERS (UserID)
);

INSERT INTO TICKET (ticketID, for_registered_user, userID, seatID, date_purchased, date_of_show)
VALUES
(23, 1, 2, 44, '2022-11-14', '2022-12-14'),
(34, 0, NULL, 23, '2022-11-24', '2022-12-24'),
(54, 0, NULL, 123, '2022-11-30', '2022-12-09'),
(43, 1, 4, 33, '2022-11-27', '2022-12-19');


CREATE TABLE SHOW_TIMES (
	time_id		int NOT NULL AUTO_INCREMENT UNIQUE,
    date_of_show	varchar(225) NOT NULL,
    time_of_show	varchar(255) NOT NULL,
    room_id			int NOT NULL,
    PRIMARY KEY(time_id),
    FOREIGN KEY (room_id) REFERENCES SHOW_ROOMS (room_id)
);

INSERT INTO SHOW_TIMES (time_id, date_of_show, time_of_show, room_id)
VALUES
(1, '2022-12-09', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 1),
(2, '2022-12-19', '1:00 pm-5:00 pm-7:00 pm-9:00 pm', 1),
(3, '2022-12-24', '12:00 pm-6:00 pm-8:00 pm', 1),
(4, '2022-12-07', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 2),
(5, '2022-12-11', '1:00 pm-5:00 pm-6:00 pm-8:00 pm', 2),
(6, '2022-12-19', '12:00 pm-5:00 pm-6:00 pm-89:00 pm', 2),
(7, '2022-12-14', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 3),
(8, '2022-12-04', '12:00 pm-4:00 pm-7:00 pm', 3),
(9, '2022-12-24', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 4),
(10, '2022-12-09', '2:00 pm-4:00 pm', 4),
(11, '2022-12-10', '2:30 pm-5:00 pm-6:00 pm-8:00 pm', 5),
(12, '2022-12-12', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 6),
(13, '2022-12-14', '12:00 pm-3:00 pm-6:00 pm-8:00 pm', 6),
(14, '2022-12-14', '6:00 pm-8:00 pm', 7),
(15, '2022-12-23', '2:00 pm-4:00 pm-6:00 pm', 7),
(16, '2022-12-24', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 8),
(17, '2022-12-13', '2:00 pm-4:00 pm-8:00 pm', 8),
(18, '2022-12-18', '2:00 pm-4:00 pm-6:00 pm-8:00 pm', 9),
(19, '2022-12-04', '4:00 pm-6:00 pm-8:00 pm', 9);
