# OCSP

https://docs.openssl.org/1.1.1/man1/ocsp/#

## Check cert validate

```shell
openssl ocsp \
    -no_nonce \
    -issuer certificateChain \
    -cert certificate \
    -url http://ocsp.example.com 
```
