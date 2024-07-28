-- Insert venues
INSERT INTO venues (name, address, city, state, country, postal_code)
VALUES ('Madison Square Garden', '4 Pennsylvania Plaza', 'New York', 'NY', 'USA', '10001'),
       ('The O2 Arena', 'Peninsula Square', 'London', 'Greater London', 'UK', 'SE10 0DX'),
       ('Staples Center', '1111 S Figueroa St', 'Los Angeles', 'CA', 'USA', '90015'),
       ('Sydney Opera House', 'Bennelong Point', 'Sydney', 'NSW', 'Australia', '2000');

-- Insert categories
INSERT INTO categories (name)
VALUES ('Music'),
       ('Sports'),
       ('Theater'),
       ('Conference'),
       ('Exhibition');

-- Insert users
INSERT INTO users (username, email, password, role)
VALUES ('john_doe', 'john.doe@example.com', 'hashed_password_1', 'organizer'),
       ('jane_smith', 'jane.smith@example.com', 'hashed_password_2', 'admin'),
       ('mike_wilson', 'mike.wilson@example.com', 'hashed_password_3', 'user'),
       ('sarah_johnson', 'sarah.johnson@example.com', 'hashed_password_4', 'organizer');

-- Insert events
INSERT INTO events (title, description, start_time, end_time, venue_id, category_id, organizer_id)
VALUES ('Rock Revolution Concert', 'A night of classic rock hits', '2024-09-15 19:00:00', '2024-09-15 23:00:00', 1, 1,
        1),
       ('NBA All-Star Game', 'Annual exhibition basketball game', '2025-02-16 20:00:00', '2025-02-16 23:00:00', 3, 2,
        2),
       ('Phantom of the Opera', 'Andrew Lloyd Webber''s classic musical', '2024-11-10 19:30:00', '2024-11-10 22:30:00',
        2, 3, 4),
       ('TechCon 2024', 'Annual technology conference', '2024-10-05 09:00:00', '2024-10-07 18:00:00', 4, 4, 1),
       ('Modern Art Expo', 'Exhibition of contemporary artists', '2024-12-01 10:00:00', '2024-12-14 18:00:00', 4, 5, 4);