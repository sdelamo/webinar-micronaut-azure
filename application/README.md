# Micronaut and Azure Function

## Prerequisites

- Gradle 5+
- Latest [Function Core Tools](https://aka.ms/azfunc-install)
- Azure CLI. This plugin use Azure CLI for authentication, please make sure you have Azure CLI installed and logged in.

## Setup

```cmd
az login
az account set -s <your subscription id>

## Running the function locally

```cmd
./gradlew clean azureFunctionsRun
```

And visit http://localhost:7071/api/demo

## Deploying the function

To deploy the function run:

```bash
$ ./gradlew clean azureFunctionsDeploy
```

## Feature azure-function documentation

- [Micronaut Azure Function documentation](https://micronaut-projects.github.io/micronaut-azure/latest/guide/index.html#simpleAzureFunctions)

## Feature azure-function-http documentation

- [Micronaut Azure Function documentation](https://micronaut-projects.github.io/micronaut-azure/latest/guide/index.html#azureHttpFunctions)

