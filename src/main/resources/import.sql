/* Customer */
INSERT INTO `customer` (name, customer_identifier) VALUES ('Paul Durand', 'A1234567');
INSERT INTO `customer` (name, customer_identifier) VALUES ('Louis Balthus', 'B2345678');
INSERT INTO `customer` (name, customer_identifier) VALUES ('Pablo Chorizo', 'C3456789');
INSERT INTO `customer` (name, customer_identifier) VALUES ('Mario Bros', 'D4567890');

/* Account */

INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (1000.0, 1, 10.0, 0);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (500.0, 1, 0.0, 1.6);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (2000.0, 2, 123.0, 0.5);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (5000.0, 2, 0.0, 1.3);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (10000.0, 3, 12.0, 0.7);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (2500.0, 3, 10.0, 1.3);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (10.0, 4, 2.0, 0.7);
INSERT INTO `account` (balance, id_customer, overdraft, interest_rate) VALUES (25.0, 4, 1.0, 1.4);



/* BankOperation */
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (40.5, '2019-06-07', 1, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (34.56, '2020-10-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (93.42, '2020-11-23', 2, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (100.97, '2020-12-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (400.5, '2018-06-07', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (343.56, '2010-10-07', 3, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (938.42, '2009-08-23', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (10.97, '2017-11-07', 4, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (340.5, '2020-06-07', 5, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (634.56, '2019-11-07', 6, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (793.42, '2018-11-24', 7, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (900.97, '2020-12-07', 8, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (10400.5, '2015-08-27', 4, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (341.56, '2010-10-16', 5, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (793.42, '2009-09-21', 6, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (1100.97, '2017-11-07', 7, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (410.5, '2019-07-07', 1, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (134.56, '2020-11-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (193.42, '2020-10-23', 2, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (1100.97, '2020-09-07', 2, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (4100.5, '2018-09-07', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (3413.56, '2010-05-07', 3, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (38.42, '2009-10-23', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (110.97, '2017-10-07', 4, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (30.5, '2020-01-07', 5, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (1634.56, '2018-11-07', 6, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (7913.42, '2018-11-24', 7, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (920.97, '2020-10-08', 8, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (10400.5, '2015-08-27', 4, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (341.56, '2011-10-25', 5, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (7931.42, '2009-04-21', 6, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (10.97, '2017-06-07', 7, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (420.5, '2019-02-07', 1, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (342.56, '2020-02-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (923.42, '2020-12-23', 4, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (1200.97, '2020-11-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (4200.5, '2018-02-07', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (3243.56, '2010-12-07', 6, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (9.42, '2009-08-23', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (120.97, '2017-02-07', 4, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (3240.5, '2020-06-07', 1, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (634.56, '2019-11-07', 6, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (793.42, '2018-11-24', 7, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (900.97, '2020-12-07', 8, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (40.5, '2015-08-27', 4, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (341.56, '2010-10-16', 5, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (723.42, '2009-09-21', 6, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (10.97, '2017-11-07', 7, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (410.5, '2019-07-07', 1, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (134.56, '2020-11-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (193.42, '2020-10-14', 7, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (11.97, '2020-09-07', 2, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (4100.5, '2018-09-07', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (33.56, '2010-05-07', 3, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (38.42, '2009-10-23', 3, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (110.97, '2017-10-07', 4, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (30.5, '2020-01-07', 5, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (164.56, '2018-11-07', 6, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (7913.42, '2018-11-24', 7, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (92.97, '2020-10-08', 8, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (167.5, '2015-08-27', 4, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (341.56, '2011-10-25', 5, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (731.42, '2009-04-21', 6, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (1.97, '2017-06-07', 2, 'deposit');