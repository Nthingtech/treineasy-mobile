-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO tbl_exercise (id_exercise, name_exercise, machine_number, muscle_group, video_uri) VALUES(1, 'cadeira extensora', 2, 'quadríceps', 'https://imagem.com.br');

INSERT INTO tbl_training (id_training, name_training, total_training, dt_concluded, status) VALUES(1, 'Treino MMII', 2, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1);