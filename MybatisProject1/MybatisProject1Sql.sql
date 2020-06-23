use db1;
drop table if exists `account`;

create table `account`(
	`ID` int(11) not null auto_increment comment '编号',
    `UID` int(11) default null comment '用户编号',
    `MONEY` double default null comment '金额',
    primary key (`id`),
    key `FK_Reference_8` (`UID`),
    constraint `FK_Reference_8` foreign key (`UID`) references `user` (`id`)
) engine = InnoDB default charset = utf8;

insert into `account` (`ID`,`UID`,`MONEY`) values (1,1,1000),(2,2,1000),(3,1,2000);