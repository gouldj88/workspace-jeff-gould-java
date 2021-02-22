drop table employee;
drop table department;
drop table project


create table employee
(
   employee_number serial           not null
  ,job_title  character varying(50) not null
  ,last_name  character varying(50) not null
  ,first_name character varying(50) not null
  ,gender     character varying(50) not null
  ,date_of_birth date               not null
  ,date_of_hire  date               not null
  ,department_number integer        not null
  ,constraint pk_employee_employee_number PRIMARY KEY(employee_number)
)
;

create table department
(
   department_number serial         not null
  ,name character varying(50)       not null
  ,no_of_employees int              not null
  ,constraint pk_department_department_number PRIMARY KEY(department_number)

)
;

create table project
(
   project_number serial            not null
  ,name character varying(50)       not null
  ,start_date date                  not null
  ,no_of_employees int              not null
  ,constraint pk_project_project_number PRIMARY KEY(project_number)
  ,constraint fk_

)
;