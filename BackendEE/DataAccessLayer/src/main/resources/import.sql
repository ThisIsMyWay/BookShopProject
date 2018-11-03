DO $$
declare
  bookId integer;
  authorId integer;
BEGIN

-- fill category dictionary
INSERT INTO category (name) VALUES ('modern literature');
INSERT INTO category (name) VALUES ('educational');
INSERT INTO category (name) VALUES ('realism');
INSERT INTO category (name) VALUES ('southern gothic');
INSERT INTO category (name) VALUES ('epic');
INSERT INTO category (name) VALUES ('poem');
INSERT INTO category (name) VALUES ('novel');
INSERT INTO category (name) VALUES ('classic');
INSERT INTO category (name) VALUES ('philosophy');
INSERT INTO category (name) VALUES ('tragedy');
INSERT INTO category (name) VALUES ('bildungsroman');

-- 1984
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('1984', '978-0451524935', 'Written in 1948, 1984 was George Orwell’s chilling prophecy about the future. And while 1984 has come and gone, his dystopian vision of a government that will do anything to control the narrative is timelier than ever...
', '1961-1-1', 6) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'modern literature'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('George', 'Orwell', '1903-06-25', '1950-01-21') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- A Sentimental Education
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Sentimental Education', '978-0140447972', 'Based on Flaubert''s own youthful passion for an older woman, Sentimental Education was described by its author as "the moral history of the men of my generation." It follows the amorous adventures of Frederic Moreau, a law student who, returning home to Normandy from Paris, notices Mme Arnoux, a slender, dark woman several years older than himself. It is the beginning of an infatuation that will last a lifetime. He befriends her husband, an influential businessman, and as their paths cross and re-cross over the years, Mme Arnoux remains the constant, unattainable love of Moreau''s life. Blending love story, historical authenticity, and satire, Sentimental Education is one of the great French novels of the nineteenth century.',
'2004-10-26', 9.85) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'realism'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Gustave', 'Flaubert', '1821-12-12', '1880-05-08') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Absalom, Absalom!
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Absalom, Absalom!', '978-0075536574', 'Absalom! Absalom! is William Faulkner''s major work--his most important and ambitious contribution to American literature. In the dramatic texture of this story of the founding, flourishing and decay of the plantation of Sutpen''s Hundred, and of the family that demonic Stephen Sutpen brought into the world a generation before the Civil War, there rises the lament of the South for its own vanished splendor. From its magnificent and bold inception, when with his wild Negroes the founder of the great plantation appeared out of nowhere to seize his hundred square miles of land and build his mansion, through the destruction of the Civil War and its aftermath, and the drab beginnings of the new South, the narrative is colored by the author''s glowing imagery, his command of a powerful and magical prose style. Beneath its brilliant surface and dark undercurrents, the novel sweeps backward and forward through time. The story in all its ramifications becomes crystallized in the mind of a relative of this strange family, young Quentin Compson, a Harvard student. At the terrifying and abrupt end of the tale there remain in the crumbling shell of the old house only the dying son of its builder, an ancient Negro woman who had been his slave, and the idiot mulatto youth who was to be the only direct descendant of the Sutpen blood.
This edition is set from the first American edition of 1936 and commemorates the seventy-fifth anniversary of Random House.',
'1966-04-01', 11.67) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'southern gothic'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('William', 'Faulkner', '1897-09-25', '1962-07-06') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- The Aeneid
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('The Aeneid', '978-1521558843', 'The Aeneid (/ᵻˈniːɪd/; Latin: Aeneis ) is a Latin epic poem, written by Virgil between 29 and 19 BC, that tells the legendary story of Aeneas, a Trojan who travelled to Italy, where he became the ancestor of the Romans. It comprises 9,896 lines in dactylic hexameter. The first six of the poem''s twelve books tell the story of Aeneas''s wanderings from Troy to Italy, and the poem''s second half tells of the Trojans'' ultimately victorious war upon the Latins, under whose name Aeneas and his Trojan followers are destined to be subsumed. The hero Aeneas was already known to Greco-Roman legend and myth, having been a character in the Iliad. Virgil took the disconnected tales of Aeneas''s wanderings, his vague association with the foundation of Rome and a personage of no fixed characteristics other than a scrupulous pietas, and fashioned this into a compelling founding myth or national epic that at once tied Rome to the legends of Troy, explained the Punic Wars, glorified traditional Roman virtues, and legitimized the Julio-Claudian dynasty as descendants of the founders, heroes, and gods of Rome and Troy. The Aeneid is widely regarded as Virgil''s masterpiece and one of the greatest works of Latin literature.',
'2004-10-26', 6.99) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'epic'));
INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'poem'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Gustave', 'Flaubert', DATE '0070-10-15 BC', DATE '0019-09-21 BC') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Anna Karenina
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Anna Karenina', '978-0143035008', 'Described by William Faulkner as the best novel ever written and by Fyodor Dostoevsky as “flawless,” Anna Karenina tells of the doomed love affair between the sensuous and rebellious Anna and the dashing officer, Count Vronsky. Tragedy unfolds as Anna rejects her passionless marriage and thereby exposes herself to the hypocrisies of society. Set against a vast and richly textured canvas of nineteenth-century Russia, the novel''s seven major characters create a dynamic imbalance, playing out the contrasts of city and country life and all the variations on love and family happiness.',
'2004-05-31', 19.00) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Leo', 'Tolstoy', '1828-09-09', '1910-11-20') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Beloved
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Beloved', '1-58060-120-0', 'Staring unflinchingly into the abyss of slavery, this spellbinding novel transforms history into a story as powerful as Exodus and as intimate as a lullaby. Sethe, its protagonist, was born a slave and escaped to Ohio, but eighteen years later she is still not free. She has too many memories of Sweet Home, the beautiful farm where so many hideous things happened. And Sethe’s new home is haunted by the ghost of her baby, who died nameless and whose tombstone is engraved with a single word: Beloved. Filled with bitter poetry and suspense as taut as a rope, Beloved is a towering achievement.',
'2004-06-08', 9.85) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));

INSERT INTO author (name, surname, birth_date) VALUES ('Toni', 'Morrison', '1931-02-18') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

-- The Divine Comedy
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('The Divine Comedy', '978-1619490215', 'The historical and cultural significance of Dante Alighieri’s masterpiece The Divine Comedy cannot be overstated. Dante’s poetry takes the reader on a multi-layered journey, one through which he or she experiences this literary master’s unique aesthetic and spiritual sensibilities. The Divine Comedy also presents the opportunity to gain a deeper understanding of medieval Italian thought and its bearing on Western theology and culture. This lyrical allegory of a journey from the depths of Hell to Paradise is a moving read in its own right and its influence upon world literature unchallenged.',
'2011-11-22', 15.35) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'poem'));

INSERT INTO author (name, surname, birth_date, birth_date_accuracy_indicator, death_date) VALUES ('Dante', 'Alighieri', '1265-01-01', 2, '1321-09-13') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Faust
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Faust', '978-1503262140', 'Faust is the protagonist of a classic German legend. He is a scholar who is highly successful yet dissatisfied with his life, so he makes a pact with the Devil, exchanging his soul for unlimited knowledge and worldly pleasures. The Faust legend has been the basis for many literary, artistic, cinematic, and musical works that have reinterpreted it through the ages. Faust and the adjective Faustian imply a situation in which an ambitious person surrenders moral integrity in order to achieve power and success for a delimited term. The Faust of early books—as well as the ballads, dramas, movies, and puppet-plays which grew out of them—is irrevocably damned because he prefers human to divine knowledge; "he laid the Holy Scriptures behind the door and under the bench, refused to be called doctor of Theology, but preferred to be styled doctor of Medicine". Plays and comic puppet theatre loosely based on this legend were popular throughout Germany in the 16th century, often reducing Faust and Mephistopheles to figures of vulgar fun. The story was popularised in England by Christopher Marlowe, who gave it a classic treatment in his play, The Tragical History of Doctor Faustus. In Goethe''s reworking of the story two hundred years later, Faust becomes a dissatisfied intellectual who yearns for "more than earthly meat and drink" in his life.',
'2018-09-11', 11.49) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'classic'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Johann Wolfgang', 'von Goethe', '1749-08-28', '1832-03-22') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


--Hunger
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Hunger', '978-0374531102', 'A true classic of modern literature that has been described as "one of the most disturbing novels in existence" (Time Out), Hunger is the story of a Norwegian artist who wanders the streets, struggling on the edge of starvation. As hunger overtakes him, he slides inexorably into paranoia and despair. The descent into madness is recounted by the unnamed narrator in increasingly urgent and disjointed prose, as he loses his grip on reality.',
'2008-02-19', 16.00) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));
INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'philosophy'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Knut ', 'Hamsun', '1859-08-04', '1952-02-19') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Love in the Time of Cholera
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Love in the Time of Cholera', '978-0307389732', '"A love story of astonishing power." - Newsweek
the International Bestseller and modern literary classic by Nobel Prize-Winning author Gabriel Garcia Marquez',
'2007-10-05', 9.93) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Gabriel', 'García Márquez', '1927-03-06', '2014-04-14') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

-- Madame Bovary
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Madame Bovary', '978-0670022076', 'A literary event: one of the most celebrated novels ever written, in a magnificent new translation

Seven years ago, the incomparable Lydia Davis brought us an award-winning, rapturously reviewed new translation of Marcel Proust''s Swann''s Way that was hailed as "clear and true to the music of the original" (Los Angeles Times) and "a work of creation in its own right" (Claire Messud, Newsday). Now she turns her gifts to the book that defined the novel as an art form.

When Emma Rouault marries dull, provincial doctor Charles Bovary, her dreams of an elegant and passionate life crumble. She escapes into sentimental novels but finds her fantasies dashed by the tedium of her days. Motherhood proves to be a burden; religion is only a brief distraction. She spends lavishly and embarks on a series of disappointing affairs. Soon heartbroken and crippled by debts, Emma takes drastic action with tragic consequences for her husband and daughter. When published in 1857, Madame Bovary was embraced by bourgeois women who claimed it spoke to the frustrations of their lives. Davis''s landmark translation gives new life in English to Flaubert''s masterwork.',
'2010-09-23', 12.85) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Gustave', 'Flaubert', '1821-12-12', '1880-05-08') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

-- The Odyssey
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('The Odyssey', '978-0140268867', 'Robert Fagles, winner of the PEN/Ralph Manheim Medal for Translation and a 1996 Academy Award in Literature from the American Academy of Arts and Letters, presents us with Homer''s best-loved and most accessible poem in a stunning modern-verse translation. "Sing to me of the man, Muse, the man of twists and turns driven time and again off course, once he had plundered the hallowed heights of Troy." So begins Robert Fagles'' magnificent translation of the Odyssey, which Jasper Griffin in the New York Times Book Review hails as "a distinguished achievement."',
'1997-11-01', 15.60) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'poem'));

INSERT INTO author (surname) VALUES ('Homer') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

--Othello
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Othello', '978-1539420385', 'Othello, The Moor of Venice is a tragedy by William Shakespeare based on the short story "Moor of Venice" by Cinthio, believed to have been written in approximately 1603. The work revolves around four central characters: Othello, his wife Desdemona, his lieutenant Cassio, and his trusted advisor Iago. Attesting to its enduring popularity, the play appeared in 7 editions between 1622 and 1705. Because of its varied themes - racism, love, jealousy and betrayal - it remains relevant to the present day and is often performed in professional and community theatres alike. The play has also been the basis for numerous operatic, film and literary adaptations.',
'2016-10-09', 9.85) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'tragedy'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('William', 'Shakespeare', '1564-04-26', '1616-04-23') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

-- Things Fall Apart
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Things Fall Apart', '978-0385474542', 'Things Fall Apart is the first of three novels in Chinua Achebe''s critically acclaimed African Trilogy. It is a classic narrative about Africa''s cataclysmic encounter with Europe as it establishes a colonial presence on the continent. Told through the fictional experiences of Okonkwo, a wealthy and fearless Igbo warrior of Umuofia in the late 1800s, Things Fall Apart explores one man''s futile resistance to the devaluing of his Igbo traditions by British political andreligious forces and his despair as his community capitulates to the powerful new order.',
'1994-09-01', 10.71) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Chinua', 'Achebe', '1930-11-16', '2013-03-21') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

-- Ulysses
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Ulysses', '978-1494405496', 'Ulysses is a novel by Irish writer James Joyce. It was first serialised in parts in the American journal The Little Review from March 1918 to December 1920, and then published in its entirety by Sylvia Beach in February 1922, in Paris. It is considered to be one of the most important works of Modernist literature, and has been called "a demonstration and summation of the entire movement". "Before Joyce, no writer of fiction had so foregrounded the process of thinking." However, even proponents of Ulysses such as Anthony Burgess have described the book as "inimitable, and also possibly mad".',
'2013-12-07', 6.98) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('James', 'Joyce', '1882-02-02', '1941-01-13') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

-- War and Peace
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('War and Peace', '978-1400079988', 'War and Peace broadly focuses on Napoleon’s invasion of Russia in 1812 and follows three of the most well-known characters in literature: Pierre Bezukhov, the illegitimate son of a count who is fighting for his inheritance and yearning for spiritual fulfillment; Prince Andrei Bolkonsky, who leaves his family behind to fight in the war against Napoleon; and Natasha Rostov, the beautiful young daughter of a nobleman who intrigues both men.',
'2008-12-01', 13.59) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));
INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, (SELECT id FROM author WHERE name = 'Leo' AND surname = 'Tolstoy'));

-- Invisible Man by Ralph Ellison
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Invisible Man', '978-0679732761', 'A first novel by an unknown writer, it remained on the bestseller list for sixteen weeks, won the National Book Award for fiction, and established Ralph Ellison as one of the key writers of the century. The nameless narrator of the novel describes growing up in a black community in the South, attending a Negro college from which he is expelled, moving to New York and becoming the chief spokesman of the Harlem branch of "the Brotherhood", and retreating amid violence and confusion to the basement lair of the Invisible Man he imagines himself to be. The book is a passionate and witty tour de force of style, strongly influenced by T.S. Eliot''s The Waste Land, Joyce, and Dostoevsky.',
'1995-03-14', 12.79) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'bildungsroman'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Ralph', 'Ellison', '1913-03-01', '1994-04-16') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Jacques the Fatalist and His Master
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Jacques the Fatalist and His Master', '978-0199537952', 'Jacques the Fatalist is a provocative exploration of the problems of human existence, destiny, and free will. In the introduction to this brilliant translation, David Coward explains the philosophical basis of Diderot''s fascination with fate and examines the experimental and influential literary techniques that make Jacques the Fatalist a classic of the Enlightenment.',
'2009-08-31', 13.80) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'novel'));
INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'philosophy'));

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('Denis', 'Diderot', '1713-10-05', '1784-07-31') RETURNING id INTO authorId;

INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);


-- Design Patterns: Elements of Reusable Object-Oriented Software
INSERT INTO BOOK (TITLE,ISBN,DESCRIPTION,PUBLISHING_DATE,BASE_PRICE) VALUES ('Design Patterns: Elements of Reusable Object-Oriented Software', '978-0201633610', 'Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves.',
'1994-11-10', 54.57) RETURNING id INTO bookId;

INSERT INTO book_to_category (book_id, category_id) VALUES (bookId, (SELECT id FROM category WHERE name = 'educational'));


INSERT INTO author (name, surname, birth_date) VALUES ('Erich', 'Gamma', '1961-03-13') RETURNING id INTO authorId;
INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

INSERT INTO author (name, surname) VALUES ('Richard', 'Helm') RETURNING id INTO authorId;
INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

INSERT INTO author (name, surname) VALUES ('Ralph', 'Johnson') RETURNING id INTO authorId;
INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

INSERT INTO author (name, surname, birth_date, death_date) VALUES ('John', 'Vlissides', '1961-08-02', '2005-11-24') RETURNING id INTO authorId;
INSERT INTO book_to_author (book_id, author_id) VALUES (bookId, authorId);

END $$;
