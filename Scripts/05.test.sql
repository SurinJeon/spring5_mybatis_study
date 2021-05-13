select * from addresses;
select * from students;
select * from tutors;
select * from courses;
select * from course_enrollment;

select * from user_pics; /* p132 때문에 추가 */

/* StudentMapper 작성 */

/* select */
select stud_id, name, email, phone, dob from students where stud_id = 1;
select stud_id, name, email, substring(phone, 1, 3) as f, substring(phone, 5, 3) as m, substring(phone, 9, 4) as l, dob from students where stud_id = 1;

/* address join select */
select stud_id, name, email, phone, dob, /* 학생 테이블 */
	   a.addr_id, street, city, state, zip, country /* 주소 테이블 */
  from students s join addresses a on s.addr_id = a.addr_id 
 where stud_id = 1;

/* Tutor left outer join Course */
select t.tutor_id, t.name as tutor_name, email, c.course_id , c.name , description, start_date, end_date
  from tutors t join courses c on t.tutor_id = c.tutor_id 
 where t.tutor_id = 1;
/* where절이 들어갔기 때문에 목록이 아니라서 굳이 left outer 하지않아도 됨 */
 

delete from students where stud_id > 2;
delete from user_pics where id = 2;
update students set name = 'Timothy' where stud_id = 1;

select stud_id, name, email, phone, dob from students WHERE name = 'Timothy' AND email = 'timothy@gmail.com'

/* p160 if 조건 << 이 모든걸 하나의 sql문으로 하자! */
select course_id, name, description, start_date, end_date, tutor_id
  from courses
 where course_id = 1;
 
select course_id, name, description, start_date, end_date, tutor_id
  from courses
 where name like '%JAVA%';
 
select course_id, name, description, start_date, end_date, tutor_id
  from courses
 where tutor_id = 1;
 
select course_id, name, description, start_date, end_date, tutor_id
  from courses
 where start_date >= '20130201';
 
select course_id, name, description, start_date, end_date, tutor_id
  from courses
 where end_date <= '20130830';
 
select course_id, name, description, start_date, end_date, tutor_id
  from courses
 where start_date >= '20130201' and end_date <= '20130830';
 
select course_id, name, description, start_date, end_date, tutor_id from courses;

update courses set name = 'Javascript' where course_id = 4;