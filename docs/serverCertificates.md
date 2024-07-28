# Server certificates

## `openssl`

```shell
ROOT_CA_PASS=secretSecretSecret
KEY_STORE_PASS=secret

# Create Certificate Authority certificate (rootCA.crt)
openssl req -x509 -sha256 -days 3650 -newkey rsa:2048 -keyout rootCA.key -out rootCA.crt -subj "/C=UK/ST=SC/L=Edinburgh/O=jCabrerizo/OU=dev/CN=cabrerizo.es" -passout pass:$ROOT_CA_PASS

# Create server key
openssl genrsa -out server.key 2048

# Create server certificate signing request (csr)
openssl req -key server.key -new -out server.csr -subj "/C=UK/ST=Scotland/L=Edinburgh/O=jCabrerizo/OU=dev/CN=cabrerizo.es"

# Create server DNS information
DNS=localhost
cat << EOF > server.dns.ext
authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
subjectAltName = @alt_names
[alt_names]
DNS.1 = $DNS
EOF

# Sign crs with rootCA
openssl x509 -req -CA rootCA.crt -CAkey rootCA.key -in server.csr -out server.crt -days 3650 -CAcreateserial -extfile server.dns.ext -passin pass:$ROOT_CA_PASS

# Convert crt to pem
openssl x509 -in server.crt -out server.pem
openssl x509 -in rootCA.crt -out rootCA.pem

# Add certificate to server key store
openssl pkcs12 -export -in server.crt -inkey server.key -out server-key-store.p12 -name "server-certificate" -passout pass:$KEY_STORE_PASS
```

## `keytool`

(TODO)
