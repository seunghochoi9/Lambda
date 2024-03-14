CREATE TABLE com.erichgamma.api.board(
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(20) NOT NULL,
  content VARCHAR(100) NULL,
  writer VARCHAR(20) NOT NULL,
  register_date  VARCHAR(20),
  CONSTRAINT board_pk PRIMARY KEY(id)
);

select * from board;
insert into users(username, password, name, phone)
values ('유저네임','비밀번호','네임', '번호');
select * from users;

rename table com.erichgamma.api.board to articles;

show tables;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(20),
    phone VARCHAR(20),
    job VARCHAR(20),
    height VARCHAR(20),
    weight VARCHAR(20)
);

DROP TABLE stadium;
show tables;

select * from stadium;
CREATE TABLE stadium(
  id INT AUTO_INCREMENT NOT NULL,
  statdium_name VARCHAR(40) NOT NULL,
  hometeam_id VARCHAR(10)  NOT NULL,
  seat_count INT NOT NULL,
  address VARCHAR(60),
  ddd VARCHAR(10),
  tel VARCHAR(10),
  CONSTRAINT stadium_pk PRIMARY KEY(id)
);

CREATE TABLE team(
  id INT AUTO_INCREMENT NOT NULL,
  region_name VARCHAR(10) NOT NULL,
  team_name VARCHAR(40)  NOT NULL,
  e_team_name VARCHAR(50) NOT NULL,
  orig_yyyy VARCHAR(10) NOT NULL,
  zip_code1 VARCHAR(10) NOT NULL,
  zip_code2 VARCHAR(10) NOT NULL,
  address VARCHAR(80) NOT NULL,
  ddd VARCHAR(10) NOT NULL,
  tel VARCHAR(10) NOT NULL,
  fax VARCHAR(10) NOT NULL,
  homepage VARCHAR(50) NOT NULL,
  owner VARCHAR(10) NOT NULL,
  stadium_id INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(stadium_id) REFERENCES stadium (id)
);


CREATE TABLE schedule(
  id INT AUTO_INCREMENT NOT NULL,
  gudun VARCHAR(10) NOT NULL,
  hometeam_id VARCHAR(10)  NOT NULL,
  awayteam_id VARCHAR(10) NOT NULL,
  home_score INT NOT NULL,
  away_score INT NOT NULL,
  stadium_id INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(stadium_id) REFERENCES stadium (id)
);

CREATE TABLE player(
  id INT AUTO_INCREMENT NOT NULL,
  player_name VARCHAR(20) NOT NULL,
  e_player_name VARCHAR(40)  NOT NULL,
  nickname VARCHAR(30) NOT NULL,
  join_yyyy VARCHAR(10) NOT NULL,
  position VARCHAR(10) NOT NULL,
  back_no INT NOT NULL,
  nation VARCHAR(20) NOT NULL,
  birth_date DATE NOT NULL,
  solar VARCHAR(10) NOT NULL,
  height INT NOT NULL,
  weight INT NOT NULL,
  team_id INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(team_id) REFERENCES team (id)
);

