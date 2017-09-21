--���ݿ�汾:SQL server 2008 R2;
--�û���:sa;
--����:123456;

--ҩƷ��
Create table Drug(
    drugname       varchar(20)  not null,        --ҩƷ����
    drugnumber     char(5)      not null,        --ҩƷ���
    type           varchar(10),                  --����
    unit           varchar(10),                  --��λ
    placeoforigin  varchar(40),                  --����
    primary key(drugnumber)
);

Drop table Drug;

--��Ӧ�̱�
create table provite_employer(
    supplier       varchar(20),                  --��������
    sup_number     char(5),                      --��Ӧ�̱��
    sup_phone      varchar(11),                  --�绰
    sup_address    varchar(50),                  --��ַ
    primary key(sup_number)
);

Drop table provite_employer ;

--�ɹ���
create table Purchase(
    pdrugname       varchar(20)  not null,
    pdrugnumber     char(5)      not null,
    type           varchar(10),
    unit           varchar(10),
    spec           varchar(10),                  --����
    bought         numeric(5,2) not null,        --�����
    boughtnumber   char(10),                     --��������
    boughtdate     datetime,                     --��������
    supplier       varchar(20),                  --������
    placeoforigin  varchar(40),
    totalprice     numeric(10,2),                --�ܼ�
    foreign key(pdrugnumber)       references Drug(drugnumber),
    primary key(pdrugnumber,boughtdate,supplier) 
);

Drop table Purchase ;

--�ɹ�����
create table Purchase_order(
    pdrugname       varchar(20)  not null,
    pdrugnumber     char(5)      not null,
    type           varchar(10),
    unit           varchar(10),
    spec           varchar(10),                  --����
    bought         numeric(5,2) not null,        --�����
    boughtnumber   char(10),                     --��������
    boughtdate     datetime,                     --Ԥ������
    supplier       varchar(20),                  --������
    placeoforigin  varchar(40),
    totalprice     numeric(10,2),                --�ܼ�
    foreign key(pdrugnumber)       references Drug(drugnumber),
    primary key(pdrugnumber,boughtdate,supplier)
);

Drop table Purchase_order ;

