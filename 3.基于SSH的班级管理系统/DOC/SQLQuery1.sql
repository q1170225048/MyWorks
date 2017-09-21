--ClassManagement�༶����ϵͳ
--���ݿ�:SQLServer2008R2
--�߿��� 20142942

--�༶��
create table classunit(
    class_number     nvarchar(50),    --�༶���
    class_name       nvarchar(50),    --�༶����
    primary key(class_number)
)
drop table classunit;

--�γ̱�
create table course(
    course_number    nvarchar(50),    --�γ̱��
    course_name      nvarchar(50),    --�γ�����
    course_type      nvarchar(50),    --�γ�����
    course_grade     nvarchar(50),    --����
    primary key(course_number)
)
drop table course;

--ѧ����
create table student(
    student_number   nvarchar(50),    --ѧ��
    student_name     nvarchar(50),    --����
    student_gender   nvarchar(50),    --�Ա�
    student_birth    nvarchar(50),    --��������
    student_possward nvarchar(50),    --����
    student_phone    nvarchar(50),    --��ϵ�绰
    student_address  nvarchar(50),    --��ͥסַ
    student_classnumber     nvarchar(50),    --�༶���
    primary key(student_number),
    foreign key(student_classnumber) references classunit(class_number)
)
drop table student;

--�ɼ���
create table grade(
    grade_studentnumber nvarchar(50), --ѧ��
    grade_coursenumber  nvarchar(50), --�γ̱��
    grade_grade         nvarchar(50), --�ɼ�
    primary key(grade_studentnumber,grade_coursenumber),
    foreign key(grade_studentnumber) references student(student_number),
    foreign key(grade_coursenumber) references course(course_number)
)
drop table grade;