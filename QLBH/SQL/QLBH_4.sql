USE [QLBH]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/9/2024 3:06:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HangHoa]    Script Date: 4/9/2024 3:06:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangHoa](
	[mahang] [nvarchar](50) NOT NULL,
	[tenhang] [nvarchar](50) NULL,
	[ngaynhaphang] [datetime] NULL,
	[soluong] [int] NULL,
	[gia] [money] NULL,
 CONSTRAINT [PK_Hang] PRIMARY KEY CLUSTERED 
(
	[mahang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/9/2024 3:06:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[mahoadon] [int] IDENTITY(1,1) NOT NULL,
	[mahang] [nvarchar](50) NULL,
	[tenhang] [nvarchar](50) NULL,
	[ngaymua] [datetime] NULL,
	[soluongmua] [int] NULL,
	[gia] [float] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[mahoadon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Account] ([username], [fullname], [password]) VALUES (N'Phuc', N'Dinh Phuc', N'123')
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh1', N'Tam tre', CAST(N'2024-04-03 00:00:00.000' AS DateTime), 262, 5000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh10', N'Ao khoac', CAST(N'2024-04-09 00:00:00.000' AS DateTime), 547, 120000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh11', N'Ao am', CAST(N'2024-03-09 00:00:00.000' AS DateTime), 129, 150000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh12', N'Sua tam', CAST(N'2024-01-02 00:00:00.000' AS DateTime), 224, 70000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh2', N'Chan bong', CAST(N'2024-03-03 00:00:00.000' AS DateTime), 1214, 1500000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh3', N'Nuoc hoa', CAST(N'2024-02-02 00:00:00.000' AS DateTime), 1234, 1200000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh4', N'Sua tuoi', CAST(N'2024-01-01 00:00:00.000' AS DateTime), 121, 50000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh5', N'Sua bot', CAST(N'2024-05-05 00:00:00.000' AS DateTime), 196, 100000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh6', N'Mi tom', CAST(N'2024-06-06 00:00:00.000' AS DateTime), 497, 6000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh7', N'Xa phong', CAST(N'2024-07-07 00:00:00.000' AS DateTime), 162, 15000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh8', N'Ao nam', CAST(N'2024-08-08 00:00:00.000' AS DateTime), 123, 80000.0000)
INSERT [dbo].[HangHoa] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh9', N'Quan', CAST(N'2024-09-09 00:00:00.000' AS DateTime), 456, 200000.0000)
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (1, N'mh10', N'Vay', CAST(N'2024-04-09 02:02:04.000' AS DateTime), 1, 300000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (2, N'mh1', N'Tam tre', CAST(N'2024-04-08 02:02:04.000' AS DateTime), 1, 5000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (3, N'mh3', N'Nuoc hoa', CAST(N'2024-04-08 02:02:25.000' AS DateTime), 23, 1200000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (4, N'mh8', N'Ao nam', CAST(N'2024-04-09 02:02:25.000' AS DateTime), 231, 80000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (5, N'mh7', N'Xa phong', CAST(N'2024-04-09 02:04:16.000' AS DateTime), 142, 15000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (6, N'mh8', N'Ao nam', CAST(N'2024-04-06 02:04:16.000' AS DateTime), 123, 80000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (7, N'mh4', N'Sua tuoi', CAST(N'2024-04-06 02:04:28.000' AS DateTime), 23, 50000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (8, N'mh5', N'Sua bot', CAST(N'2024-04-07 02:04:28.000' AS DateTime), 4, 100000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (9, N'mh6', N'Mi tom', CAST(N'2024-04-05 02:04:28.000' AS DateTime), 3, 6000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (10, N'mh4', N'Sua tuoi', CAST(N'2024-04-05 02:07:41.000' AS DateTime), 2, 50000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (11, N'mh1', N'Tam tre', CAST(N'2024-04-09 02:16:38.000' AS DateTime), 1, 5000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (12, N'mh10', N'Vay', CAST(N'2024-04-09 02:16:38.000' AS DateTime), 2, 300000)
INSERT [dbo].[HoaDon] ([mahoadon], [mahang], [tenhang], [ngaymua], [soluongmua], [gia]) VALUES (13, N'mh1', N'Tam tre', CAST(N'2024-04-09 02:23:54.000' AS DateTime), 1, 5000)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
