create database stocinout;
--创建角色表t_role(id,role_name)
create table t_role(
	id int(6) primary key auto_increment,
	roleName varchar(20)
);


select r1.*,r2.rightName from  t_right r1 left join t_right r2 on r1.parentId=r2.id

--给角色表插入数据
insert into t_role (roleName) values('系统管理员');
insert into t_role(roleName) values('仓库管理员');
insert into t_role(roleName) values('采购员');
insert into t_role(roleName) values('采购部经理');
--创建用户表t_user(id,user_name,real_name,password,sex,email,hiredate,role_id)
create table t_user(
	id int(6) primary key auto_increment,
	userName varchar(30),
	realName varchar(20),
	password varchar(10),
	sex char(3),
	email varchar(30),
	hiredate date,
	roleId int(6),
	constraint fk_t_user_role_id foreign key(roleId) references t_role(id)
);
--给用户添加数据
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('admin','admin','admin','男','3455552@QQ.com','2011-1-9',1);

insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('ltt','刘天田','ltt','男','344222@QQ.com','2017-9-9',2);
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('yzt','姚志通','yzt','男','34221122@QQ.com','2016-3-9',2);
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('wbw','吴博文','wbw','男','34221122@QQ.com','2016-3-9',2);

select * from t_user;
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('my','孟岩','my','男','3477722@QQ.com','2015-2-5',3);
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('wb','王斌','wb','男','34633222@QQ.com','2014-12-5',3);
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('sbt','孙博腾','sbt','男','34633222@QQ.com','2014-12-5',3);

insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('lsh','李少华','lsh','男','37852555@QQ.com','2013-11-7',4);
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('lmh','李明昊','lmh','男','3463we5@QQ.com','2013-5-2',4);
insert into t_user(userName,realName,password,sex,email,hiredate,roleId)
values('sxq','盛晓勤','sxq','女','3463we5@QQ.com','2013-5-2',4);
--创建权限表t_right(id,right_name,parent_id,right_url)
create table t_right(
	id int(6) primary key auto_increment,
	rightName varchar(30),
	parentId int(6),
	rightUrl varchar(100),
	level int(6) not null,
	constraint fk_t_right_parent_id foreign key(parentId) references t_right(id)
);
--给权限表插入数据
insert into t_right (rightName,level) values('用户管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('用户添加',1,'user/add',2);
insert into t_right (rightName,parentId,rightUrl,level) values('用户列表',1,'user/list',2);
insert into t_right (rightName,level) values('角色管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('角色添加',2,'role/add',2);
insert into t_right (rightName,parentId,rightUrl,level) values('角色列表',2,'role/list',2);
insert into t_right (rightName,level) values('权限管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('权限添加',3,'right/add',2);
insert into t_right (rightName,parentId,rightUrl,level) values('权限列表',3,'right/fenye',2);
insert into t_right (rightName,level) values('商品管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('商品添加',4,'goods/add',2);
insert into t_right (rightName,parentId,rightUrl,level) values('商品列表',4,'goods/list',2);
insert into t_right (rightName,parentId,rightUrl,level) values('统计',4,'goods/tongji',2);
insert into t_right (rightName,level) values('分类管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('分类添加',5,'category/add',2);
insert into t_right (rightName,parentId,rightUrl,level) values('分类列表',5,'category/list',2);
insert into t_right (rightName,level) values('供应商管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('供应商添加',6,'supplier/add',2);
insert into t_right (rightName,parentId,rightUrl,level) values('供应商列表',6,'supplier/list',2);
insert into t_right (rightName,level) values('入库单管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('入库单列表',7,'stockIn/list',2);
insert into t_right (rightName,parentId,rightUrl,level) values('统计',7,'stockIn/tongji',2);
insert into t_right (rightName,level) values('出库单管理',1);
insert into t_right (rightName,parentId,rightUrl,level) values('出库单列表',8,'stockOut/list',2);
insert into t_right (rightName,parentId,rightUrl,level) values('统计',8,'stockOut/tongji',2);
--创建角色权限表t_role_right(id,role_id,right_id)
create table t_role_right(
	id int(6) primary key auto_increment,
	roleId int(6),
	rightId int(6),
	constraint fk_t_role_right_role_id foreign key(roleId) references t_role(id),
	constraint fk_t_role_right_right_id foreign key(rightId) references t_right(id)
);
--关联角色和权限菜单
--系统管理员
insert into t_role_right (roleId,rightId) values(1,1);
insert into t_role_right (roleId,rightId) values(1,2);
insert into t_role_right (roleId,rightId) values(1,3);
insert into t_role_right (roleId,rightId) values(1,4);
insert into t_role_right (roleId,rightId) values(1,5);
insert into t_role_right (roleId,rightId) values(1,6);
insert into t_role_right (roleId,rightId) values(1,7);
insert into t_role_right (roleId,rightId) values(1,8);
--仓库管理员
insert into t_role_right (roleId,rightId) values(2,4);
insert into t_role_right (roleId,rightId) values(2,5);
insert into t_role_right (roleId,rightId) values(2,6);
insert into t_role_right (roleId,rightId) values(2,7);
insert into t_role_right (roleId,rightId) values(2,8);
--采购员
insert into t_role_right (roleId,rightId) values(3,4);
insert into t_role_right (roleId,rightId) values(3,5);
insert into t_role_right (roleId,rightId) values(3,6);
insert into t_role_right (roleId,rightId) values(3,7);
--采购部经理
insert into t_role_right (roleId,rightId) values(4,4);
insert into t_role_right (roleId,rightId) values(4,5);
insert into t_role_right (roleId,rightId) values(4,6);
insert into t_role_right (roleId,rightId) values(4,7);
insert into t_role_right (roleId,rightId) values(4,8);

--查询系统管理员的权限
select r.roleName,rg.rightName from t_role r,t_right rg,t_role_right rr where r.id=rr.roleId and rg.id=rr.rightId and r.id=1;
--根据父id查询子菜单
select * from t_right where parentId=4


--创建分类表t_category(id,category_name,parent_id)
create table t_category(
	id int(6) primary key auto_increment,
	categoryName varchar(30),
	parentId int(6),
	level int(6) not null,
	constraint fk_t_category_parent_id foreign key(parentId) references t_category(id)
);
select goodsName,sum(totalNum) from t_goods group by goodsName
--插入分类
insert into t_category(categoryName,level) values('电脑数码',1);
insert into t_category(categoryName,parentId,level) values('笔记本',1,2);
insert into t_category(categoryName,parentId,level) values('手机',1,2);
insert into t_category(categoryName,parentId,level) values('相机',1,2);
insert into t_category(categoryName,level) values('家用电器',1);
insert into t_category(categoryName,parentId,level) values('冰箱',5,2);
insert into t_category(categoryName,parentId,level) values('电视',5,2);
insert into t_category(categoryName,parentId,level) values('洗衣机',5,2);
--创建产品表t_goods(id,goods_name,price,total_num,category_id)
create table t_goods(
	id int(6) primary key auto_increment,
	goodsName varchar(30),
	price double, 
	totalNum int,
	categoryId int(6),	
	constraint fk_t_goods_category_id foreign key(categoryId) references t_category(id)
);
--给产品插入数据
insert into t_goods (goodsName,price,totalNum,categoryId) values('联想T420',3999,1000,3);
insert into t_goods (goodsName,price,totalNum,categoryId) values('海鸥相机',1499,500,4);
insert into t_goods (goodsName,price,totalNum,categoryId) values('海尔冰箱',4399,7000,6);
--创建供应商表t_supplier(id,supplier_name,address,mobile,user_name,phone)
create table t_supplier(
  id int primary key auto_increment,
  supplierName varchar(30),
  address varchar(100),
  mobile varchar(20),
  userName varchar(30),
  phone varchar(11),
  status char(1)
);
--给供应商插入数据
insert into t_supplier (supplierName,address,mobile,userName,phone,status) values('腾讯','深圳市高新科技园北区','075583765566','马化腾','13566666666','1');
insert into t_supplier (supplierName,address,mobile,userName,phone,status) values('百度','北京中关村','075583765566','李彦宏','13588888888','1');
insert into t_supplier (supplierName,address,mobile,userName,phone,status) values('淘宝','杭州市文二路391号西湖国际科技大厦裙楼2层','075583765566','马云','1388888888','1');
insert into t_supplier (supplierName,address,mobile,userName,phone,status) values('京东','徐汇区华山路2018号汇银广场北楼804A室','075583765566','刘强东','13466666666','1');
--创建入库单表t_stock_in(id,stock_in_name,stock_in_date,stock_in_num,goods_id,supplier_id,user_id,status)
create table t_stock_in(
	id int primary key auto_increment,
	stockInName varchar(30),
	stockInDate date,
	stockInNum int,
	goodsId int,
	supplierId int,
	userId int,
	status char(1),
	constraint fk_goods_id foreign key(goodsId) references t_goods(id),
	constraint fk_supplier_id foreign key(supplierId) references t_supplier(id)
); 
--修改入库单表结构
alter table t_stock_in add constraint fk_t_stock_in_user_id foreign key(userId) references t_user(id);
--插入数据
insert into t_stock_in values(default,'18-03-27入库单','2018-03-27',10,2,4,2,1);
--创建出库单表
create table t_stock_out(
	id int primary key auto_increment,
	stockOutName varchar(30),
	stockOutDate date,
	stockOut_num int,
	goodsId int,
	userId int,
	status char(1),
	constraint fk_goods_out_id foreign key(goodsId) references t_goods(id)
);
--修改出库单表结构
alter table t_stock_out add constraint fk_t_stock_out_user_id foreign key(userId) references t_user(id);
--插入数据
insert into t_stock_out values(default,'联想拯救者出库单','2018-03-31',10,4,2,1);





