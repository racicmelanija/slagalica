COPY slagalica(word)
FROM 'C:\temp\sr-dic.txt'
DELIMITER ','
CSV HEADER;

CREATE INDEX sorted_chars_idx
    ON public.slagalica USING btree
    (sorted_chars ASC NULLS LAST)
;