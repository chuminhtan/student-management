/*==============================================================*/
/* TRIGGER                                                      */
/* Created on: 04/06/2020										*/
/*==============================================================*/

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

/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     04/06/2020 11:40:48 SA                       */
/*==============================================================*/


alter table KHACH_HANG
   drop constraint FK_LOPDANGHOC;

alter table KQHT
   drop constraint FK_KQHT_HV;

alter table KQHT
   drop constraint FK_KQHT_LOP;

alter table LOP
   drop constraint FK_LOP_NHANVIEN;

alter table LOP
   drop constraint FK_LOP_CT;

drop table CHUONG_TRINH cascade constraints;

drop index LOP_DANG_HOC_FK;

drop table KHACH_HANG cascade constraints;

drop index COBANGDIEM2_FK;

drop index COBANGDIEM_FK;

drop table KQHT cascade constraints;

drop index QUANLY_LOP_FK;

drop index THUOC_FK;

drop table LOP cascade constraints;

drop table NHAN_VIEN cascade constraints;

/*==============================================================*/
/* Table: CHUONG_TRINH                                          */
/*==============================================================*/
create table CHUONG_TRINH 
(
   MA_CT                INTEGER              not null,
   TEN_CT               VARCHAR2(50)         not null,
   CAP_DO               INTEGER              not null,
   DIEM_DAU_VAO         INTEGER              not null,
   NOI_DUNG             VARCHAR2(1000),
   constraint PK_CHUONG_TRINH primary key (MA_CT)
);

/*==============================================================*/
/* Table: KHACH_HANG                                            */
/*==============================================================*/
create table KHACH_HANG 
(
   MA_KH                INTEGER              not null,
   LOP_DANG_HOC         INTEGER              not null,
   HO_TEN               VARCHAR2(100)        not null,
   NGAYSINH_            DATE,
   GIOI_TINH            INTEGER,
   DIA_CHI              VARCHAR2(100),
   SDT                  VARCHAR2(20),
   DIEM_DAU_VAO         INTEGER,
   CAP_DO               INTEGER,
   constraint PK_KHACH_HANG primary key (MA_KH)
);

/*==============================================================*/
/* Index: LOP_DANG_HOC_FK                                       */
/*==============================================================*/
create index LOP_DANG_HOC_FK on KHACH_HANG (
   LOP_DANG_HOC ASC
);

/*==============================================================*/
/* Table: KQHT                                                  */
/*==============================================================*/
create table KQHT 
(
   MA_KH                INTEGER              not null,
   MA_LOP               INTEGER              not null,
   NGHE                 INTEGER,
   NOI                  INTEGER,
   DOC                  INTEGER,
   VIET                 INTEGER,
   DTB                  INTEGER,
   constraint PK_KQHT primary key (MA_KH, MA_LOP)
);

/*==============================================================*/
/* Index: COBANGDIEM_FK                                         */
/*==============================================================*/
create index COBANGDIEM_FK on KQHT (
   MA_KH ASC
);

/*==============================================================*/
/* Index: COBANGDIEM2_FK                                        */
/*==============================================================*/
create index COBANGDIEM2_FK on KQHT (
   MA_LOP ASC
);

/*==============================================================*/
/* Table: LOP                                                   */
/*==============================================================*/
create table LOP 
(
   MA_LOP               INTEGER              not null,
   MA_CT                INTEGER              not null,
   MA_NV                INTEGER              not null,
   TEN_LOP              VARCHAR2(100)        not null,
   NGAY_BD              DATE,
   NGAY_KT              DATE,
   SL                   INTEGER,
   GV                   VARCHAR2(100),
   PHONG                VARCHAR2(100),
   CAP_DO               INTEGER,
   constraint PK_LOP primary key (MA_LOP)
);

/*==============================================================*/
/* Index: THUOC_FK                                              */
/*==============================================================*/
create index THUOC_FK on LOP (
   MA_CT ASC
);

/*==============================================================*/
/* Index: QUANLY_LOP_FK                                         */
/*==============================================================*/
create index QUANLY_LOP_FK on LOP (
   MA_NV ASC
);

/*==============================================================*/
/* Table: NHAN_VIEN                                             */
/*==============================================================*/
create table NHAN_VIEN 
(
   MA_NV                INTEGER              not null,
   HO_TEN               VARCHAR2(100)        not null,
   SDT                  VARCHAR2(20),
   LOAI                 INTEGER              not null,
   TEN_DANG_NHAP        VARCHAR2(100)        not null,
   MAT_KHAU             VARCHAR2(100)        not null,
   constraint PK_NHAN_VIEN primary key (MA_NV)
);

alter table KHACH_HANG
   add constraint FK_LOPDANGHOC foreign key (LOP_DANG_HOC)
      references LOP (MA_LOP);

alter table KQHT
   add constraint FK_KQHT_HV foreign key (MA_KH)
      references KHACH_HANG (MA_KH);

alter table KQHT
   add constraint FK_KQHT_LOP foreign key (MA_LOP)
      references LOP (MA_LOP);

alter table LOP
   add constraint FK_LOP_NHANVIEN foreign key (MA_NV)
      references NHAN_VIEN (MA_NV);

alter table LOP
   add constraint FK_LOP_CT foreign key (MA_CT)
      references CHUONG_TRINH (MA_CT);

