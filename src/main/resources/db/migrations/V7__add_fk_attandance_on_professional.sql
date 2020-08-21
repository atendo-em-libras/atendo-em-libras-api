ALTER TABLE professionals ADD COLUMN attendance_id integer;
ALTER TABLE professionals ADD CONSTRAINT attendance_id FOREIGN KEY (attendance_id) REFERENCES attendances(id);