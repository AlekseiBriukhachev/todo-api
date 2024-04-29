DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS todo_user;

CREATE TABLE todo_user
(
    id      INTEGER PRIMARY KEY UNIQUE NOT NULL,
    name    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL
);

CREATE UNIQUE INDEX user_email_uindex ON todo_user (email);

CREATE TABLE activity
(
    id          INTEGER PRIMARY KEY UNIQUE NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    start_date  TIMESTAMP,
    end_date    TIMESTAMP,
    user_id     INT          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES todo_user (id)
);


-- Path: todo-api/src/main/resources/db/populateDB.sql