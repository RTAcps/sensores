INSERT INTO tb_machine(name, create_at, description) VALUES ('Máquina1', 1714273200000, '')

INSERT INTO tb_sensor(machine_id, name, timestamp, data, get_value, setpoint) VALUES (1, 'sensor1', 1714301701571, 100, 58.26, 100.00)
INSERT INTO tb_sensor(machine_id, name, timestamp, data, get_value, setpoint) VALUES (1, 'sensor2', 1714301821575, 56, 253.85, 300.00)
INSERT INTO tb_sensor(machine_id, name, timestamp, data, get_value, setpoint) VALUES (1, 'sensor3', 1714301937269, 28, 673.45, 674.00)

INSERT INTO tb_leitura(sensor_id, amount, date_time, update_at) VALUES ('1', 85.62, 1714301701571, 1714302432625)
INSERT INTO tb_leitura(sensor_id, amount, date_time, update_at) VALUES ('2', 85.62, 1714301821575, 1714302515951)
INSERT INTO tb_leitura(sensor_id, amount, date_time, update_at) VALUES ('3', 85.62, 1714301937269, 1714302532115)
