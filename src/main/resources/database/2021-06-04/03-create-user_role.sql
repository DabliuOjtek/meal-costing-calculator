--liquibase formatted sql
--changeset dabliuojtek:1
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[user_role](
    [user_role_id] [int] IDENTITY(1,1) NOT NULL,
    [user_id] [int] NOT NULL,
    [role_id] [int] NOT NULL,
    CONSTRAINT [PK_user_role] PRIMARY KEY CLUSTERED
(
[user_role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FK_user_role_role] FOREIGN KEY([role_id])
    REFERENCES [dbo].[role] ([role_id])

ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FK_user_role_role]

ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FK_user_role_user] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user] ([user_id])

ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FK_user_role_user]
