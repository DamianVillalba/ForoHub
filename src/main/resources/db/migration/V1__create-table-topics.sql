-- Esta migración crea la tabla 'topics' para la API de Forohub.
-- Se añaden restricciones de integridad para asegurar la calidad de los datos.
CREATE TABLE topics(
    id SERIAL NOT NULL,
    title VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT NOW(), -- DEFAULT NOW() como medida de seguridad extra.
    status BOOLEAN DEFAULT TRUE, -- DEFAULT TRUE por defecto como medida de seguridad extra.
    author VARCHAR(255) NOT NULL,
    course VARCHAR(255) NOT NULL,
    CONSTRAINT topic_pk PRIMARY KEY (id),
    CONSTRAINT unique_topic UNIQUE (title, message)
);