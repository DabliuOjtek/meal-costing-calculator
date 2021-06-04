--liquibase formatted sql
--changeset dabliuojtek:1
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[meal](
    [meal_id] [int] IDENTITY(1,1) NOT NULL,
    [name] [varchar](50) NOT NULL,
    [meal_plan_id] [int] NULL,
    [cost] [decimal](10, 2) NULL,
    CONSTRAINT [PK__meal__2910B00F81A276C0] PRIMARY KEY CLUSTERED
(
[meal_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [dbo].[meal]  WITH CHECK ADD  CONSTRAINT [FK_meal_meal_plan] FOREIGN KEY([meal_plan_id])
    REFERENCES [dbo].[meal_plan] ([meal_plan_id])
    ON DELETE SET NULL

ALTER TABLE [dbo].[meal] CHECK CONSTRAINT [FK_meal_meal_plan]
