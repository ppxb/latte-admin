-- liquibase formatted sql

-- changeset ppxb:1
-- common 初始化表结构

CREATE TABLE IF NOT EXISTS `sys_user`
(
    `id`             bigint(20)          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`       varchar(64)         NOT NULL COMMENT '用户名',
    `nickname`       varchar(30)         NOT NULL COMMENT '昵称',
    `password`       varchar(255)                 DEFAULT NULL COMMENT '密码',
    `gender`         tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别（0：未知；1：男；2：女）',
    `email`          varchar(255)                 DEFAULT NULL COMMENT '邮箱',
    `phone`          varchar(255)                 DEFAULT NULL COMMENT '手机号码',
    `avatar`         longtext                     DEFAULT NULL COMMENT '头像',
    `description`    varchar(200)                 DEFAULT NULL COMMENT '描述',
    `status`         tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态（1：启用；2：禁用）',
    `is_system`      bit(1)              NOT NULL DEFAULT b'0' COMMENT '是否为系统内置数据',
    `pwd_reset_time` datetime                     DEFAULT NULL COMMENT '最后一次修改密码时间',
    `dept_id`        bigint(20)          NOT NULL COMMENT '部门ID',
    `create_user`    bigint(20)                   DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime            NOT NULL COMMENT '创建时间',
    `update_user`    bigint(20)                   DEFAULT NULL COMMENT '修改人',
    `update_time`    datetime                     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uk_username` (`username`),
    UNIQUE INDEX `uk_email` (`email`),
    UNIQUE INDEX `uk_phone` (`phone`),
    INDEX `idx_dept_id` (`dept_id`),
    INDEX `idx_create_user` (`create_user`),
    INDEX `idx_update_user` (`update_user`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';
