--liquibase formatted sql
--changeset dabliuojtek:1
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[token_blocklist](
    [token_blocklist_id] [int] IDENTITY(1,1) NOT NULL,
    [token] [varchar](255) NOT NULL,
    [expired_at] [date] NOT NULL,
    CONSTRAINT [PK_token_blocklist] PRIMARY KEY CLUSTERED
(
[token_blocklist_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
