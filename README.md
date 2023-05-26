****В данном проекте представлено р
ешение следующего тестового задания:****

Книгохранилище

Сущности 
Книги:
•	название;
•	год;
•	количество страниц;
Авторы:
•	имя;
•	фамилия;
•	дата рождения;
Жанры:
•	название;


У книг может быть несколько авторов и несколько жанров. Одному автору может принадлежать несколько книг. Не забудь продумать ограничения, которые накладываются на сущности.

Реализовать возможность добавления, удаления, редактирования (частичное и полное) и поиск книг, авторов, жанров через REST API, в том числе отсортированный способ по разным критериям.
Изначально написать Swagger (OpenAPI) ямл файлик для интерфейса. (советую пользоваться https://editor.swagger.io/)
Использовать openapi generator maven plugin (для генерации модели и интерфейсов по API)

Код приложения должен находиться в GitLab.
Написать Dockerfile
Написать CI/CD pipeline (При коммите запускается автоматическая сборка и загрузка image в MTR, после чего идет деплой на dev оружение КааС). Описать весь пайп лайн в  .gitlab-ci.yml.
Приложение должны быть протестировано (Unit, component tests. Покрытие проверяется через Sonar).
Приложение совместно с БД должно быть установлено на CaaS (kubernetes).
Операции логируются в консоль и файл. Логирование на аспектах.
Authorization (выбрать способ и аргументировать)

Технологии:
•	REST API - swagger openapi 3.0:
•	База данных PostreSQL (в отдельном поде)
•	FlyWay (реализовать миграции)
•	SpringBoot 2.x
•	Spring Data
•	Lombok
•	openapi generator maven plugin (для генерации модели и интерфейсов по API)
•	junit 5
•	TestRestTemplate
•	Logging Aspects (реализовать разные способы, например через вызов метода или с помощью аннотаций)
•	K8s
•	docker
P.S. не забудь про GlobalExceptionHandler и про java документацию.
