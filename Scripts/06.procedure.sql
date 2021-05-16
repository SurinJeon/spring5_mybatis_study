-- procedure
select *
  from tutors t left join courses c 
    on t.tutor_id = c.tutor_id;
   
-- 교수가 개설한 교과목 수를 구하시오.
select t.name as tutor, count(c.name) as total
  from tutors t left join courses c
    on t.tutor_id = c.tutor_id
 group by t.name;

select t.name as tutor, count(c.name) as total
  from tutors t left join courses c 
    on t.tutor_id = c.tutor_id
 where t.tutor_id  = 1;
 
select * from tutors;
select * from courses;

drop procedure if exists mybatis_study.course_total;

delimiter $$
$$
create procedure mybatis_study.course_total(in t_id int)
begin
	select t.name as tutor, count(c.name) as total
	  from tutors t left join courses c 
	    on t.tutor_id = c.tutor_id
	 where t.tutor_id  = t_id;
end$$
delimiter ;


call course_total(1);


-- 
drop procedure if exists mybatis_study.course_total_group;

delimiter $$
$$
create procedure mybatis_study.course_total_group()
begin
	select t.name as tutor, count(c.name) as total
	  from tutors t left join courses c 
	    on t.tutor_id = c.tutor_id
	 group by t.tutor_id;
end$$
delimiter ;

call course_total_group();


