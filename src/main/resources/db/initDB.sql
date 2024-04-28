DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS todo_user;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE todo_user
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL
);

CREATE UNIQUE INDEX user_email_uindex ON todo_user (email);

CREATE TABLE activity
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    start_date  TIMESTAMP,
    end_date    TIMESTAMP,
    user_id     INT          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES todo_user (id)
);


-- Path: todo-api/src/main/resources/db/populateDB.sql