# mTLS 101

A mTLS proof of concept and examples

## TODO

* [x] API endpoint to test
* [x] 🐳 Containerize app → [Dockerfile](./Dockerfile)
* [x] Swagger UI for API → http://localhost:8081/swagger-ui/index.html
* [x] Add Spring boot profiles for configure multiple TLS scenarios
* [x] 🔐 Configure one way TLS
  * [x] 🔓 Second http connector to expose a http port
* [x] Configure two way TLS → mTLS
    * [x] Trusting clients by their certificate
    * [ ] Trusting clients by their certificate signed by a trusted CA
* [ ] 📝 Document certification creation
* [ ] Update 🐳 container configuration for multiple scenarios 🔐/ 🔓
* [ ] API for creating certificates or signing certificate signing request (csr) for new clients
  * [ ] Swagger UI for ☝️ API
* [ ] Segregate API for require mTLS only for a subset of endpoints
* [ ] Create [MkDocs](https://squidfunk.github.io/mkdocs-material/) site
    * [ ] Automate site update with a pipeline
