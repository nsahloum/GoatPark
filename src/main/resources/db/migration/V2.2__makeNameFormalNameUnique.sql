ALTER TABLE divisions
    ADD CONSTRAINT name_uniqueness UNIQUE (name, original_name);