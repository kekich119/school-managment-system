-- Проверить кодировку базы
SELECT datname, pg_encoding_to_char(encoding)
FROM pg_database
WHERE datname = 'school_manage_system';

-- Проверить конкретное значение в таблице
SELECT name, encode(convert_to(name, 'UTF-8'), 'hex')
FROM teacher
WHERE name LIKE '%Матвей%';