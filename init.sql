CREATE TABLE IF NOT EXISTS trucks (
  id SERIAL PRIMARY KEY,
  applicant VARCHAR(255),
  facility_type VARCHAR(255),
  location_description VARCHAR(255),
  address VARCHAR(255),
  food_items VARCHAR(255),
  latitude DOUBLE PRECISION,
  longitude DOUBLE PRECISION
);

ALTER TABLE trucks ADD CONSTRAINT unique_applicant_address UNIQUE (applicant, address);

CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ratings (
  id SERIAL PRIMARY KEY,
  user_id INTEGER,
  truck_id INTEGER,
  rating INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (truck_id) REFERENCES trucks (id)
);

ALTER TABLE ratings ADD CONSTRAINT check_rating_range CHECK (rating >= 1 AND rating <= 5);
