# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create table user_activity (
  id                        integer not null,
  name                      varchar(255),
  belongs_to_email          varchar(255),
  constraint pk_user_activity primary key (id))
;

create sequence user_seq;

create sequence user_activity_seq;

alter table user_activity add constraint fk_user_activity_belongsTo_1 foreign key (belongs_to_email) references user (email) on delete restrict on update restrict;
create index ix_user_activity_belongsTo_1 on user_activity (belongs_to_email);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user;

drop table if exists user_activity;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;

drop sequence if exists user_activity_seq;

