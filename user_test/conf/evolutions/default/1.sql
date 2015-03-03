# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table person (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  password                  varchar(255),
  is_admin                  tinyint(1) default 0,
  constraint pk_person primary key (id))
;

create table user_activity (
  u_id                      bigint,
  a_id                      bigint,
  step_count                double)
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table person;

drop table user_activity;

SET FOREIGN_KEY_CHECKS=1;

