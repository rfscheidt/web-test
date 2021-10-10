# PoC RabbitMQ - Microservices Golang e Java

### Initial configuration
docker-compose up -d

start WebTestApplication inside java project

start go run .\cmd\server\main.go

#You can call on browser
http://localhost:8081/empresas/q1

Just one queue

http://localhost:8081/empresas/q2

Just another queue

Or

http://localhost:8081/empresas/q3

to call bolth

Use it togheter with: https://github.com/rfscheidt/project4-crud-go