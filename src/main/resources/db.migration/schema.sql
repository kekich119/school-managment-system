CREATE TABLE IF NOT EXISTS teacher
(

    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(256) NOT NULL,
    last_name VARCHAR(256) NOT NULL,
    age      INTEGER      NOT NULL
)



