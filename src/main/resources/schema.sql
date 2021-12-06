CREATE TABLE IF NOT EXISTS creneau (
  id_creneau INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(100),
  date DATE
);

CREATE TABLE IF NOT EXISTS position (
  id_position INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS truck (
  id_truck INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(100),
  id_creneau INT,
  CONSTRAINT fk_idCreneau
    FOREIGN KEY (id_creneau)
    REFERENCES creneau(id_creneau),
  id_position INT,
  CONSTRAINT fk_idPosition
      FOREIGN KEY (id_position)
      REFERENCES position(id_position)
);