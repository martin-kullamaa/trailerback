-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA IF EXISTS trailer CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA trailer
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA trailer TO postgres;
GRANT ALL ON SCHEMA trailer TO PUBLIC;