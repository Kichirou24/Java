USE [Nhom2]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/2/2024 1:20:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[manv] [nvarchar](50) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[gioitinh] [bit] NULL,
	[ngaysinh] [date] NULL,
	[hsl] [float] NULL,
	[email] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv2', N'Le Van', 1, CAST(N'1999-10-19' AS Date), 2, N'ab@hussc.edu.vn', N'2')
GO
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv3', N'Tran Nam', 0, CAST(N'1999-10-19' AS Date), 3, N'ab@hussc.edu.vn', N'3')
GO
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv4', N'Do Chu', 0, CAST(N'1999-10-19' AS Date), 4, N'ab@hussc.edu.vn', N'4')
GO
INSERT [dbo].[NhanVien] ([manv], [hoten], [gioitinh], [ngaysinh], [hsl], [email], [phone]) VALUES (N'nv5', NULL, NULL, CAST(N'1999-10-19' AS Date), 5, N'ab@hussc.edu.vn', N'4')
GO
