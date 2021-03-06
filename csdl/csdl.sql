USE [CSD-RDC]
GO
/****** Object:  Table [dbo].[Person]    Script Date: 3/19/2018 10:16:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[personId] [int] NOT NULL,
	[firstName] [varchar](30) NOT NULL,
	[middleName] [varchar](30) NOT NULL,
	[lastName] [varchar](30) NOT NULL,
	[email] [varchar](30) NOT NULL,
	[phone] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[personId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 3/19/2018 10:16:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[studentId] [int] NULL,
	[fullName] [nvarchar](max) NULL,
	[address] [nvarchar](max) NULL,
	[age] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Student] ([studentId], [fullName], [address], [age]) VALUES (1, N'ha quang trung', N'hiep hoa', 29)
INSERT [dbo].[Student] ([studentId], [fullName], [address], [age]) VALUES (2, N'ha quang viet', N'hiep hoa', 2)
