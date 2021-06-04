--liquibase formatted sql
--changeset dabliuojtek:1


SET IDENTITY_INSERT [dbo].[user] ON
INSERT [dbo].[user] ([user_id], [username], [password])VALUES (1, N'wst', N'$2a$10$cndkSyi0XBd6X8JbHXZh.u7X8Ls7DYCTZpnUJZfNAo9oFrs/WO99O')
INSERT [dbo].[user] ([user_id], [username], [password]) VALUES (2, N'test', N'$2a$10$QUlvhwKzvH65EiKlGulsN.uJEy/1j67PJOt6HBlSVnn5QTIu/./gC')
SET IDENTITY_INSERT [dbo].[user] OFF


SET IDENTITY_INSERT [dbo].[role] ON
INSERT [dbo].[role] ([role_id], [name])VALUES (1, N'USER')
SET IDENTITY_INSERT [dbo].[role] OFF


SET IDENTITY_INSERT [dbo].[user_role] ON
INSERT [dbo].[user_role] ([user_role_id], [user_id], [role_id]) VALUES (1, 1, 1)
INSERT [dbo].[user_role] ([user_role_id], [user_id], [role_id]) VALUES (2, 2, 1)
SET IDENTITY_INSERT [dbo].[user_role] OFF

SET IDENTITY_INSERT [dbo].[meal_plan] ON
INSERT [dbo].[meal_plan] ([meal_plan_id], [date], [cost], [user_id]) VALUES (1, CAST(N'2021-05-28' AS Date), CAST(6.79 AS Decimal(10, 2)), 1)
INSERT [dbo].[meal_plan] ([meal_plan_id], [date], [cost], [user_id]) VALUES (2, CAST(N'2021-06-01' AS Date), CAST(4.58 AS Decimal(10, 2)), 2)
INSERT [dbo].[meal_plan] ([meal_plan_id], [date], [cost], [user_id]) VALUES (3, CAST(N'2021-06-02' AS Date), CAST(0.00 AS Decimal(10, 2)), 2)
SET IDENTITY_INSERT [dbo].[meal_plan] OFF

SET IDENTITY_INSERT [dbo].[meal] ON
INSERT [dbo].[meal] ([meal_id], [name], [meal_plan_id], [cost]) VALUES (1, N'Kiełbasa śląska', 1, CAST(1.63 AS Decimal(10, 2)))
INSERT [dbo].[meal] ([meal_id], [name], [meal_plan_id], [cost]) VALUES (2, N'Kanapka z szynką i pomidorem', 1, CAST(5.16 AS Decimal(10, 2)))
INSERT [dbo].[meal] ([meal_id], [name], [meal_plan_id], [cost]) VALUES (3, N'Grill', 2, CAST(4.58 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[meal] OFF

SET IDENTITY_INSERT [dbo].[product] ON
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (1, N'Orzechy włoskie', 250, CAST(11.99 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (2, N'Żurawina suszona', 300, CAST(8.99 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (3, N'Migdały łuskane', 300, CAST(12.99 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (4, N'Polędwica sopocka plastry', 450, CAST(19.75 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (5, N'Bułka kajzerka', 50, CAST(0.31 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (6, N'Kartkówka grillowana', 1000, CAST(22.90 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (7, N'Pomidor gałązka', 1000, CAST(2.95 AS Decimal(10, 2)))
INSERT [dbo].[product] ([product_id], [name], [amount_in_grams], [price]) VALUES (8, N'Kiełbasa śląska', 550, CAST(9.99 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[product] OFF

SET IDENTITY_INSERT [dbo].[product_batch] ON
INSERT [dbo].[product_batch] ([product_batch_id], [name], [amount_in_grams], [cost], [product_id], [meal_id]) VALUES (1, N'Kiełbasa śląska x1', CAST(90 AS Decimal(10, 3)), 1.63, 8, 1)
INSERT [dbo].[product_batch] ([product_batch_id], [name], [amount_in_grams], [cost], [product_id], [meal_id]) VALUES (2, N'Bułka kajzerka x2', CAST(100 AS Decimal(10, 3)), CAST(0.62 AS Decimal(10, 2)), 5, 2)
INSERT [dbo].[product_batch] ([product_batch_id], [name], [amount_in_grams], [cost], [product_id], [meal_id]) VALUES (3, N'Mięso mielone', CAST(100 AS Decimal(10, 3)), CAST(4.39 AS Decimal(10, 2)), 4, 2)
INSERT [dbo].[product_batch] ([product_batch_id], [name], [amount_in_grams], [cost], [product_id], [meal_id]) VALUES (4, N'Pomidor 50g', CAST(50 AS Decimal(10, 3)), CAST(0.15 AS Decimal(10, 2)), 7, 2)
INSERT [dbo].[product_batch] ([product_batch_id], [name], [amount_in_grams], [cost], [product_id], [meal_id]) VALUES (5, N'Karkówka 200g', CAST(200 AS Decimal(10, 3)), CAST(4.58 AS Decimal(10, 2)), 6, 3)
SET IDENTITY_INSERT [dbo].[product_batch] OFF
