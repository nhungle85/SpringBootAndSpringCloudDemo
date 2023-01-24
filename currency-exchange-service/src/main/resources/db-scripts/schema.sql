CREATE TABLE CURRENCY_EXCHANGE(
  currency_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  currency_from VARCHAR(3) NOT NULL,
  currency_from VARCHAR(3) NOT NULL,
  conversion_multiple DECIMAL(3, 2)
);