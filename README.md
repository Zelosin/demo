Образ hbase
https://hub.docker.com/r/harisekhon/hbase

Поднятие контейнера
docker pull harisekhon/hbase
docker run -d -p=2181:2181 -p=8080:8080 -p=8085:8085 -p=9090:9090 -p=9095:9095 -p=16000:16000 -p=16010:16010 -p=16020:16020 -p=16201:16201 -p=16301:16301 harisekhon/hbase

Проверить, что мастер-нода поднялась
http://localhost:16010/master-status

Прописать в hosts имя контейнера
127.0.0.1 c3387c208246
