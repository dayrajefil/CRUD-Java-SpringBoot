CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  kind_id INT REFERENCES kind(id) NOT NULL,
  named VARCHAR(255) NOT NULL,
  relate TEXT NOT NULL,
  url_link TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
