
/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     09/06/2020 8:59:01 CH                        */
/*==============================================================*/


alter table CHUONG_TRINH
   drop constraint FK_CT_CC;

alter table KQHT
   drop constraint FK_KQHT_KH;

alter table KQHT
   drop constraint FK_KQHT_LOP;

alter table LOP
   drop constraint FK_LOP_NV;

alter table LOP
   drop constraint FK_LOP_CT;

drop table CHUNG_CHI cascade constraints;

drop index THUOC_CHUNG_CHI_FK;

drop table CHUONG_TRINH cascade constraints;

drop table KHACH_HANG cascade constraints;

drop index KQHT2_FK;

drop index KQHT_FK;

drop table KQHT cascade constraints;

drop index PHU_TRACH_FK;

drop index THUOC_FK;

drop table LOP cascade constraints;

drop table NHAN_VIEN cascade constraints;

/*==============================================================*/
/* Table: NHAN_VIEN                                             */
/*==============================================================*/
create table NHAN_VIEN 
(
   MA_NV                NUMBER(38)           not null,
   HO_TEN               VARCHAR2(100)        not null,
   SDT                  VARCHAR2(20),
   LOAI                 NUMBER(1),
   TEN_DANG_NHAP        VARCHAR2(100),
   MAT_KHAU             VARCHAR2(100),
   constraint PK_NHAN_VIEN primary key (MA_NV)
);
--sequence
create sequence nhan_vien_sequence
increment by 1
start with 6000;

--insert 
insert into nhan_vien values (5500, 'Trần Xuân Lộc', '035 854 9635', 1, 'quanly1', '1234');
insert into nhan_vien values (5501, 'Lê Thị Thảo', '035 854 9635', 2, 'ghidanh1', '1234');
insert into nhan_vien values (5502, 'Trần Minh Nguyên', '035 854 9635', 2, 'ghidanh2', '1234');
insert into nhan_vien values (5503, 'Trần Xuân Diệu', '035 854 9635', 3, 'hocvu1', '1234');
insert into nhan_vien values (5504, 'Ngô Minh Hoàng', '035 854 9635', 3, 'hocvu2', '1234');
insert into nhan_vien values (5505, 'Trần Xuân Diệu', '035 854 9635', 3, 'hocvu1', '1234');

/*==============================================================*/
/* Table: CHUNG_CHI                                             */
/*==============================================================*/
create table CHUNG_CHI 
(
   MA_CHUNG_CHI         NUMBER(38)           not null,
   TEN_CHUNG_CHI        VARCHAR2(100)        not null,
   NOI_DUNG             VARCHAR2(1000),
   DIEM_TOI_DA			NUMBER(4,1),
   SRC_IMG              VARCHAR2(100)
   constraint PK_CHUNG_CHI primary key (MA_CHUNG_CHI)
);

--Sequenct: CHUNG_CHI
create sequence chung_chi_sequence
increment by 1
start with 100;

--Insert: CHUNG_CHI
insert into CHUNG_CHI values (90, "IELTS", "The International English Language Testing System", 9.0);
insert into CHUNG_CHI values (91, "TOEIC LR", "Test of English for International Communication", 990);
insert into CHUNG_CHI values (92, "CAMBRIDGE", "Cambridge Assessment English", 230);

/*==============================================================*/
/* Table: CHUONG_TRINH                                          */
/*==============================================================*/
create table CHUONG_TRINH 
(
   MA_CT                NUMBER(38)           not null,
   MA_CHUNG_CHI         NUMBER(38)           not null,
   TEN_CT               VARCHAR2(100)        not null,
   DIEM_DAU_VAO         NUMBER(4,1)          not null,
   DIEM_DAU_RA          NUMBER(4,1)          not null,
   NOI_DUNG             VARCHAR2(1000),
   TRANG_THAI           NUMBER(1,0),
   TINH_DIEM_NGHE       NUMBER(1,0),
   TINH_DIEM_NOI       NUMBER(1,0),
   TINH_DIEM_DOC       NUMBER(1,0),
   TINH_DIEM_VIET       NUMBER(1,0),
   CACH_TINH_DIEM       NUMBER(1,0),
   constraint PK_CHUONG_TRINH primary key (MA_CT)
);

--sequence
create sequence chuong_trinh_sequence
increment by 1
start with 200

--insert
insert into chuong_trinh values (150, 92, "Starters", 0, 100, "CAMBRIDGE: dành cho thí sinh từ 4 - 7 tuổi", 1);
insert into chuong_trinh values (151, 92, "Movers", 100, 120, "CAMBRIDGE: dành cho thí sinh từ 8 - 10 tuổi", 1);
insert into chuong_trinh values (152, 92, "Flyers", 120, 140, "CAMBRIDGE: dành cho thí sinh từ 11 - 12 tuổi", 1);
insert into chuong_trinh values (153, 92, "KET", 140, 160, "CAMBRIDGE: Chứng chỉ tiếng Anh dành cho thiếu niên và người lớn", 1);
insert into chuong_trinh values (154, 92, "PET", 160, 180, "CAMBRIDGE: Chứng chỉ tiếng Anh dành cho người ở trình độ Sơ Trung Cấp", 1);
insert into chuong_trinh values (160, 91, "TOEIC LR 250", 0, 250, "TOEIC: LISTENING - READING 250", 1);
insert into chuong_trinh values (161, 91, "TOEIC LR 500", 250, 500, "TOEIC: LISTENING - READING 500", 1);
insert into chuong_trinh values (162, 91, "TOEIC LR 700", 500, 700, "TOEIC: LISTENING - READING 700", 1);
insert into chuong_trinh values (163, 91, "TOEIC LR 900", 700, 900, "TOEIC: LISTENING - READING 900", 1);
insert into chuong_trinh values (170, 90, "IELTS 4.0", 0, 4.0, "IELTS: 4.0", 1);
insert into chuong_trinh values (171, 90, "IELTS 6.0", 4.0, 6.0, "IELTS: 6.0", 1);
insert into chuong_trinh values (172, 90, "IELTS 7.0", 6.0, 7.0, "IELTS: 7.0", 1);
insert into chuong_trinh values (173, 90, "IELTS 8.0", 7.0, 8.0, "IELTS: 8.0", 1);

/*==============================================================*/
/* Index: THUOC_CHUNG_CHI_FK                                    */
/*==============================================================*/
create index THUOC_CHUNG_CHI_FK on CHUONG_TRINH (
   MA_CHUNG_CHI ASC
);

/*==============================================================*/
/* Table: KHACH_HANG                                            */
/*==============================================================*/
create table KHACH_HANG 
(
   MA_KH                NUMBER(38)           not null,
   HO_TEN               VARCHAR2(100)        not null,
   NGAYSINH_            DATE,
   GIOI_TINH            NUMBER(1),
   DIA_CHI              VARCHAR2(100),
   SDT                  VARCHAR2(20),
   DIEM_DAU_VAO         NUMBER(4,1),
   CHUNG_CHI_CAN_HOC    NUMBER(38),
   LOP_DANG_HOC         NUMBER(38),
   constraint PK_KHACH_HANG primary key (MA_KH)
);
--sequence
create sequence khach_hang_sequence
increment by 1
start with 5000

--insert
insert into khach_hang values (4100, "Trần Thị Thanh", to_date('11/10/1995', 'DD/MM/YYYY'), 2, "TP.HCM", "090 524 9631", 2.5, 90, null);
insert into khach_hang values (4101, "Trần Văn Tùng", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 3.0, 90, null);
insert into khach_hang values (4102, "Trần Văn Bé", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 4.0, 90, null);
insert into khach_hang values (4103, "Trần Thị Dậu", to_date('11/10/1995', 'DD/MM/YYYY'), 2, "TP.HCM", "090 524 9631", 4.5, 90, null);
insert into khach_hang values (4104, "Trần Xuân Mai", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 5.0, 90, null);
insert into khach_hang values (4105, "Trần Xuân Hùng", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 5.5, 90, null);
insert into khach_hang values (4106, "Nguyễn Tiến Đạt", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 6.0, 90, null);
insert into khach_hang values (4107, "Nguyễn Cao Vũ", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 6.5, 90, null);
insert into khach_hang values (4108, "Nguyễn Xuân Phú", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 7.0, 90, null);
insert into khach_hang values (4109, "Nguyễn Trần Tiến", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 5.0, 90, null);
insert into khach_hang values (4110, "Nguyễn Thu Trang", to_date('11/10/1995', 'DD/MM/YYYY'), 1, "TP.HCM", "090 524 9631", 8.0, 90, null);

insert into khach_hang values (4200, "Lê Bá Nhật", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Hà Nội", "090 524 9631", 150, 91, null);
insert into khach_hang values (4201, "Lê Thảo Nguyên", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Hà Nội", "090 524 9631", 200, 91, null);
insert into khach_hang values (4202, "Lê Bá Thông", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Hà Nội", "090 524 9631", 250, 91, null);
insert into khach_hang values (4203, "Lê Bá Tuấn", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Hà Nội", "090 524 9631", 300, 91, null);
insert into khach_hang values (4204, "Lê Hào", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Hà Nội", "090 524 9631", 350, 91, null);
insert into khach_hang values (4205, "Lê Hoàng", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Hà Nội", "090 524 9631", 400, 91, null);
insert into khach_hang values (4206, "Lê Thiện", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Hà Nội", "090 524 9631", 400, 91, null);
insert into khach_hang values (4207, "Lê Nhi", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Hà Nội", "090 524 9631", 450, 91, null);
insert into khach_hang values (4208, "Hà Thị Thu Giang", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 500, 91, null);
insert into khach_hang values (4209, "Võ Thị Hương Giang", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 550, 91, null);
insert into khach_hang values (4209, "Trần Hoài Thu", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 600, 91, null);
insert into khach_hang values (4209, "Lê Thị Mỹ Dung", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 650, 91, null);
insert into khach_hang values (4210, "Trần Thị Hoa", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 700, 91, null);
insert into khach_hang values (4211, "Trần Thị Trang", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 750, 91, null);
insert into khach_hang values (4212, "Nguyễn Thị Hồng Gấm", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đồng Nai", "090 524 9631", 800, 91, null);
insert into khach_hang values (4212, "Ngô Mỹ Uyên", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Vũng Tàu", "090 524 9631", 850, 91, null);
insert into khach_hang values (4212, "Trần Thị Nga", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Vũng Tàu", "090 524 9631", 900, 91, null);

insert into khach_hang values (4300, "Tạ Thái Thy", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 140, 92, null);
insert into khach_hang values (4301, "Nguyễn Bảo Trân", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 150, 92, null);
insert into khach_hang values (4302, "Trần Thị Hà Thu", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 155, 92, null);
insert into khach_hang values (4303, "Nguyễn Văn Đính", to_date('23/11/1996', 'DD/MM/YYYY'), 1, "Đà Nẵng", "090 524 9631", 160, 92, null);
insert into khach_hang values (4304, "Nguyễn Trần Huy", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 165, 92, null);
insert into khach_hang values (4305, "Lê Ngọc Linh", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 170, 92, null);
insert into khach_hang values (4306, "Lê Ngọc Hoa", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 130, 92, null);
insert into khach_hang values (4301, "Lê Nguyên Lợi", to_date('23/11/1996', 'DD/MM/YYYY'), 2, "Đà Nẵng", "090 524 9631", 160, 92, null);

/*==============================================================*/
/* Table: LOP                                                   */
/*==============================================================*/
create table LOP 
(
   MA_LOP               NUMBER(38)           not null,
   MA_CT                NUMBER(38)           not null,
   MA_NV                NUMBER(38)           not null,
   TEN_LOP              VARCHAR2(100)        not null,
   NGAY_BD              DATE,
   NGAY_KT              DATE,
   GV                   VARCHAR2(100),
   PHONG                VARCHAR2(100),
   TRANG_THAI           NUMBER(1),
   constraint PK_LOP primary key (MA_LOP)
);

--sequence
create sequence lop_sequence
increment by 1
start with 6000

--insert
insert into lop values (5000, 170, 5503, "IELTS 4.0 K12", to_date('01/06/2020','DD/MM/YYYY'), to_date('30/09/2020','DD/MM/YYYY'), 'Sony Ericson','A.400', 1);
insert into lop values (5001, 170, 5503, "IELTS 4.0 K13", to_date('01/06/2020','DD/MM/YYYY'), to_date('30/09/2020','DD/MM/YYYY'), 'Sony Ericson','A.401', 1);
insert into lop values (5002, 160, 5503, "TOEIC LR250 K12", to_date('09/06/2020','DD/MM/YYYY'), to_date('30/08/2020','DD/MM/YYYY'), 'Nokia Romantic','A.500', 1);
insert into lop values (5003, 161, 5503, "TOEIC LR500 K12", to_date('09/06/2020','DD/MM/YYYY'), to_date('30/08/2020','DD/MM/YYYY'), 'Xampp Apache','A.501', 1);
insert into lop values (5004, 162, 5503, "TOEIC LR700 K12", to_date('09/06/2020','DD/MM/YYYY'), to_date('30/08/2020','DD/MM/YYYY'), 'Nokia Romantic','A.500', 1);
insert into lop values (5400, 160, 5503, "TOEIC LR250 K11", to_date('15/01/2020','DD/MM/YYYY'), to_date('30/03/2020','DD/MM/YYYY'), 'Corona Teacher J','A.500', 0);
insert into lop values (5401, 160, 5503, "TOEIC LR250 K10", to_date('10/01/2020','DD/MM/YYYY'), to_date('30/03/2020','DD/MM/YYYY'), 'Corona Teacher B','A.500', 0);
insert into lop values (5402, 161, 5503, "TOEIC LR500 K9", to_date('10/03/2020','DD/MM/YYYY'), to_date('30/05/2020','DD/MM/YYYY'), 'Corona Teacher C','A.500', 0);


/*==============================================================*/
/* Index: THUOC_FK                                              */
/*==============================================================*/
create index THUOC_FK on LOP (
   MA_CT ASC
);

/*==============================================================*/
/* Table: KQHT                                                  */
/*==============================================================*/
create table KQHT 
(
   MA_KH                NUMBER(38)           not null,
   MA_LOP               NUMBER(38)           not null,
   NGHE                 NUMBER(4,1),
   NOI                  NUMBER(4,1),
   DOC                  NUMBER(4,1),
   VIET                 NUMBER(4,1),
   TONG                 NUMBER(4,1), 
   constraint PK_KQHT primary key (MA_KH, MA_LOP)
);

--insert
insert into kqht values (4207, 5400, 120, null, 150, null,  370); -- toeic 2 kỹ năng thì cộng 2 điểm thành phần
insert into kqht values (4207, 5402, 200, null, 300, null, 500); --
insert into kqht values (4208, 5400, 120, null, 160, null,  380);


/*==============================================================*/
/* Index: KQHT_FK                                               */
/*==============================================================*/
create index KQHT_FK on KQHT (
   MA_KH ASC
);

/*==============================================================*/
/* Index: KQHT2_FK                                              */
/*==============================================================*/
create index KQHT2_FK on KQHT (
   MA_LOP ASC
);



/*==============================================================*/
/* Index: PHU_TRACH_FK                                          */
/*==============================================================*/
create index PHU_TRACH_FK on LOP (
   MA_NV ASC
);


/*==============================================================*/
/* FOREIGN KEY                                         */
/*==============================================================*/
alter table CHUONG_TRINH
   add constraint FK_CT_CC foreign key (MA_CHUNG_CHI)
      references CHUNG_CHI (MA_CHUNG_CHI);

alter table KQHT
   add constraint FK_KQHT_KH foreign key (MA_KH)
      references KHACH_HANG (MA_KH);

alter table KQHT
   add constraint FK_KQHT_LOP foreign key (MA_LOP)
      references LOP (MA_LOP);

alter table LOP
   add constraint FK_LOP_NV foreign key (MA_NV)
      references NHAN_VIEN (MA_NV);

alter table LOP
   add constraint FK_LOP_CT foreign key (MA_CT)
      references CHUONG_TRINH (MA_CT);

/*==============================================================*/
/* TRIGGER: DELETE                                              */
/*==============================================================*/
--Trigger khi xóa Chứng chỉ xóa chương trình trước:
CREATE OR REPLACE TRIGGER TRIGGER_DELETE_CHUNG_CHI_DELETE_CHUONG_TRINH
	BEFORE DELETE
	ON CHUNG_CHI
	FOR EACH ROW
BEGIN
	DELETE FROM CHUONG_TRINH WHERE CHUNG_CHI.MA_CHUNG_CHI = CHUONG_TRINH.MA_CHUNG_CHI;
END;

--Trigger khi xóa chương trình xóa lớp trước:
CREATE OR REPLACE TRIGGER TRIGGER_DELETE_CHUONG_TRINH_DELETE_LOP
	BEFORE DELETE 
	ON CHUONG_TRINH
	FOR EACH ROW    
BEGIN
	DELETE FROM LOP WHERE LOP.MA_CT = :OLD.MA_CT;
END;

--Trigger khi xóa khách hàng thì xóa luôn kết quả học tập 
CREATE OR REPLACE TRIGGER TRIGGER_DELETE_KHACH_HANG_DELETE_KQHT
	BEFORE DELETE 
	ON KHACH_HANG
	FOR EACH ROW    
BEGIN
	DELETE FROM KQHT WHERE KQHT.MA_KH = :OLD.MA_KH;
END;

--Trigger khi xóa lớp thì xóa luôn kết quả học tập 
CREATE OR REPLACE TRIGGER TRIGGER_DELETE_LOP_DELETE_KQHT
	BEFORE DELETE 
	ON LOP
	FOR EACH ROW    
BEGIN
	DELETE FROM KQHT WHERE KQHT.MA_LOP = :OLD.MA_LOP;
END;

--Trigger khi xóa nhân viên xóa lớp trước:
CREATE OR REPLACE TRIGGER TRIGGER_DELETE_NHAN_VIEN_DELETE_LOP
	BEFORE DELETE 
	ON NHAN_VIEN
	FOR EACH ROW    
BEGIN
	DELETE FROM LOP WHERE LOP.MA_NV = :OLD.MA_NV;
END;




/* ***********************************************     UPDATE MỚI NGÀY :     14/06/2020  *******************************/

/*==============================================================*/
/* Table: GIAOVIEN                                              */
/*==============================================================*/
create table GIAO_VIEN 
(
   MA_GV                NUMBER(38)           not null,
   TEN_GV               VARCHAR2(100),
   QUOC_TICH            VARCHAR2(100),
   constraint PK_GIAOVIEN primary key (MA_GV)
);
--sequence
create sequence gv_sequence
increment by 1
start with 10000
--insert
insert into giao_vien values(9000, 'Alexander Rud', 'Russia');
insert into giao_vien values(9001, 'John Smith', 'American');
insert into giao_vien values(9002, 'Anna Bella', 'Philippines');
insert into giao_vien values(9003, 'Tom Cruise', 'American');

/*==============================================================*/
/* Table: PHONG                                             */
/*==============================================================*/
create table PHONG 
(
   MA_PHONG             NUMBER(38)           not null,
   TEN_PHONG            VARCHAR2(100),
   constraint PK_PHONG primary key (MA_PHONG)
);

--sequence
create sequence phong_sequence
increment by 1
start with 8000

--insert
insert into phong values (7000, 'B5');
insert into phong values (7001, 'B6');
insert into phong values (7002, 'B7');
insert into phong values (7003, 'B8');
insert into phong values (7004, 'B9');

/*=============================================================*/
/* Table: LICH_NGAY                                             */
/*==============================================================*/
create table LICH_NGAY 
(
   MA_LOP               NUMBER(38)           not null,
   MA_GV                NUMBER(38)           not null,
   MA_PHONG             NUMBER(38)           not null,
   THU                  NUMBER(1)           not null,
   GIO_BD               NUMBER(2),
   GIO_KT               NUMBER(2),
   constraint PK_LICH_NGAY primary key (MA_LOP, MA_GV, MA_PHONG, THU)
);

--insert
insert into LICH_NGAY values(5002,9000,7000,2, 8,10);
insert into LICH_NGAY values(5002,9000,7000,4, 8,10);
insert into LICH_NGAY values(5002,9000,7000,6, 8,10);
insert into LICH_NGAY values(5004,9000,7000,2, 10,12);
insert into LICH_NGAY values(5004,9001,7000,4, 10,12);
insert into LICH_NGAY values(5004,9002,7000,6, 10,12);
insert into LICH_NGAY values(5400,9003,7002,3, 19,21);
insert into LICH_NGAY values(5400,9003,7002,5, 19,21);
insert into LICH_NGAY values(5400,9003,7002,7, 19,21);
--index
create index LICH_NGAY_GV_FK on LICH_NGAY (
   MA_GV ASC
);

create index CO_LICH_NGAY_PHONG_FK on LICH_NGAY (
   MA_PHONG ASC
);

create index LICH_NGAY_FK on LICH_NGAY (
   MA_LOP ASC
);

--fk
alter table LICH_NGAY
   add constraint FK_LICH_LOP foreign key (MA_LOP)
      references LOP (MA_LOP);

alter table LICH_NGAY
   add constraint FK_LICH_GV foreign key (MA_GV)
      references GIAOVIEN (MA_GV);

alter table LICH_NGAY
   add constraint FK_LICH_PHONG foreign key (MA_PHONG)
      references PHONG (MA_PHONG);