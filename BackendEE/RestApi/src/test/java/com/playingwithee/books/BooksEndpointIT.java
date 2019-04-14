package com.playingwithee.books;

import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BooksEndpointIT {

    private static final String booksExpectedBody = "{\n" +
            "    \"links\": [\n" +
            "        {\n" +
            "            \"href\": \"http://192.168.99.100:8080/bookshop/rest/books\",\n" +
            "            \"rel\": \"self\",\n" +
            "            \"method\": \"GET\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"bookList\": [\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/1\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 1,\n" +
            "            \"title\": \"1984\",\n" +
            "            \"author\": \"George Orwell\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/1\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 1,\n" +
            "                    \"name\": \"George Orwell\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 6.00,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/2\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 2,\n" +
            "            \"title\": \"Sentimental Education\",\n" +
            "            \"author\": \"Gustave Flaubert\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/2\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 2,\n" +
            "                    \"name\": \"Gustave Flaubert\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 9.85,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/3\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 3,\n" +
            "            \"title\": \"Absalom, Absalom!\",\n" +
            "            \"author\": \"William Faulkner\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/3\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 3,\n" +
            "                    \"name\": \"William Faulkner\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 11.67,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/4\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 4,\n" +
            "            \"title\": \"The Aeneid\",\n" +
            "            \"author\": \"Gustave Flaubert\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/4\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 4,\n" +
            "                    \"name\": \"Gustave Flaubert\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 6.99,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/5\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 5,\n" +
            "            \"title\": \"Anna Karenina\",\n" +
            "            \"author\": \"Leo Tolstoy\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/5\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 5,\n" +
            "                    \"name\": \"Leo Tolstoy\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 19.00,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/6\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 6,\n" +
            "            \"title\": \"Beloved\",\n" +
            "            \"author\": \"Toni Morrison\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/6\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 6,\n" +
            "                    \"name\": \"Toni Morrison\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 9.85,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/7\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 7,\n" +
            "            \"title\": \"The Divine Comedy\",\n" +
            "            \"author\": \"Dante Alighieri\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/7\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 7,\n" +
            "                    \"name\": \"Dante Alighieri\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 15.35,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/8\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 8,\n" +
            "            \"title\": \"Faust\",\n" +
            "            \"author\": \"Johann Wolfgang von Goethe\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/8\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 8,\n" +
            "                    \"name\": \"Johann Wolfgang von Goethe\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 11.49,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/9\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 9,\n" +
            "            \"title\": \"Hunger\",\n" +
            "            \"author\": \"Knut  Hamsun\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/9\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 9,\n" +
            "                    \"name\": \"Knut  Hamsun\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 16.00,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/10\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 10,\n" +
            "            \"title\": \"Love in the Time of Cholera\",\n" +
            "            \"author\": \"Gabriel García Márquez\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/10\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 10,\n" +
            "                    \"name\": \"Gabriel García Márquez\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 9.93,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/11\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 11,\n" +
            "            \"title\": \"Madame Bovary\",\n" +
            "            \"author\": \"Gustave Flaubert\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/11\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 11,\n" +
            "                    \"name\": \"Gustave Flaubert\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 12.85,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/12\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 12,\n" +
            "            \"title\": \"The Odyssey\",\n" +
            "            \"author\": \"null Homer\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/12\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 12,\n" +
            "                    \"name\": \"null Homer\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 15.60,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/13\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 13,\n" +
            "            \"title\": \"Othello\",\n" +
            "            \"author\": \"William Shakespeare\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/13\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 13,\n" +
            "                    \"name\": \"William Shakespeare\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 9.85,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/14\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 14,\n" +
            "            \"title\": \"Things Fall Apart\",\n" +
            "            \"author\": \"Chinua Achebe\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/14\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 14,\n" +
            "                    \"name\": \"Chinua Achebe\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 10.71,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/15\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 15,\n" +
            "            \"title\": \"Ulysses\",\n" +
            "            \"author\": \"James Joyce\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/15\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 15,\n" +
            "                    \"name\": \"James Joyce\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 6.98,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/16\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 16,\n" +
            "            \"title\": \"War and Peace\",\n" +
            "            \"author\": \"Leo Tolstoy\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/5\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 5,\n" +
            "                    \"name\": \"Leo Tolstoy\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 13.59,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/17\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 17,\n" +
            "            \"title\": \"Invisible Man\",\n" +
            "            \"author\": \"Ralph Ellison\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/16\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 16,\n" +
            "                    \"name\": \"Ralph Ellison\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 12.79,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/18\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 18,\n" +
            "            \"title\": \"Jacques the Fatalist and His Master\",\n" +
            "            \"author\": \"Denis Diderot\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/17\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 17,\n" +
            "                    \"name\": \"Denis Diderot\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 13.80,\n" +
            "            \"discountRate\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/19\",\n" +
            "                    \"rel\": \"book_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"idOfBook\": 19,\n" +
            "            \"title\": \"Design Patterns: Elements of Reusable Object-Oriented Software\",\n" +
            "            \"author\": \"John Vlissides, Ralph Johnson, Erich Gamma, Richard Helm\",\n" +
            "            \"authorsOfBook\": [\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/18\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 18,\n" +
            "                    \"name\": \"Erich Gamma\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/19\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 19,\n" +
            "                    \"name\": \"Richard Helm\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/20\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 20,\n" +
            "                    \"name\": \"Ralph Johnson\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"links\": [\n" +
            "                        {\n" +
            "                            \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/21\",\n" +
            "                            \"rel\": \"author_details\",\n" +
            "                            \"method\": \"GET\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"authorId\": 21,\n" +
            "                    \"name\": \"John Vlissides\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"basePrice\": 54.57,\n" +
            "            \"discountRate\": 0\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    private static final String bookOfId1ExpectedBody = "{\n" +
            "    \"links\": [\n" +
            "        {\n" +
            "            \"href\": \"http://192.168.99.100:8080/bookshop/rest/books/1\",\n" +
            "            \"rel\": \"self\",\n" +
            "            \"method\": \"GET\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"href\": \"http://192.168.99.100:8080/bookshop/rest/books\",\n" +
            "            \"rel\": \"book_list\",\n" +
            "            \"method\": \"GET\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"idOfBook\": 1,\n" +
            "    \"title\": \"1984\",\n" +
            "    \"authors\": \"George Orwell\",\n" +
            "    \"description\": \"Written in 1948, 1984 was George Orwell’s chilling prophecy about the future. And while 1984 has come and gone, his dystopian vision of a government that will do anything to control the narrative is timelier than ever...\",\n" +
            "    \"dateOfPublishing\": \"1961-01-01\",\n" +
            "    \"basePrice\": 6.00,\n" +
            "    \"authorsOfBook\": [\n" +
            "        {\n" +
            "            \"links\": [\n" +
            "                {\n" +
            "                    \"href\": \"http://192.168.99.100:8080/bookshop/rest/authors/1\",\n" +
            "                    \"rel\": \"author_details\",\n" +
            "                    \"method\": \"GET\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"authorId\": 1,\n" +
            "            \"name\": \"George Orwell\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"discounts\": [\n" +
            "        \n" +
            "    ],\n" +
            "    \"isbn\": \"978-0451524935\"\n" +
            "}";

    @Test
    public void shouldReturnBooksWithCode200() {

        final ResponseBody bodyToValidate =
                given().
                        when().
                        get("http://192.168.99.100:8080/bookshop/rest/books")
                        .then().
                        statusCode(200).
                        extract().response().getBody();

        Assert.assertEquals(booksExpectedBody, bodyToValidate.prettyPrint());
    }

    @Test
    public void shouldReturnOneBookWithCode200() {
        final ResponseBody bodyToValidate =
                given().
                        pathParam("bookId", 1).
                        when().
                        get("http://192.168.99.100:8080/bookshop/rest/books/{bookId}").
                        then().
                        statusCode(200).
                        extract().response().getBody();

        Assert.assertEquals(bookOfId1ExpectedBody, bodyToValidate.prettyPrint());
    }
}
