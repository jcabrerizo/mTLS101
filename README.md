# mTLS 101

A mTLS proof of concept and examples

## TODO

* [x] API endpoint to test
* [x] 🐳 Containerize app → [Dockerfile](./Dockerfile)
* [x] Swagger UI for API → http://localhost:8080/swagger-ui/index.html
* [x] Add Spring boot profiles for configure multiple TLS scenarios
* [ ] 🔐 Configure one way TLS
  * [ ] 🔓 Second http connector to expose an http port
* [ ] Configure two way TLS → mTLS
    * [ ] Trusting clients by their certificate
    * [ ] Trusting clients by their certificate sign by a trusted CA
* [ ] 📝 Document certification creation
* [ ] API for creating certificates or signing certificate signing request (csr) for new clients
  * [ ] Swagger UI for ☝️ API
* [ ] Segregate API for require mTLS only for a subset of endpoints
* [ ] Create [MkDocs](https://squidfunk.github.io/mkdocs-material/) site
    * [ ] Automate site update with a pipeline
