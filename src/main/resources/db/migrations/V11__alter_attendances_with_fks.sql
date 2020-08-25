ALTER TABLE attendances ADD COLUMN hospital_clinic_attendance_id integer;
ALTER TABLE attendances ADD CONSTRAINT hospital_clinic_attendance_id FOREIGN KEY (hospital_clinic_attendance_id) REFERENCES hospital_clinic_attendances(id);

ALTER TABLE attendances ADD COLUMN household_attendance_id integer;
ALTER TABLE attendances ADD CONSTRAINT household_attendance_id FOREIGN KEY (household_attendance_id) REFERENCES household_attendances(id);

ALTER TABLE attendances ADD COLUMN online_attendance_id integer;
ALTER TABLE attendances ADD CONSTRAINT online_attendance_id FOREIGN KEY (online_attendance_id) REFERENCES online_attendances(id);