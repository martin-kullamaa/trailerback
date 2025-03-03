/* loob rollid */
INSERT INTO trailer.role (id, name) VALUES (default, 'admin');
INSERT INTO trailer.role (id, name) VALUES (default, 'user');
/* loob kasutaja */
INSERT INTO trailer.profile (id, role_id, username, password, email, status) VALUES (default, 2, 'martin', '123', 'martin@', 'A');
/* loob start punkti */
INSERT INTO trailer.location_start (id, name, latitude, longitude) VALUES (default, 'mingi koht', 59.4338103, 24.6939546);
/* loob traili */
INSERT INTO trailer.trail (id, profile_id, location_start_id, name, description, lengh, timestamp, status) VALUES (default, 1, 1, 'mingi matk', 'väga tore ja vahva matk.', 10.0, '2025-02-28 15:35:29.000000', 'A');
/* loob varustust */
INSERT INTO trailer.equipment (id, name, status, timestamps) VALUES (default, 'saapad', 'A', '2025-02-28 15:56:43.000000');
INSERT INTO trailer.equipment (id, name, status, timestamps) VALUES (default, 'kindad', 'A', '2025-02-28 15:56:45.000000');
INSERT INTO trailer.equipment (id, name, status, timestamps) VALUES (default, 'telk', 'A', '2025-02-28 15:56:46.000000');
/* valib varustuse */
INSERT INTO trailer.trail_equipment (id, equipment_id, trail_id) VALUES (default, 1, 1);
INSERT INTO trailer.trail_equipment (id, equipment_id, trail_id) VALUES (default, 2, 1);
/* loob tüübid */
INSERT INTO trailer.type (id, name, status) VALUES (default, 'on foot', 'A');
INSERT INTO trailer.type (id, name, status) VALUES (default, 'bicycle', 'A');
INSERT INTO trailer.type (id, name, status) VALUES (default, 'motorycle', 'A');
/* valib tüübid */
INSERT INTO trailer.trail_type (id, trail_id, type_id) VALUES (default, 1, 2);
INSERT INTO trailer.trail_type (id, trail_id, type_id) VALUES (default, 1, 3);
