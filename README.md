# API com MongoDB, sistema de post e comentario.

Projeto criado para estudar o desenvolvimento de API'S com SpringBoot e MongoDB.

 
# User:

<b>GET</b>

/api/v1/users -> Finds all users

/api/v1/users/{id} -> Finds a user by passing an {id}

/api/v1/users/{id}/posts -> Finds all user's posts

<b>POST</b>

/api/v1/users -> Adds a new user by passing a RequestBody in JSON, XML or YML!

<b>PUT</b>

/api/v1/users/{id} -> Updates a user by passing an {id} and a RequestBody in JSON, XML or YML!

<b>DELETE</b>

/api/v1/users/{id} -> Deletes a user by passing an {id}

# Post:

<b>GET</b>

/api/v1/posts -> Finds all posts

/api/v1/posts/{id} -> Finds a posts by passing an {id}

/api/v1/posts/fullsearch -> Finds a post that has what you're looking for by passing an RequestParam

/api/v1/posts/contains/title -> Finds a posts by passing an RequestParam to title

/api/v1/posts/contains/comment -> Finds a posts by passing an RequestParam to comment

/api/v1/posts/contains/body -> Finds a posts by passing an RequestParam to body

/api/v1/posts/author -> Finds a posts by passing an RequestParam to author

<b>DELETE</b>

/api/v1/posts/{id} -> Deletes a post by passing an {id}
