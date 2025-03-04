USE [Nhom2]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 03/04/2024 11:57:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[manv] [nvarchar](50) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[gioitinh] [bit] NULL,
	[ngaysinh] [datetime] NULL,
	[hsl] [float] NULL,
	[email] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv1', N'Hoàng Bảo Khánh', 1, CAST(N'2004-11-15 00:00:00.000' AS DateTime), 3.4, N'Hbkhanh0706@gmail.com', N'0911544246')
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv2', N'Lê Nguyễn Gia Hân', 0, CAST(N'2004-11-15 00:00:00.000' AS DateTime), 3, N'lenguyengiahan@gmail.com', N'123455667')
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv3', N'Nguyễn Khánh Linh', 0, CAST(N'2004-11-15 00:00:00.000' AS DateTime), 3, N'lenguyengiahan@gmail.com', N'1234556789')
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv5', N'Bạch Thị Thiện Thanh', 0, CAST(N'2004-11-15 00:00:00.000' AS DateTime), 1, N'lenguyengiahan@gmail.com', NULL)
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv6', N'Hoàng Bảo Khoa', 1, CAST(N'2004-11-15 00:00:00.000' AS DateTime), 2, N'hbkhoa1511@gmail.com', N'090520677')
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv8', N'Truong Dinh Phuc', 0, CAST(N'2005-04-24 00:00:00.000' AS DateTime), 4, N'mrphuc244@gmail.com', N'0339592404')
