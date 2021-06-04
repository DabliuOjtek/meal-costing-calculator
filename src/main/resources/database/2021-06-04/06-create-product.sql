--liquibase formatted sql
--changeset dabliuojtek:1
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[product](
    [product_id] [int] IDENTITY(1,1) NOT NULL,
    [name] [varchar](50) NOT NULL,
    [amount_in_grams] [int] NOT NULL,
    [price] [decimal](10, 2) NOT NULL,
    CONSTRAINT [PK__product__47027DF581626119] PRIMARY KEY CLUSTERED
(
[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

