-- Create table for venues
CREATE TABLE IF NOT EXISTS venues
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    address     VARCHAR(255) NOT NULL,
    city        VARCHAR(100) NOT NULL,
    state       VARCHAR(100) NOT NULL,
    country     VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20)  NOT NULL
);

-- Create table for categories
CREATE TABLE IF NOT EXISTS categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Create table for users
CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(20)  NOT NULL
);

-- Create table for events
CREATE TABLE IF NOT EXISTS events
(
    id           SERIAL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    cover_image  VARCHAR(255),
    description  TEXT,
    start_time   TIMESTAMP    NOT NULL,
    end_time     TIMESTAMP    NOT NULL,
    venue_id     INT          NOT NULL,
    category_id  INT          NOT NULL,
    organizer_id INT          NOT NULL,
    FOREIGN KEY (venue_id) REFERENCES venues (id),
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (organizer_id) REFERENCES users (id)
);