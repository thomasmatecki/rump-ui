#!/usr/bin/env bash

DATOMIC_DIR="~/datomic/datomic-pro-0.9.5656"

echo "datomic directory is $DATOMIC_DIR"

cd ~/datomic/datomic-pro-0.9.5656

bin/transactor ../dev-transactor.properties &

bin/run -m datomic.peer-server \
         -h localhost -p 8998 \
         -a myaccesskey,mysecret \
         -d hello,datomic:dev://localhost:4334/hello &

bin/console -p 8080 dev datomic:dev://localhost:4334/
