# API com MongoDB, sistema de post e comentario.

Projeto criado para estudo e trabalho com MongoDB e API REST

<p align="left">
 
# Get Users:

all users:
http://localhost:8080/users

user by id:
http://localhost:8080/users/{id}

get user's post:
http://localhost:8080/users/{id}/posts

# Post User:
http://localhost:8080/users

# Put user:
http://localhost:8080/users{id}
Json -> 
{
 "name": "Teste",
 "email": "teste@teste.com"
} 


# Get Posts:

all posts:
http://localhost:8080/posts

post by id:
http://localhost:8080/posts/{id}

full search:
http://localhost:8080/posts/fullsearch?text=Kevin&mindate=2003-04-06&maxdate=2023-04-06
</p>

body contains:
http://localhost:8080/posts/contains/body?body=ola

comment contains:
http://localhost:8080/posts/contains/comment?comment=raupp

title contains:
http://localhost:8080/posts/contains/title?title=new

author contains:
http://localhost:8080/posts/author?author=test

# Delete Posts: 
http://localhost:8080/posts/{id}
