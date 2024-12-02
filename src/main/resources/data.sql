
    INSERT INTO users (name, email) VALUES
    ('user1', 'user1@mail.ru'),
    ('user2', 'user2@mail.ru');

    INSERT INTO orders (user_id, status) VALUES
    (1, 'PENDING'),
    (1, 'PENDING'),
    (2, 'COMPLETED');
