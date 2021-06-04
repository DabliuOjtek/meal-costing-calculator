--liquibase formatted sql
--changeset dabliuojtek:1
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[meal_plan](
    [meal_plan_id] [int] IDENTITY(1,1) NOT NULL,
    [date] [date] NOT NULL,
    [cost] [decimal](10, 2) NOT NULL,
    [user_id] [int] NOT NULL,
    CONSTRAINT [PK__meal_pla__05C576075B7E525B] PRIMARY KEY CLUSTERED
(
[meal_plan_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    CONSTRAINT [IX_meal_plan] UNIQUE NONCLUSTERED
(
[date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [dbo].[meal_plan]  WITH CHECK ADD  CONSTRAINT [fk_user_id] FOREIGN KEY([user_id])
    REFERENCES [dbo].[user] ([user_id])

ALTER TABLE [dbo].[meal_plan] CHECK CONSTRAINT [fk_user_id]
