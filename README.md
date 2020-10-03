# RabbitMq-with-Spring-Boot
A simple project in spring boot to demonstrate rabbitmq with separate producer and consumer running at different port as separate services

## Port Configuration
Producer will run in port **8080**   
Consumer will run in port **8081**   

## Producer
Producer expose a single endpoint `POST /message/{msg}`   
Any message that is posted as path variable will be stored into the rabbitmq server's queue.

## Consumer   
Consumer will consume from the rabbitmq server's queue as soon as a new message available in the queue and store it in the in memory message array list.   

Consumer also expose a single endpoint `GET /message`   
This will actually fetch message from the in memory array list.   

_**Note:*** If the consumer alredy consumed multiple message and stored in the list then the get endpoint will return the first element from the list at a time._


