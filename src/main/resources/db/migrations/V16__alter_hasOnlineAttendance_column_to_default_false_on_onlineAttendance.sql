ALTER TABLE online_attendances ALTER COLUMN has_online_attendance SET DEFAULT FALSE;

UPDATE online_attendances SET has_online_attendance = (CASE WHEN platforms <> '' THEN TRUE ELSE FALSE END);                             ;