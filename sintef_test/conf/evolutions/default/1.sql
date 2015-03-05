# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table activity (
  name                      varchar(255) not null,
  step_factor               integer,
  constraint pk_activity primary key (name))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create table user_activity (
  id                        integer auto_increment not null,
  belongs_to_email          varchar(255),
  activity_name             varchar(255),
  steps                     double,
  constraint pk_user_activity primary key (id))
;

alter table user_activity add constraint fk_user_activity_belongsTo_1 foreign key (belongs_to_email) references user (email) on delete restrict on update restrict;
create index ix_user_activity_belongsTo_1 on user_activity (belongs_to_email);
alter table user_activity add constraint fk_user_activity_activity_2 foreign key (activity_name) references activity (name) on delete restrict on update restrict;
create index ix_user_activity_activity_2 on user_activity (activity_name);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table activity;

drop table user;

drop table user_activity;

SET FOREIGN_KEY_CHECKS=1;

