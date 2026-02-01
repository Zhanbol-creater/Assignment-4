
CREATE TABLE songs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration DOUBLE PRECISION NOT NULL,
    artist VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL
);


CREATE TABLE podcasts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration DOUBLE PRECISION NOT NULL,
    host VARCHAR(255) NOT NULL,
    episode_number INT NOT NULL
);


CREATE TABLE playlists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE playlist_media (
    playlist_id INT REFERENCES playlists(id) ON DELETE CASCADE,
    media_id INT NOT NULL,
    media_type VARCHAR(50) NOT NULL,
    PRIMARY KEY (playlist_id, media_id, media_type)
);


INSERT INTO songs (title, duration, artist, genre)
VALUES ('Imagine', 3.5, 'John Lennon', 'Rock');

INSERT INTO podcasts (title, duration, host, episode_number) 
VALUES ('TechTalk Ep1', 45, 'Alice', 1);

INSERT INTO playlists (name) VALUES ('Favorites');