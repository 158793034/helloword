DROP DATABASE IF EXISTS school;
CREATE DATABASE school;
USE school;
-- 讲师信息
CREATE TABLE teacher(
 tid INT PRIMARY KEY AUTO_INCREMENT,-- 主键编号
 tname VARCHAR(30) NOT NULL,-- 姓名
 tage INT CHECK(tage BETWEEN 30 AND 80)-- 年龄
);

INSERT INTO teacher(tname,tage)VALUES('孔子',30),  
				      ('孟子',32),
				      ('庄子',33),
				      ('居里夫人',45),
				      ('迈克乔丹',42),
				      ('刘欢',34);

--  班级信息
CREATE TABLE classinfo(
clid VARCHAR(20) PRIMARY KEY,-- 主键
clname VARCHAR(50) UNIQUE NOT NULL,-- 姓名
clbegindate DATE NOT NULL,-- 开学日期
clenddate DATE NOT NULL-- 毕业日期
);

INSERT INTO classinfo(clid,clname,clbegindate,clenddate)VALUES
					('cl_1','计算机应用1班','2012-9-2','2015-7-1'),
					('cl_2','计算机应用2班','2012-9-2','2015-7-1'),
					('cl_3','计算机应用3班','2012-9-2','2015-7-1'),
					('cl_4','计算机应用4班','2012-9-2','2015-7-1');
-- 学生信息					
CREATE TABLE student(
stid VARCHAR(30) PRIMARY KEY,-- 学号
stname VARCHAR(50)NOT NULL,-- 姓名
stbirthday DATE NOT NULL,-- 生日
stsex INT CHECK(stsex=1 OR stsex=2),-- 性别
clid VARCHAR(20) NOT NULL -- 所在班级

);
   
 INSERT INTO student(stid,stname,stbirthday,stsex,clid)VALUES
						('st_1','tom','1993-3-12',1,'cl_1'),
						('st_2','mary','1995-3-9',2,'cl_1'),
						('st_3','lili','1992-4-9',1,'cl_1'),
						('st_4','wngwu','1994-6-9',2,'cl_1'),
						('st_5','赵六','1995-7-9',1,'cl_1'),
						('st_6','郭靖','1992-9-9',2,'cl_2'),
						('st_7','黄蓉','1991-7-9',1,'cl_2'),
						('st_8','里胡','1994-6-9',2,'cl_2'),
						('st_9','任盈盈','1995-6-9',1,'cl_3'),
						('st_10','杨过','1969-3-9',2,'cl_3'),
						('st_11','小龙女','1996-3-9',1,'cl_3'),
						('st_12','张无忌','1997-3-9',2,'cl_3'),
						('st_13','赵梦','1994-6-9',1,'cl_4'),
						('st_14','偶哈哈','1992-5-9',2,'cl_4'),
						('st_15','hengqi','1995-4-9',1,'cl_4'),
						('st_16','shuba','1996-3-9',2,'cl_4');	

--  学生证信息
CREATE TABLE studentcard(
 stid VARCHAR(30) PRIMARY KEY ,-- 主键
 carddate DATE NOT NULL,-- 发证日期
 cardbg INT DEFAULT 1 CHECK(cardbg>=1 ),-- 发证次数
FOREIGN KEY (stid) REFERENCES student (stid)
);

INSERT INTO studentcard(stid,carddate,cardbg)VALUES
			('st_1','2012-9-10',1)	,
			('st_2','2012-9-10',1)	,
			('st_3','2012-9-10',1)	,
			('st_4','2012-9-10',1)	,
			('st_5','2012-9-10',1)	,
			('st_6','2012-9-10',1)	,
			('st_7','2012-9-10',1)	,
			('st_8','2012-9-10',1)	,
			('st_9','2012-9-10',1)	,
			('st_10','2012-9-10',1),	
			('st_11','2012-9-10',1),	
			('st_12','2012-9-10',1),	
			('st_13','2012-9-10',1),	
			('st_14','2012-9-10',1),	
			('st_15','2012-9-10',1),				
			('st_16','2012-9-10',1);
-- 课程信息
CREATE TABLE subjectinfo(
subid INT PRIMARY KEY AUTO_INCREMENT,-- 主键
subname VARCHAR(20) UNIQUE NOT NULL-- 名称
);
INSERT INTO subjectinfo(subname)VALUES
				('计算机基础'),
				('java'),
				('数据库'),
				('WEB基础'),
				('高等数学');
-- 学生选课信息
CREATE TABLE studentandsubject(
stid VARCHAR(30)NOT NULL,-- 学号
subid INT NOT NULL,-- 课程编号
 PRIMARY KEY (stid,subid),
 FOREIGN KEY (stid) REFERENCES student(stid),
FOREIGN KEY (subid) REFERENCES subjectinfo(subid)
);
INSERT INTO studentandsubject(stid,subid)VALUES
('st_1',1),('st_1',2),('st_1',3),
('st_2',1),('st_2',2),('st_2',3),('st_2',4),('st_2',5),
('st_3',1),('st_3',2),
('st_4',1),('st_4',2),('st_4',3),('st_4',4),('st_4',5),
('st_5',1),('st_5',2),('st_5',3),('st_5',4),
('st_6',1),('st_6',2),
('st_7',1),('st_7',2),('st_7',3),('st_7',4),('st_7',5),
('st_8',1),('st_8',2),('st_8',3),('st_8',4),('st_8',5),
('st_9',1),('st_9',2),('st_9',3),
('st_10',1),
('st_11',1),('st_11',2),('st_11',3),('st_11',4),('st_11',5),
('st_12',1),('st_12',2),('st_12',3),('st_12',4),('st_12',5),
('st_13',1),('st_13',2),('st_13',3),
('st_14',1),('st_14',2),('st_14',3),('st_14',4),('st_14',5),
('st_15',1),('st_15',2),
('st_16',1),('st_16',2);
-- 系统用户表
create table userinfo(
uid int primary key auto_increment, -- 主键
logname varchar(20) not null unique,  -- 用户名
keyword varchar(20)not null   -- 密码
);

insert into userinfo(logname,keyword)values('tom','66666');
insert into userinfo(logname,keyword)values('mary','77777');
insert into userinfo(logname,keyword)values('jarry','99999');



-- 登陆系统日志表
create table userloginfo(
logid int primary key auto_increment, -- 主键
uid int not null,-- 操作用户
logdate date not null,-- 登陆时间
logtype int check(logtype=1 or logtype=0),-- 登陆种类 登陆和下线  1和0
FOREIGN KEY (uid) REFERENCES userinfo(uid)
);

select * from userloginfo;