CREATE TABLE spending_limit
(
    id     BIGSERIAL NOT NULL PRIMARY KEY,
    amount INT
);

INSERT INTO spending_limit(amount)
VALUES (3000);