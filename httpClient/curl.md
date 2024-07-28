```shell
PORT=8081
curl http://0.0.0.0:$PORT/hello
```
```shell
PORT=8443
curl -k https://0.0.0.0:$PORT/hello
```
```shell
PORT=8443
CLIENT_KEY_STORE_PASS=secret
curl -k https://0.0.0.0:$PORT/hello \
  --cert-type P12 \
  --cert ../certs/client-key-store.p12:$CLIENT_KEY_STORE_PASS
```
