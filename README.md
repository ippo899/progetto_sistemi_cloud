# progetto_sistemi_cloud
Progetto sistemi cloud che simula dei sensori di temperatura.
Il codice è composto da due applicativi Springboot (Client e Server) e da un DB MYSQL sul quale vengono scritti i dati inviati dal Client a Server.
Il Client simula un sensore di Temperatura composto da parametri come stanza, temperatura e timestamp e gira sulla porta 8080.
Il Server riceve queste informazioni sulla porta 8081 e le scrive sul DB MYSQL sulla porta 3306.
Viene utilizzato Docker per contenizzare i due applicativi e  MYSQL.
Successivamente si fa ricorso a Kubernates per simulare l'avvio di tante istanze del client che scrivono contemporanemte sul DB.

