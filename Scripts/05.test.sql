select * from addresses;
select * from students;
select * from tutors;
select * from courses;
select * from course_enrollment;

/* StudentMapper 작성 */

/* select */
select stud_id, name, email, phone, dob from students where stud_id = 1;
select stud_id, name, email, substring(phone, 1, 3) as f, substring(phone, 5, 3) as m, substring(phone, 9, 4) as l, dob from students where stud_id = 1;

/* insert */
insert into students(stud_id, name, email, phone, dob)
values(3, 'Surin', 'jeon@test.co.kr', '123-123-1234', '1995-11-01');
/* delete */
delete 
  from students
 where stud_id = 3;
 
/* update */
update students set st