# funbook
Spring Rest based Solution for Library  CRUD operation
Functionality covred :



#Web based -

Listing and Searching Books
Adding a book 
Deletion a book 



Rest API :

GET : http://host:port/api/books/

Responce : Json string of all the books

POST:   http://host:port/api/books/
Body Json string of book attribute 

Example 
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/api/books/ --data '{
"title":"JK ROLLING ",
"author":"JK Rolling",
"price":433.2
}'




TODO:
1. Form Validation 
2. Cargo Build  Plugin addition 
