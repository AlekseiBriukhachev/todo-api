DROP TABLE IF EXISTS public.activity;
DROP TABLE IF EXISTS public.user;

CREATE TABLE public.user
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE public.activity
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    start_date  TIMESTAMP,
    end_date    TIMESTAMP,
    user_id     INT          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

-- Path: todo-api/src/main/resources/db/populateDB.sql