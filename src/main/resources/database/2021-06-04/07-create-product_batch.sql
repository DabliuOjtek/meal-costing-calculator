--liquibase formatted sql
--changeset dabliuojtek:1
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[product_batch](
    [product_batch_id] [int] IDENTITY(1,1) NOT NULL,
    [name] [varchar](50) NOT NULL,
    [amount_in_grams] [decimal](10, 3) NOT NULL,
    [cost] [decimal](10, 2) NULL,
    [product_id] [int] NULL,
    [meal_id] [int] NULL,
    CONSTRAINT [PK__product___45656F173638ACA2] PRIMARY KEY CLUSTERED
(
[product_batch_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

ALTER TABLE [dbo].[product_batch]  WITH CHECK ADD  CONSTRAINT [FK_product_batch_meal] FOREIGN KEY([meal_id])
    REFERENCES [dbo].[meal] ([meal_id])
    ON DELETE SET NULL

ALTER TABLE [dbo].[product_batch] CHECK CONSTRAINT [FK_product_batch_meal]

ALTER TABLE [dbo].[product_batch]  WITH CHECK ADD  CONSTRAINT [FK_product_batch_product1] FOREIGN KEY([product_id])
    REFERENCES [dbo].[product] ([product_id])
    ON DELETE SET NULL

ALTER TABLE [dbo].[product_batch] CHECK CONSTRAINT [FK_product_batch_product1]
