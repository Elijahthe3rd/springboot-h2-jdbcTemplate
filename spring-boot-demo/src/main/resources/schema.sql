CREATE TABLE course(
course_id integer identity,
title varchar(80) not null,
description varchar(500) not null,
link varchar(255) not null,
CONSTRAINT pk_course_id PRIMARY KEY (course_id)
);