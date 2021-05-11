select * from addresses;
select * from students;
select * from tutors;
select * from courses;
select * from course_enrollment;

/* StudentMapper 작성 */

/* select */
select stud_id, name, email, phone, dob from students where stud_id = 1;
select stud_id, name, email, substring(phone, 1, 3) as f, substring(phone, 5, 3) as m, substring(phone, 9, 4) as l, dob from students where stud_id = 1;

/* address join select */
select stud_id, name, email, phone, dob, /* 학생 테이블 */
	   a.addr_id, street, city, state, zip, country /* 주소 테이블 */
  from students s join addresses a on s.addr_id = a.addr_id 
 where stud_id = 1;
 
