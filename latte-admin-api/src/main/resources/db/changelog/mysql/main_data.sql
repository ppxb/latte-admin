-- liquibase formatted sql

-- changeset ppxb:1
-- comment 初始化表数据
-- 初始化默认用户：admin/admin123；test/test123
INSERT INTO `sys_user`
(`id`, `username`, `nickname`, `password`, `gender`, `email`, `phone`, `avatar`, `description`, `status`, `is_system`,
 `pwd_reset_time`, `dept_id`, `create_user`, `create_time`)
VALUES (1, 'admin', '系统管理员', '{bcrypt}$2a$10$4jGwK2BMJ7FgVR.mgwGodey8.xR8FLoU1XSXpxJ9nZQt.pufhasSa', 1,
        '42190c6c5639d2ca4edb4150a35e058559ccf8270361a23745a2fd285a273c28', '5bda89a4609a65546422ea56bfe5eab4', NULL,
        '系统初始用户', 1, b'1', NOW(), 1, 1, NOW()),
       (547889293968801831, 'test', '测试员', '{bcrypt}$2a$10$xAsoeMJ.jc/kSxhviLAg7.j2iFrhi6yYAdniNdjLiIUWU/BRZl2Ti', 2,
        NULL, NULL, NULL, NULL, 1, b'0', NOW(), 547888483713155087, 1, NOW());
