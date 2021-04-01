 ALTER TABLE address
    ADD FOREIGN KEY (contact_id)
    REFERENCES contacts(id)