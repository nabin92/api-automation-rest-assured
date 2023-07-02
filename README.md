# api-automation-rest-assured

This is a Rest Assured based API Test Automation Framework. 
Here we are automating couple of APIs provided by Azure Devops. 
Details of GET Project: https://learn.microsoft.com/en-us/rest/api/azure/devops/core/projects/list?view=azure-devops-rest-7.0&tabs=HTTP
Details of CREATE Project: https://learn.microsoft.com/en-us/rest/api/azure/devops/core/projects/list?view=azure-devops-rest-7.0&tabs=HTTP

This repo contains 
- Hamcrest Matchers for assertions.
- TestNG for running the tests
- Jackson databind for deserialization and serialization of request and response
- Lombok has been used to generate Builders and Getters automatically for the request and response
- faker to generate random data related to project created 

Please perform the below steps to create an organization and generate a Personal Access Token (PAT).
- login to Azure Devops https://azure.microsoft.com/en-in/products/devops
- create an organization https://learn.microsoft.com/en-us/azure/devops/organizations/accounts/create-organization?view=azure-devops
- Generate a PAT (Personal Access Token) https://learn.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate?toc=%2Fazure%2Fdevops%2Forganizations%2Fsecurity%2Ftoc.json&view=azure-devops&tabs=Windows

 Add the above values in config.properties file 
- pat=
- organization=
