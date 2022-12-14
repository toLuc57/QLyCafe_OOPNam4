CREATE DATABASE TheCoffee
go
use TheCoffee
go

create table NhanVien (
  MaNhanVien char(10) not null primary key,
  HoTen nvarchar(50),
  NgaySinh date,
  DiaChi nvarchar(100),
  SDT char(12),
  Matkhau char(30),
  isAdmin bit
)
go

create table Ban(
  SoBan int identity(1,1) not null primary key,
  LoaiBan nvarchar(20),
  TinhTrang int default 0,
  -- 0.Trống
  -- 1.Có
  -- 2.Đặt
  SoGhe int
)
go

create table CaLamViec(
  MaCa int identity(1,1) not null primary key,
  TenCa nvarchar(20),
  ThoiGianBatDau time,
  ThoiGianKetThuc time,
  TongThoiGian int
)
go



go

create table SanPhamTho(
  MaSanPham int identity(1,1) not null primary key,
  TenSanPham nvarchar(50),
  SoLuong float,
  DonViTinh Char(10),
  GiaTien money
)
go

create table NhaCungCap(
  MaNhaCungCap int identity(1,1) not null primary key,
  TenNhaCungCap nvarchar(50),
  DiaChi nvarchar(100),
  SDT char(10)
)
go

create table PhieuNhap(
  SoPhieuNhap int identity(1,1) not null primary key,
  NgayNhap datetime,
  MaNhanVien Char(10),
  MaNhaCungCap int,
  TongTien int,
  constraint FK_MaNhanVien foreign key (MaNhanVien) references NhanVien (MaNhanVien),
  constraint FK_MaNCC foreign key (MaNhaCungCap) references NhaCungCap (MaNhaCungCap)
)
go

create table ChiTietNhap(
  SoPhieuNhap int not null,
  MaSanPham int not null,
  SoLuong int,
  constraint PK_ChiTietNhap primary key (SoPhieuNhap,MaSanPham)
)
go

create table ThucDon(
  IDThucDon int identity(1,1) not null primary key,
  TenThucDon nvarchar(50),
  Loai nvarchar(50),
  GiaTien money,
  HinhAnh text
)
go

create table HoaDon(
  MaHoaDon int identity(1,1) not null primary key,
  MaNhanVien char(10),
  ThoiGianVao datetime,
  ThoiGianRa datetime,
  SoBan int,
  TongTien money,
  TrangThai bit,
  constraint FK_HD_MaNhanVien foreign key (MaNhanVien) references NhanVien (MaNhanVien),
  constraint FK_SoBan foreign key (SoBan) references Ban (SoBan)
)
go

create table ChiTietHoaDon(
  MaHoaDon int not null,
  IDThucDon int not null,
  SoLuong int,
  constraint PK_CTHD primary key (MaHoaDon,IDThucDon)
)
go

create table PhuThu(
  MaPhuThu int identity(1,1) not null primary key,
  TenPhi nvarchar(50),
  SoTien money
)
go

create table ChiTietPhuThu(
  MaHoaDon int not null,
  MaPhuThu int not null,
  primary key(MaHoaDon,MaPhuThu)
)