CREATE DATABASE TheCoffee
use TheCoffee

create table NhanVien (
  MaNhanVien char(10) not null primary key,
  HoTen nvarchar(50),
  NgaySinh date,
  DiaChi nvarchar(50),
  SDT char(10),
  PassWordd char(50)
)

create table CaLamViec(
  MaCa int identity(1,1) not null primary key,
  TenCa nvarchar(20),
  ThoiGianBatDau time,
  ThoiGianKetThuc time,
  TongThoiGianLamViec int
)
create table NhatKyLamViec(
  MaNhanVien Char(10) references NhanVien(MaNhanVien),
  MaCa int references CaLamViec(MaCa),
  Luong money,
  primary key(MaNhanVien,MaCa)
)
create table SanPhamTho(
  MaSanPham int identity(1,1) not null primary key,
  TenSanPham nvarchar(50),
  GiaTien money,
  DonViTinh Char(10)
)
create table NhaCungCap(
  MaNhaCungCap int identity(1,1) not null primary key,
  TenNhaCungCap nvarchar(50),
  SDT char(10)
)
create table PhieuNhap(
  SoPhieuNhap int identity(1,1) not null primary key,
  NgayNhap datetime,
  MaNhanVien Char(10) references NhanVien(MaNhanVien),
  MaNhaCungCap int references NhaCungCap(MaNhaCungCap),
  TongTien int
)
create table ChiTietNhap(
  SoPhieuNhap int references PhieuNhap(SoPhieuNhap),
  MaSanPham int references SanPhamTho(MaSanPham),
  primary key(SoPhieuNhap,MaSanPham),
  SoLuong int
)
create table Ban(
  SoBan int identity(1,1) not null primary key,
  LoaiBan nvarchar(20),
  TinhTrang int default 0,
  -- 0.Trống
  -- 1.Có
  -- 2.Đặt
  SoGhe int
)
create table HoaDon(
  MaHoaDon int identity(1,1) not null primary key,
  MaNhanVien char(10) references NhanVien(MaNhanVien),
  SoBan int references Ban(SoBan)
)
create table Product(
  IDProduct int identity(1,1) not null primary key,
  NameProduct nvarchar(50),
  GiaTien money,
  LoaiSanPham nvarchar(50),
  HinhAnh text
)
create table ChiTietHoaDon(
  MaHoaDon int references HoaDon(MaHoaDon),
  IDProduct int references Product(IDProduct),
  Primary key(MaHoaDon,IDProduct)
)
create table PhuThu(
  MaPhuThu int identity(1,1) not null primary key,
  TenPhi nvarchar(50),
  SoTien money
)
create table ChiTietPhuThu(
  MaHoaDon int references HoaDon(MaHoaDon),
  MaPhuThu int references PhuThu(MaPhuThu),
  primary key(MaHoaDon,MaPhuThu)
)

insert into NhanVien (MaNhanVien,HoTen,NgaySinh,DiaChi,SDT,PassWordd) values ('NV01',N'Hà Trang','20010712',N'Bình Phước','0850045854','12345'),
                                                                             ('NV02',N'Anh Tuấn','20011209',N'Vũng Tàu','0974159357','12345'),
                                                                             ('NV03',N'Tấn Tài','20011209',N'Tây Ninh','0965258258','12345'),
                                                                             ('NV04',N'Thành Đạt','19940712',N'Tp.HCM','039125242','12345')
                                                                             
insert into CaLamViec(TenCa,ThoiGianBatDau,ThoiGianKetThuc,TongThoiGianLamViec) 
         values (N'Ca Sáng','08:00:00','12:00:00','4'),
                (N'Ca Chiều','12:00:00','17:00:00','5'),
                (N'Ca Tối','17:00:00','22:00:00','5')
              
                
insert into Ban (LoaiBan,TinhTrang,SoGhe)values        (N'Lớn',0,8),
                                                       (N'Nhỏ',0,4),
                                                       (N'Nhỏ',0,4),
                                                       (N'Lớn',0,8),
                                                       (N'Lớn',0,8),
                                                       (N'Nhỏ',0,4),
                                                       (N'Nhỏ',0,4),
                                                       (N'Lớn',0,8),
                                                       (N'Nhỏ',0,4),
                                                       (N'Lớn',0,8),
                                                       (N'Lớn',0,8)
                                                       
                                                      
insert into PhuThu (TenPhi,SoTien) values  (N'Phụ thu tết',15000),
										   (N'VAT',0.08),
										   (N'Phụ thu ca nhac',15000)

insert into Product (NameProduct,GiaTien,LoaiSanPham) values (N'Trà sữa matcha',25000,N'Trà sữa'),
                                                             (N'Trà sữa socolo',25000,N'Trà sữa'),
                                                             (N'Trà sữa lúa mạch',25000,N'Trà sữa'),
                                                             (N'Trà sữa kem cheese',25000,N'Trà sữa'),
                                                             (N'Trà sữa socola oreo phô mai',30000,N'Trà sữa'),
                                                             (N'Trà sữa kèm dừa nướng',30000,N'Trà sữa'),
                                                             (N'Trà sữa bạc hà topping',25000,N'Trà sữa'),
                                                             (N'Trà sữa dâu tây topping',25000,N'Trà sữa'),
                                                             (N'Sữa tươi trân châu đường đen',25000,N'Sữa tươi'),
                                                             (N'Sữa tươi bạc hà',20000,N'Sữa tươi'),
                                                             (N'Sữa tươi dâu tằm',25000,N'Sữa tươi'),
                                                             (N'Sữa tươi dâu tây',25000,N'Sữa tươi'),
                                                             (N'Sữa tươi việt quất',25000,N'Sữa tươi'),
                                                             (N'Sữa tươi xoài',25000,N'Sữa tươi'),
                                                             (N'Matcha latte',30000,N'Sữa tươi'),
                                                             (N'Matcha đá xay',35000,N'Đá xay & bông kem'),
                                                             (N'Cokie đá xay',35000,N'Đá xay & bông kem'),
                                                             (N'Socola oreo đá xay',35000,N'Đá xay & bông kem'),
                                                             (N'Phúc bồn tử đá xay',35000,N'Đá xay & bông kem'),
                                                             (N'Trà đào',25000,N'Trà trái cây'),
                                                             (N'Trà dâu đặc biệt',25000,N'Trà trái cây'),
                                                             (N'Trà ổi',25000,N'Trà trái cây'),
                                                             (N'Trà vải',25000,N'Trà trái cây'),
                                                             (N'Trà táo',25000,N'Trà trái cây'),
                                                             (N'Trà xoài',25000,N'Trà trái cây'),
                                                             (N'Trà dưa lưới',25000,N'Trà trái cây'),
                                                             (N'Trà trái cây nhiệt đới',25000,N'Trà trái cây'),
                                                             (N'Trà lụa đỏ mix dâu tây',25000,N'Trà trái cây'),
                                                             (N'Soda dâu',20000,N'SoDa'),
                                                             (N'Soda kiwi',20000,N'SoDa'),
                                                             (N'Soda chanh dây',20000,N'SoDa'),
                                                             (N'Soda kiwi bạc hà',25000,N'SoDa'),
                                                             (N'Soda cam',20000,N'SoDa'),
                                                             (N'Dâu tây',25000,N'YoGurt trái cây'),
                                                             (N'Dâu tằm ',25000,N'YoGurt trái cây'),
                                                             (N'Việt quất',25000,N'YoGurt trái cây'),
                                                             (N'Chanh dây',25000,N'YoGurt trái cây'),        
                                                             (N'Flan',6000,N'Topping'),
                                                             (N'Trân châu 3Q',5000,N'Topping'),
                                                             (N'Trân châu đen',5000,N'Topping'),
                                                             (N'Thạch dừa',5000,N'Topping'),
                                                             (N'Thạch đào',5000,N'Topping'),
                                                             (N'Kem cheese',10000,N'Topping'),
                                                             (N'Thạch củ năng',5000,N'Topping')
                                                         

insert into NhaCungCap (TenNhaCungCap,SDT) values (N'Cafe Di Linh','0909645932'),
                                                  (N'Trà Ngọc Trang','0952458545'),
                                                  (N'Nước Đá Anh Tiến','0303518175'),
                                                  (N'Nguyên Liệu An Nguyên','0912551039'),
                                                  (N'TNT Drink','0906702230')
																
																
  
insert into SanPhamTho (TenSanPham,GiaTien,DonViTinh) values (N'Bột Matcha Natsu',160000,'1KG'),
															 (N'Bột Cafe Di Linh',80000,'1KG'),
															 (N'Trà',8000,'70g'),
															 (N'Bột cacao',69000,'250g'),
															 (N'Sữa chua',25000,'1 lốc')


                                                      
                                                       
                                                       
                                                       