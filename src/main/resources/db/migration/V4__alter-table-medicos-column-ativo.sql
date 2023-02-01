BEGIN;
ALTER TABLE medicos ADD COLUMN ativo_novo BOOLEAN;
UPDATE medicos SET ativo_novo = (ativo = 1);
ALTER TABLE medicos DROP COLUMN ativo;
ALTER TABLE medicos RENAME COLUMN ativo_novo TO ativo;
ALTER TABLE medicos ALTER COLUMN ativo SET DEFAULT TRUE;
UPDATE medicos SET ativo = TRUE;
COMMIT;