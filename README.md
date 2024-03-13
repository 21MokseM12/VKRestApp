# VKRestApp
# Реализация restAPI, проксирующая запросы пользователя на сервис https://jsonplaceholder.typicode.com/ и возвращающая ответ с него пользователю
# Для регистрации в программе Postman зайти на адрес /api/registration и в теле запроса написать JSON-файл формата:
{
    "login" : "имя_пользователя"
    "password" : "пароль"
    "role" : "список_ролей"
}

# Доступные роли: ROLE_USERS, ROLE_ADMIN, ROLE_POSTS, ROLE_ALBUMS
# Краткая документация: 
# PUT-запросы:
 /api/welcome - url-адрес с приветственным сообщением  
 /api/registration - url-адрес регистрации  
# GET-запросы: 
 /api/posts/.. - url-адрес, возвращающий список постов  
 /api/users/.. - url-адрес, возвращающий список пользователей  
 /api/albums/.. - url-адрес, возвращающий список альбомов  
# Привелегии ролей: 
# ROLE_ADMIN: 
 Имеет доступ к обработчикам posts, users, albums
# ROLE_POSTS:
 Имеет доступ к обработчикам posts
# ROLE_USERS:
 Имеет доступ к обработчикам users
# ROLE_ALBUMS:
 Имеет доступ к обработчикам albums
