-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 27, 2020 lúc 03:34 PM
-- Phiên bản máy phục vụ: 10.4.8-MariaDB
-- Phiên bản PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `btlbackend`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes`
--

CREATE TABLE `classes` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes_sq`
--

CREATE TABLE `classes_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `classes_sq`
--

INSERT INTO `classes_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `faculty`
--

CREATE TABLE `faculty` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `classes_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `faculty_sq`
--

CREATE TABLE `faculty_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `faculty_sq`
--

INSERT INTO `faculty_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `learning_day`
--

CREATE TABLE `learning_day` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `semester` int(11) DEFAULT NULL,
  `stage` int(11) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `learning_day_sq`
--

CREATE TABLE `learning_day_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `learning_day_sq`
--

INSERT INTO `learning_day_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `learning_subject_day`
--

CREATE TABLE `learning_subject_day` (
  `learning_day_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `poetry`
--

CREATE TABLE `poetry` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `exam_date` datetime DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `poetry_sq`
--

CREATE TABLE `poetry_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `poetry_sq`
--

INSERT INTO `poetry_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `poetry_student_list`
--

CREATE TABLE `poetry_student_list` (
  `poetry_id` bigint(20) NOT NULL,
  `student_list_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `seat` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `poetry_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room_sq`
--

CREATE TABLE `room_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `room_sq`
--

INSERT INTO `room_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

CREATE TABLE `schedule` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule_sq`
--

CREATE TABLE `schedule_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `schedule_sq`
--

INSERT INTO `schedule_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule_subject`
--

CREATE TABLE `schedule_subject` (
  `schedule_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `classes_id` bigint(20) DEFAULT NULL,
  `student_list_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `active`, `deleted`, `address`, `name`, `classes_id`, `student_list_id`, `user_id`) VALUES
(1, '2020-05-27 02:25:52', 0, '2020-05-27 02:25:52', 0, b'1', 0, 'string', 'string', NULL, NULL, NULL),
(52, '2020-05-27 03:07:18', 0, '2020-05-27 03:07:18', 0, b'1', 0, 'string', 'string', NULL, NULL, NULL),
(102, '2020-05-27 03:13:13', 0, '2020-05-27 03:13:13', 0, b'1', 0, 'string', 'Tran Kim Tin', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_list`
--

CREATE TABLE `student_list` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `identification_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_list_poetry`
--

CREATE TABLE `student_list_poetry` (
  `student_list_id` bigint(20) NOT NULL,
  `poetry_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_list_sq`
--

CREATE TABLE `student_list_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `student_list_sq`
--

INSERT INTO `student_list_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_sq`
--

CREATE TABLE `student_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `student_sq`
--

INSERT INTO `student_sq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `method_of_examination` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time_of_examination` datetime DEFAULT NULL,
  `learning_day_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject_learning_day`
--

CREATE TABLE `subject_learning_day` (
  `learning_day_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject_schedule`
--

CREATE TABLE `subject_schedule` (
  `subject_id` bigint(20) NOT NULL,
  `schedule_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject_sq`
--

CREATE TABLE `subject_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `subject_sq`
--

INSERT INTO `subject_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacher`
--

CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `poetry_id` bigint(20) DEFAULT NULL,
  `learning_day_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacher_sq`
--

CREATE TABLE `teacher_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `teacher_sq`
--

INSERT INTO `teacher_sq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `deleted` bigint(20) NOT NULL,
  `avatar` text DEFAULT NULL,
  `block` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `active`, `deleted`, `avatar`, `block`, `email`, `gender`, `name`, `password`, `salt`, `user_type`, `username`, `student_id`, `teacher_id`) VALUES
(1, '2020-05-27 02:05:37', 0, '2020-05-27 02:05:37', 0, b'1', 0, 'string', 0, 'admin01@gmail.com', 0, 'admin', '53ab8af4ec2d25594b9df3938cf6935b5b3519d65987215e1ec27fc3c7c3d008', 'string', 0, 'admin', NULL, NULL),
(52, '2020-05-27 02:06:58', 0, '2020-05-27 02:06:58', 0, b'1', 0, 'string', 0, 'student01@gmail.com', 0, 'student', 'a59424d6fb55786376a9906267e99a441c99b45cfaea8a279240662f17a181a4', 'string', 0, 'student', NULL, NULL),
(102, '2020-05-27 02:24:57', 0, '2020-05-27 02:24:57', 0, b'1', 0, 'string', 0, 'string', 0, 'string', 'a59424d6fb55786376a9906267e99a441c99b45cfaea8a279240662f17a181a4', 'string', 0, 'teacher', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_sq`
--

CREATE TABLE `user_sq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user_sq`
--

INSERT INTO `user_sq` (`next_val`) VALUES
(201);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhxmxp1ny7b408c12jr7icoddj` (`student_id`);

--
-- Chỉ mục cho bảng `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcsf83higtv2s8jq3lw791572d` (`classes_id`);

--
-- Chỉ mục cho bảng `learning_day`
--
ALTER TABLE `learning_day`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK21iw23mw8s1oti2uev67w180s` (`teacher_id`);

--
-- Chỉ mục cho bảng `learning_subject_day`
--
ALTER TABLE `learning_subject_day`
  ADD PRIMARY KEY (`learning_day_id`,`subject_id`),
  ADD KEY `FKmv10d47ib6lpbvguabh2a4k85` (`subject_id`);

--
-- Chỉ mục cho bảng `poetry`
--
ALTER TABLE `poetry`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKioquohb2u6jh5trp0k31w41xh` (`subject_id`),
  ADD KEY `FKq5efnqvosk11u7cfgwj5wnd83` (`room_id`);

--
-- Chỉ mục cho bảng `poetry_student_list`
--
ALTER TABLE `poetry_student_list`
  ADD PRIMARY KEY (`poetry_id`,`student_list_id`),
  ADD KEY `FKiihhklyvlwa6gqaip9ypess4q` (`student_list_id`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlp07ebafutbay0xgoatxhcu84` (`poetry_id`);

--
-- Chỉ mục cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgnncucgrm9l9erljneo80j1ma` (`student_id`);

--
-- Chỉ mục cho bảng `schedule_subject`
--
ALTER TABLE `schedule_subject`
  ADD PRIMARY KEY (`schedule_id`,`subject_id`),
  ADD KEY `FK9fi1pnjleeha52o8qidccu3l6` (`subject_id`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4l5dnicegnvpmu0pv6vdvrmb6` (`classes_id`),
  ADD KEY `FKixddexg9rh4jdnp3txaaf531y` (`student_list_id`),
  ADD KEY `FKk5m148xqefonqw7bgnpm0snwj` (`user_id`);

--
-- Chỉ mục cho bảng `student_list`
--
ALTER TABLE `student_list`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `student_list_poetry`
--
ALTER TABLE `student_list_poetry`
  ADD PRIMARY KEY (`student_list_id`,`poetry_id`),
  ADD KEY `FKsinyu3c5ag70ku3ur8p1dckcs` (`poetry_id`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8hjrj1pd6i3k5kbjklknajs3y` (`learning_day_id`);

--
-- Chỉ mục cho bảng `subject_learning_day`
--
ALTER TABLE `subject_learning_day`
  ADD PRIMARY KEY (`learning_day_id`,`subject_id`),
  ADD KEY `FKb6ugh6gnrl3c8h89k4vje9sgm` (`subject_id`);

--
-- Chỉ mục cho bảng `subject_schedule`
--
ALTER TABLE `subject_schedule`
  ADD PRIMARY KEY (`subject_id`,`schedule_id`),
  ADD KEY `FKkljjnxu479l7bg5rgllm1n5mu` (`schedule_id`);

--
-- Chỉ mục cho bảng `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe7nuunvn8ehp1jtonwo4nx5vw` (`poetry_id`),
  ADD KEY `FKb3ronumm18c9kppj3iwjwg5k` (`learning_day_id`),
  ADD KEY `FKpb6g6pahj1mr2ijg92r7m1xlh` (`user_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4dcom0y59k6tvg3yrguh8wjla` (`student_id`),
  ADD KEY `FKqn4ts7xw11sivn7qkqo4vso52` (`teacher_id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `FKhxmxp1ny7b408c12jr7icoddj` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Các ràng buộc cho bảng `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `FKcsf83higtv2s8jq3lw791572d` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`);

--
-- Các ràng buộc cho bảng `learning_day`
--
ALTER TABLE `learning_day`
  ADD CONSTRAINT `FK21iw23mw8s1oti2uev67w180s` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);

--
-- Các ràng buộc cho bảng `learning_subject_day`
--
ALTER TABLE `learning_subject_day`
  ADD CONSTRAINT `FKi83hx7op09dtvpxl50996aa4s` FOREIGN KEY (`learning_day_id`) REFERENCES `learning_day` (`id`),
  ADD CONSTRAINT `FKmv10d47ib6lpbvguabh2a4k85` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Các ràng buộc cho bảng `poetry`
--
ALTER TABLE `poetry`
  ADD CONSTRAINT `FKioquohb2u6jh5trp0k31w41xh` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKq5efnqvosk11u7cfgwj5wnd83` FOREIGN KEY (`room_id`) REFERENCES `poetry` (`id`);

--
-- Các ràng buộc cho bảng `poetry_student_list`
--
ALTER TABLE `poetry_student_list`
  ADD CONSTRAINT `FKiihhklyvlwa6gqaip9ypess4q` FOREIGN KEY (`student_list_id`) REFERENCES `student_list` (`id`),
  ADD CONSTRAINT `FKthbt0hush6cvftd4famvy6it` FOREIGN KEY (`poetry_id`) REFERENCES `poetry` (`id`);

--
-- Các ràng buộc cho bảng `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FKlp07ebafutbay0xgoatxhcu84` FOREIGN KEY (`poetry_id`) REFERENCES `poetry` (`id`);

--
-- Các ràng buộc cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `FKgnncucgrm9l9erljneo80j1ma` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Các ràng buộc cho bảng `schedule_subject`
--
ALTER TABLE `schedule_subject`
  ADD CONSTRAINT `FK9fi1pnjleeha52o8qidccu3l6` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKoe5846g7p5at1jomfmf7yh69w` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);

--
-- Các ràng buộc cho bảng `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FK4l5dnicegnvpmu0pv6vdvrmb6` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `FKixddexg9rh4jdnp3txaaf531y` FOREIGN KEY (`student_list_id`) REFERENCES `student_list` (`id`),
  ADD CONSTRAINT `FKk5m148xqefonqw7bgnpm0snwj` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `student_list_poetry`
--
ALTER TABLE `student_list_poetry`
  ADD CONSTRAINT `FKc4kf2l6j556hr98v7g064c5wn` FOREIGN KEY (`student_list_id`) REFERENCES `student_list` (`id`),
  ADD CONSTRAINT `FKsinyu3c5ag70ku3ur8p1dckcs` FOREIGN KEY (`poetry_id`) REFERENCES `poetry` (`id`);

--
-- Các ràng buộc cho bảng `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `FK8hjrj1pd6i3k5kbjklknajs3y` FOREIGN KEY (`learning_day_id`) REFERENCES `learning_day` (`id`);

--
-- Các ràng buộc cho bảng `subject_learning_day`
--
ALTER TABLE `subject_learning_day`
  ADD CONSTRAINT `FKb6ugh6gnrl3c8h89k4vje9sgm` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKl3r98f2pa2871pjr0kg8hauyt` FOREIGN KEY (`learning_day_id`) REFERENCES `learning_day` (`id`);

--
-- Các ràng buộc cho bảng `subject_schedule`
--
ALTER TABLE `subject_schedule`
  ADD CONSTRAINT `FKbi5ifccv10p28k6ctj6mwo0lo` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKkljjnxu479l7bg5rgllm1n5mu` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`);

--
-- Các ràng buộc cho bảng `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `FKb3ronumm18c9kppj3iwjwg5k` FOREIGN KEY (`learning_day_id`) REFERENCES `learning_day` (`id`),
  ADD CONSTRAINT `FKe7nuunvn8ehp1jtonwo4nx5vw` FOREIGN KEY (`poetry_id`) REFERENCES `poetry` (`id`),
  ADD CONSTRAINT `FKpb6g6pahj1mr2ijg92r7m1xlh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK4dcom0y59k6tvg3yrguh8wjla` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `FKqn4ts7xw11sivn7qkqo4vso52` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
