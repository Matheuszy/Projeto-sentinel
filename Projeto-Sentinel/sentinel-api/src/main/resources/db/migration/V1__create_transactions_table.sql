CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL PRIMARY KEY,
    transaction_id BIGINT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    merchant_category BIGINT,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP



);
