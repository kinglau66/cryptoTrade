CREATE TABLE wallet_coin_balance (
  id BIGINT NOT NULL,
   wallet_id BIGINT NOT NULL,
   coin_code VARCHAR(255) NOT NULL,
   balance DECIMAL(20, 8) NOT NULL,
   CONSTRAINT pk_wallet_coin_balance PRIMARY KEY (id)
);

ALTER TABLE wallet_coin_balance ADD CONSTRAINT FK_WALLET_COIN_BALANCE_ON_COIN_CODE FOREIGN KEY (coin_code) REFERENCES coin (code);

ALTER TABLE wallet_coin_balance ADD CONSTRAINT FK_WALLET_COIN_BALANCE_ON_WALLET FOREIGN KEY (wallet_id) REFERENCES wallet (id);

CREATE TABLE wallet_transaction (
  id BIGINT NOT NULL,
   wallet_id BIGINT NOT NULL,
   transaction_symbol VARCHAR(255) NOT NULL,
   to_balance_before DECIMAL(20, 8) NOT NULL,
   to_balance_after DECIMAL(20, 8) NOT NULL,
   fr_balance_before DECIMAL(20, 8) NOT NULL,
   fr_balance_after DECIMAL(20, 8) NOT NULL,
   timestamp TIMESTAMP NOT NULL,
   CONSTRAINT pk_wallet_transaction PRIMARY KEY (id)
);

ALTER TABLE wallet_transaction ADD CONSTRAINT FK_WALLET_TRANSACTION_ON_WALLET FOREIGN KEY (wallet_id) REFERENCES wallet (id);
