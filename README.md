## ion-ingest-api is now ARCHIVED

# Ingest API
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=connexta/ion-ingest-api)](https://dependabot.com)
[![Known Vulnerabilities](https://snyk.io/test/github/connexta/ion-ingest-api/badge.svg)](https://snyk.io/test/github/connexta/ion-ingest-api)
[![CircleCI](https://circleci.com/gh/connexta/ion-ingest-api/tree/master.svg?style=svg)](https://circleci.com/gh/connexta/ion-ingest-api/tree/master)

## Prerequisites
* Java 11

## Building
```bash
mvn clean install
```

## License Validation
The license headers are checked when you perform `mvn clean install`,
but if you want to do a standalone check:
```bash
mvn license:check
```
and to apply the header in `license-header.txt`:
```bash
mvn license:format
```
