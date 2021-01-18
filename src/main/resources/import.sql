/* Customer */
INSERT INTO `customer` (name, customer_identifier) VALUES ('Paul Durand', 'A1234567');

/* Account */

INSERT INTO `account` (balance, id_customer, account_type) VALUES (1000.0, 1, 'current_account');
INSERT INTO `account` (balance, id_customer, account_type) VALUES (500.0, 1, 'savings_account');

/* BankOperation */
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (40.5, '2019-06-07', 1, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (34.56, '2020-10-07', 2, 'deposit');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (93.42, '2020-11-23', 2, 'withdrawal');
INSERT INTO `bank_operation` (operation_amount, operation_date, id_account, operation_type) VALUES (100.97, '2020-12-07', 2, 'deposit');