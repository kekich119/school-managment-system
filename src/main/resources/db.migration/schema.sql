CREATE TABLE IF NOT EXISTS teachers
(

    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(256) NOT NULL,
    lastName VARCHAR(256) NOT NULL,
    age      INTEGER      NOT NULL
)



