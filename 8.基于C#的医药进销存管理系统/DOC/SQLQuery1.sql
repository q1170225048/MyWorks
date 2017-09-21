--数据库版本:SQL server 2008 R2;
--用户名:sa;
--密码:123456;

--药品表
Create table Drug(
    drugname       varchar(20)  not null,        --药品名称
    drugnumber     char(5)      not null,        --药品编号
    type           varchar(10),                  --类型
    unit           varchar(10),                  --单位
    placeoforigin  varchar(40),                  --产地
    primary key(drugnumber)
);

Drop table Drug;

--供应商表
create table provite_employer(
    supplier       varchar(20),                  --供货商名
    sup_number     char(5),                      --供应商编号
    sup_phone      varchar(11),                  --电话
    sup_address    varchar(50),                  --地址
    primary key(sup_number)
);

Drop table provite_employer ;

--采购单
create table Purchase(
    pdrugname       varchar(20)  not null,
    pdrugnumber     char(5)      not null,
    type           varchar(10),
    unit           varchar(10),
    spec           varchar(10),                  --剂量
    bought         numeric(5,2) not null,        --购入价
    boughtnumber   char(10),                     --购入数量
    boughtdate     datetime,                     --购入日期
    supplier       varchar(20),                  --供货商
    placeoforigin  varchar(40),
    totalprice     numeric(10,2),                --总价
    foreign key(pdrugnumber)       references Drug(drugnumber),
    primary key(pdrugnumber,boughtdate,supplier) 
);

Drop table Purchase ;

--采购订单
create table Purchase_order(
    pdrugname       varchar(20)  not null,
    pdrugnumber     char(5)      not null,
    type           varchar(10),
    unit           varchar(10),
    spec           varchar(10),                  --剂量
    bought         numeric(5,2) not null,        --购入价
    boughtnumber   char(10),                     --购入数量
    boughtdate     datetime,                     --预购日期
    supplier       varchar(20),                  --供货商
    placeoforigin  varchar(40),
    totalprice     numeric(10,2),                --总价
    foreign key(pdrugnumber)       references Drug(drugnumber),
    primary key(pdrugnumber,boughtdate,supplier)
);

Drop table Purchase_order ;

