

DELETE FROM [dbo].[hlt_disp_ResultTypeDisplay]

SET IDENTITY_INSERT [dbo].[hlt_disp_ResultTypeDisplay] ON 

INSERT [dbo].[hlt_disp_ResultTypeDisplay] ([disp_ResultTypeDisplayID], [x_Edition], [x_Status], [EnumName]) VALUES (0, 1, 1, N'EnumName')
INSERT [dbo].[hlt_disp_ResultTypeDisplay] ([disp_ResultTypeDisplayID], [x_Edition], [x_Status], [EnumName]) VALUES (2, 1, 1, N'row')
INSERT [dbo].[hlt_disp_ResultTypeDisplay] ([disp_ResultTypeDisplayID], [x_Edition], [x_Status], [EnumName]) VALUES (3, 1, 1, N'column')
INSERT [dbo].[hlt_disp_ResultTypeDisplay] ([disp_ResultTypeDisplayID], [x_Edition], [x_Status], [EnumName]) VALUES (4, 1, 1, N'list')
INSERT [dbo].[hlt_disp_ResultTypeDisplay] ([disp_ResultTypeDisplayID], [x_Edition], [x_Status], [EnumName]) VALUES (5, 1, 1, N'grid')
SET IDENTITY_INSERT [dbo].[hlt_disp_ResultTypeDisplay] OFF
