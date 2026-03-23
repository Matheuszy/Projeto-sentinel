CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL PRIMARY KEY,
    transaction_id VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    merchant_category VARCHAR(100),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);
