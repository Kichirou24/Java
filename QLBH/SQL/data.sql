USE [QLBH]
GO
/****** Object:  Table [dbo].[Hang]    Script Date: 03/04/2024 10:33:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hang](
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
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh1', N'Tam tre', CAST(N'2024-04-03 00:00:00.000' AS DateTime), 1000, 5.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh10', N'Vay', CAST(N'2024-10-10 00:00:00.000' AS DateTime), 200, 300.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh2', N'Chan bong', CAST(N'2024-03-03 00:00:00.000' AS DateTime), 100, 1500.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh3', N'Nuoc hoa', CAST(N'2024-02-02 00:00:00.000' AS DateTime), 150, 1200.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh4', N'Sua tuoi', CAST(N'2024-01-01 00:00:00.000' AS DateTime), 200, 50.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh5', N'Sua bot', CAST(N'2024-05-05 00:00:00.000' AS DateTime), 200, 100.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh6', N'Mi tom', CAST(N'2024-06-06 00:00:00.000' AS DateTime), 500, 6.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh7', N'Xa phong', CAST(N'2024-07-07 00:00:00.000' AS DateTime), 300, 15.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh8', N'Ao nam', CAST(N'2024-08-08 00:00:00.000' AS DateTime), 400, 80.0000)
INSERT [dbo].[Hang] ([mahang], [tenhang], [ngaynhaphang], [soluong], [gia]) VALUES (N'mh9', N'Quan', CAST(N'2024-09-09 00:00:00.000' AS DateTime), 300, 200.0000)
