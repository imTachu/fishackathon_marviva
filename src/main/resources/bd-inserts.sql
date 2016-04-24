----------------------------------------------------------
---Atún
----------------------------------------------------------

INSERT INTO economia
    (id, forma_comercializacion, precio_promedio_kg)
    VALUES (1, 'Se comercializa en lomos o chuletas, descongelados o congelados y principalmente en supermercados de clase alta. Casi siempre se vende empacado al vacío.', 5);

INSERT INTO informacion_nutricional
    (id, calorias, grasas, proteinas)
    VALUES (1, 108, 0.95, 23.28);

INSERT INTO regulacion
    (id)
    VALUES (1);

INSERT INTO fish
    (id,
        nombre_comun,
        nombre_cientifico,
        nombre_etiquetado,
        coloracion,
        olor,
        caracteristicas_animal,
        caracteristicas_filete,
        estado_conservacion,
        longitud_maxima_animal,
        peso_maximo_animal, peso_maximo_filete, peso_minimo_filete)
    VALUES (1,
        'Atún aleta amarilla',
        'Thunnus albacares',
        'Atun aleta amarilla',
        'La coloración en fresco es rojo intenso, conforme se va congelando su color se vuelve más opaco y de color marrón.',
        'Debe tener un olor a pescado fresco. No debe poseer olores fuertes, rancios o a amoníaco.',
        'Pelágicos en mar abierto y rara vez visto cerca de arrecifes. Se agrupan mono o multiespecíficamente de acuerdo a su tamaño.',
        'Se comercializa en lomos o chuletas, descongelados o congelados y principalmente en supermercados de clase alta. Casi siempre se vende empacado al vacío.',
        'SIN_RIESGO',
        239,
        200,
        100,
        200
        );

----------------------------------------------------------
---Merluza
----------------------------------------------------------

INSERT INTO economia
    (id, forma_comercializacion, precio_promedio_kg)
    VALUES (2, 'Se comercializa fresca o congelada, tanto entera como en filetes, o en platos precocinados.', 40);

INSERT INTO informacion_nutricional
(id, calorias,  grasas, proteinas)
    VALUES (2, 71, 0.3, 17);

INSERT INTO regulacion
    (id)
    VALUES (2);

INSERT INTO fish
    (id, nombre_comun, nombre_cientifico, nombre_etiquetado,
        coloracion,
        olor,
        caracteristicas_animal,
        caracteristicas_filete,
        estado_conservacion,
        longitud_maxima_animal)
    VALUES (2, 'Merluza', 'Brotula clarkae', 'Merluza',
        'Carne de color blanco y suave poco firme. No pierde demasiado color al ser congelada.',
        'A pescado fresco',
        'Adultos benthopleágicos 650m de profundidad). Jóvenes son comunes en arrecifes. En profundidades de 40-75m los adultos son encontrados en fondos lodosos.',
        'Se realizan cortes múltiples dado la consistencia de su carne.',
        'SIN_RIESGO',
        115);

----------------------------------------------------------
---Dorado
----------------------------------------------------------

INSERT INTO economia
        (id, forma_comercializacion, precio_promedio_kg)
        VALUES (3, 'Se comercializa en filetes sin espina, frescos o descongelados.', 40);

INSERT INTO informacion_nutricional
        (id, calorias, grasas, proteinas)
        VALUES (3, 80, 1.2, 19.8);

INSERT INTO regulacion
        (id)
        VALUES (3);

INSERT INTO fish
        (id,
            nombre_comun,
            nombre_cientifico,
            nombre_etiquetado,
            coloracion,
            olor,
            caracteristicas_animal,
            caracteristicas_filete,
            estado_conservacion,
            longitud_maxima_animal, longitud_minima_animal,
            peso_maximo_animal, peso_maximo_filete, peso_minimo_filete)
        VALUES (3,
            'Dorado',
            'Coryphaena hippurus',
            'Dorado',
            'Su carne es color blanco, suave pero firme. La lonja presenta una línea de sangre característica, cuando se congela y se descongela toma un tono más oscuro.',
            'A pescado fresco.',
            'Forman cardúmenes Se alimentan de casi todas las formas de peces y zooplancton, también crustáceos y calamares. Alcanzan la madurez sexual a los 4-5 meses.',
            'Se filetea en lonjas que pueden medir entre 60 a 70 cm de largo, por unos 20 cm de ancho.',
            'LC',
            70, 60,
            25, 200, 100
            );


----------------------------------------------------------
---Langosta roja
----------------------------------------------------------

INSERT INTO economia
    (id, forma_comercializacion, precio_promedio_kg)
    VALUES (4, 'Se desembarca fresco y entero. Aparece en los mercados vivo, fresco y congelado.', 10);

INSERT INTO informacion_nutricional
    (id, calorias, carbohidratos, grasas, proteinas)
    VALUES (4, 143, 3.1, 1.9, 26.4);

INSERT INTO regulacion
    (id, inicio_veda, fin_veda, maximo_toneladas)
    VALUES (4, make_date(2013, 4, 1), make_date(2013, 5, 30), 150);

INSERT INTO fish
    (id,
        nombre_comun,
        nombre_cientifico,
        nombre_etiquetado,
        olor,
        caracteristicas_animal,
        estado_conservacion,
        longitud_maxima_animal, longitud_minima_animal,
        peso_maximo_animal, peso_minimo_animal)
    VALUES (4,
        'Langosta roja',
        'Panulirus argus',
        'Langosta',
        'A pescado fresco.',
        'Caparazón redondeada, con grandes espinas y tumultos en la cabeza de diversos tamaños. Antenas largas con pequeñas espinas. Sus ojos están en frente de las espinas. Su coloración va de rojo a café.',
        'CR',
        45, 18,
        5, 3
        );

----------------------------------------------------------
---Caracol pala
----------------------------------------------------------

INSERT INTO economia
    (id, forma_comercializacion)
    VALUES (5, 'Venta local, establece precios de acuerdo al mercado.');

INSERT INTO informacion_nutricional
    (id, calorias, carbohidratos, grasas, proteinas)
    VALUES (5, 90, 2, 1.4, 16.1);

INSERT INTO regulacion
    (id, maximo_toneladas)
    VALUES (5, 16);

INSERT INTO fish
    (id,
        nombre_comun,
        nombre_cientifico,
        nombre_etiquetado,
        olor,
        coloracion,
        caracteristicas_animal,
        estado_conservacion,
        longitud_maxima_animal, longitud_minima_animal,
        peso_maximo_animal, peso_minimo_animal)
    VALUES (5,
        'Caracol pala',
        'Lobatus gigas',
        'Caracol pala',
        'A pescado fresco.',
        'Color rosado suave y brillante y concha color amarillo crema.',
        'Tiene una concha muy grande y pesada. Uno de sus bordes es muy extendido en forma de ala. En su revés se observa una abertura donde se encuentra el cuerpo del organismo.',
        'VU',
        45, 35,
        3, 2
        );

-------------------------------------------------------------------------
---Imagenes Atún
-------------------------------------------------------------------------

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (1, 'content/images/fishes/1/1.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (1, 'content/images/fishes/1/2.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (1, 'content/images/fishes/1/3.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (1, 'content/images/fishes/1/4.jpg');

-------------------------------------------------------------------------
---Imagenes Merluza
-------------------------------------------------------------------------

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (2, 'content/images/fishes/2/1.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (2, 'content/images/fishes/2/2.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (2, 'content/images/fishes/2/3.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (2, 'content/images/fishes/2/4.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (2, 'content/images/fishes/2/5.jpg');

-------------------------------------------------------------------------
---Imagenes Dorado
-------------------------------------------------------------------------

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (3, 'content/images/fishes/3/1.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (3, 'content/images/fishes/3/2.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (3, 'content/images/fishes/3/3.jpg');

-------------------------------------------------------------------------
---Imagenes Langosta roja
-------------------------------------------------------------------------

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (4, 'content/images/fishes/4/1.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (4, 'content/images/fishes/4/2.jpg');

-------------------------------------------------------------------------
---Imagenes Caracol pala
-------------------------------------------------------------------------

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (5, 'content/images/fishes/5/1.jpg');

INSERT INTO fish_imagenes
    (fish_id, imagenes)
    VALUES (5, 'content/images/fishes/5/2.jpg');
