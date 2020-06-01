-- Create table
create table T_USER(
  id       NUMBER(10) not null,
  name     VARCHAR2(11),
  password VARCHAR2(11),
  sex      VARCHAR2(8),
  birthday DATE
);
-- Add comments to the table 
comment on table T_USER is 'baizhi jdbc的测试项目用的表';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_USER add constraint ID primary key (ID);
-- Create sequence 
create sequence SEQ_USER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

--------------------------------------------------------------------
insert into T_USER (ID, NAME, PASSWORD, SEX, BIRTHDAY)
values (41, '张无忌', '121212', '男', to_date('30-05-2020', 'dd-mm-yyyy'));

insert into T_USER (ID, NAME, PASSWORD, SEX, BIRTHDAY)
values (43, '百晓生', '123456', '男', to_date('30-05-2020', 'dd-mm-yyyy'));