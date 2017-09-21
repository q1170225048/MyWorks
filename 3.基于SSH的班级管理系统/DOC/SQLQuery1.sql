--ClassManagement班级管理系统
--数据库:SQLServer2008R2
--高开拓 20142942

--班级表
create table classunit(
    class_number     nvarchar(50),    --班级编号
    class_name       nvarchar(50),    --班级名称
    primary key(class_number)
)
drop table classunit;

--课程表
create table course(
    course_number    nvarchar(50),    --课程编号
    course_name      nvarchar(50),    --课程名称
    course_type      nvarchar(50),    --课程性质
    course_grade     nvarchar(50),    --分数
    primary key(course_number)
)
drop table course;

--学生表
create table student(
    student_number   nvarchar(50),    --学号
    student_name     nvarchar(50),    --姓名
    student_gender   nvarchar(50),    --性别
    student_birth    nvarchar(50),    --出生日期
    student_possward nvarchar(50),    --密码
    student_phone    nvarchar(50),    --联系电话
    student_address  nvarchar(50),    --家庭住址
    student_classnumber     nvarchar(50),    --班级编号
    primary key(student_number),
    foreign key(student_classnumber) references classunit(class_number)
)
drop table student;

--成绩表
create table grade(
    grade_studentnumber nvarchar(50), --学号
    grade_coursenumber  nvarchar(50), --课程编号
    grade_grade         nvarchar(50), --成绩
    primary key(grade_studentnumber,grade_coursenumber),
    foreign key(grade_studentnumber) references student(student_number),
    foreign key(grade_coursenumber) references course(course_number)
)
drop table grade;