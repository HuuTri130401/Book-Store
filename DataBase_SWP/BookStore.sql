/*use master
create database BookStoreManagement
use BookStoreManagement*/

create table Employee(
	employee_Id int primary key identity(1,1),
	account_Id varchar(15) not null,
	password varchar(300) not null,
	fullName nvarchar(50) not null,
	phone varchar(50) not null,
	address nvarchar(20) not null,
	gender varchar(20) not null,
	role varchar(20) not null,
	status_Employee bit not null
)

create table Category(
	category_Id int primary key identity(1,1),
	category_Name varchar(50) not null
)

create table Book(
	book_Id int primary key identity(1,1),
	name_Book nvarchar(150) not null,
	author_Book nvarchar(30) not null,
	year_Of_Public int,
	category int references Category(category_Id),
	price_Book float not null,
	quantity_Book int not null,
	image varchar(100) not null,
	description_Book nvarchar(2000),
	status_Book bit
)

create table BookingRequest(
request_Id int primary key identity(1,1),
image varchar(100) not null,
name_Book nvarchar(150) not null,
quantity_Request int not null,
price_Request float not null,
date_Request date not null,
date_Request_Done date,
note nvarchar(400),
status int,
status_Book_Request bit
)

create table Importation(
	import_Id int primary key identity(1,1),
	employee_Id int references Employee(employee_Id),
	date_Import date not null,
	request_id int references BookingRequest(request_Id)
)

create table ImportationDetail(
	import_Detail_Id int primary key identity(1,1),
	import_Id int references Importation(import_Id),
	book_Id int references Book(book_Id),
	quantity_Import_Detail int,
	price_Import_Detail float not null,
	total_Import_Detail float not null,
	note nvarchar(400),
	status bit
)

create table Inventory(
inventory_Id int primary key identity(1,1),
employee_Id int references Employee(employee_Id),
date_Into_Inventory date not null
)

create table InventoryDetail(
inventory_Detail_Id int primary key identity(1,1),
inventory_Id int references Inventory(inventory_Id),
book_Id int references Book(book_Id),
quantity_Inventory int not null,
note nvarchar(300),
status bit
)

create table [Order](
order_Id int primary key identity(1,1),
employee_Id int references Employee(employee_Id),
date_To_Oder Date not null,
quantity_Order int not null,
total_Order float not null,
status bit
)

create table OrderDetail(
	order_Detail_Id int primary key identity(1,1),
	order_Id int references [Order](order_Id),
	book_Id int references Book(book_Id),
	quantity_Order_Detail int not null,
	total_Order_Detail float not null

)



/*insert into Account values ('admin','admin',N'Dương Cẩm Nhung',
0123456789,'HCM',1,'admin')

insert into Account values ('staff1','staff',N'Phan Nguyễn Quỳnh Chi',
0123456789,'HCM',1,'staff')

insert into Account values ('seller1','seller',N'Nguyễn Tuấn Vũ',
0123456789,'HCM',1,'seller')

insert into Account values ('seller2','seller',N'Trần Hữu Trí',
0123456789,'HCM',1,'seller')

/*------------*/

insert into Category values(1,'Romance')
insert into Category values(2,'Self-help')
insert into Category values(3,'Novel')
insert into Category values(4,'Fantasy')

/*------------*/

insert into Book
values (1,N'Bài Giảng Cuối Cùng','Randy Pausch',2000,
1,92000,10,'BGCC.jpg',1)

insert into Book
values (2,N'Đắc Nhân Tâm','Dale Carnegie',1936,
2,88000,15,'DNT.jpg',1)

insert into Book
values (3,N'Không Gia Đình','Hector Malot',1980,
1,110000,15,'KGD.jpg',1)

insert into Book
values (4,N'Cuốn Theo Chiều Gió','Margaret Mitchell',1978,
3,228000,8,'CTCG.jpg',1)

insert into Book
values (5,N'Lược Sử Thời Gian','Stephen Hawking',2001,
4,170000,18,'LSTG.jpg',1)

insert into Book
values (6,N'Đi Tìm Lẽ Sống','Victor Frankl',1988,
2,78000,17,'DTLS.jpg',1)

insert into Book
values (7,N'Cuộc đời của Pi','Yann Martel',1993,
2,78000,15,'CDCP.jpg',1)

insert into Book
values (8,N'Vũ Trụ','Carl Sagan',1990,
4,126000,6,'VT.jpg',1)

insert into Book
values (9,N'Đọc Vị Bất Kỳ Ai','Lieberman',1995,
2,80000,11,'DVBKA.jpg',1)
*/

