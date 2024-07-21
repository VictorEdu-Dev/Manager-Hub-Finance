CREATE OR REPLACE FUNCTION compare_strings(street TEXT, street_name TEXT)
RETURNS BOOLEAN AS $$
DECLARE
    street_set TEXT[];
    street_name_set TEXT[];
    word TEXT;
    common_count INT := 0;
BEGIN
    -- Convert the input strings to lowercase and split into arrays of words
    street_set := string_to_array(lower(street), ' ');
    street_name_set := string_to_array(lower(street_name), ' ');

    -- Remove irrelevant words
    street_set := array_remove(street_set, 'de');
    street_set := array_remove(street_set, 'da');
    street_set := array_remove(street_set, 'do');
    street_set := array_remove(street_set, 'dos');
    street_set := array_remove(street_set, 'das');
    street_set := array_remove(street_set, 'e');
    street_set := array_remove(street_set, 'rua');
    street_set := array_remove(street_set, 'avenida');
    street_set := array_remove(street_set, 'estrada');
    street_set := array_remove(street_set, 'travessa');
    street_set := array_remove(street_set, 'alameda');
    street_set := array_remove(street_set, 'largo');
    street_set := array_remove(street_set, 'praça');
    street_set := array_remove(street_set, 'rodovia');
    street_set := array_remove(street_set, 'viela');
    street_set := array_remove(street_set, 'viaduto');

    -- Compare the sets
    FOREACH word IN ARRAY street_set LOOP
        IF word = ANY (street_name_set) THEN
            common_count := common_count + 1;
        END IF;
    END LOOP;

    RETURN common_count > 0;
END;
$$ LANGUAGE plpgsql;
