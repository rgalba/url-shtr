# URL shortener

This is an url shortener app.

### Features

#### Scenario 1: shortening an URL

```gherkin
Given a long url
When I request to short
Then it should return a unique shortened code value 6 chars long
```

#### Scenario 2: reading existing URL from a shortened

```gherkin
Given an existing url
When I request using short code
Then it should return the original url
```

#### Scenario 3: trying to read unexisting URL from a shortened

```gherkin
Given an unexisting url
When I request using short code
Then it should return not found url
```

### Service requirements

- System should be able to store(cache) urls
- Service should handle 10K request per second
- 90% of all request should respond in less than 100ms for read request
- Service should be auto scalable to save money when not receiving enough load

## Rules

**How short should the result url be? 6 chars.**

The API can use those characters to:

`A-Z` (26)  
`a-z` (26)  
`0–9` (10)  
`_ -` (2)  
Total: 64 characters.  

For a given url `/abcdef`, there will be 64 options per char, giving 64⁶: more than 68 billion of unique urls.

## The algorithm (WIP)

Let's use Git hash as baseline:  
SHA-1 algoritm  
160 bits size (20 bytes) long.

In summary:  
> text > Base64 > Sha-1  

The 6 first characters will be the shortened url.

> Interesting post about git hash collision [here][1]

## Design the API (WIP)

```
POST /api/shorten/
{
    "url": "http://aslkdhalskdhalskdhalkshdalskdhalsd.com"
}
```

## Spring Cloud

Build function:

```
mvn clean package
```

## AWS Lambda

```sh
$ sls deploy
λ sls deploy
Serverless: Packaging service...
Serverless: Uploading CloudFormation file to S3...
Serverless: Uploading artifacts...
Serverless: Uploading service bb8-url-0.0.1-SNAPSHOT-aws.jar file to S3 (17.79 MB)...
Serverless: Validating template...
Serverless: Updating Stack...
Serverless: Checking Stack update progress...
.........
Serverless: Stack update finished...
Service Information
service: bb8-url
stage: dev
region: us-east-1
stack: bb8-url-dev
resources: 6
api keys:
  None
endpoints:
  None
functions:
  main: bb8-url-dev-main
layers:
  None
Serverless: Run the "serverless" command to setup monitoring, troubleshooting and testing.
```

## Serverless framework

[Doc][4]


[1]: https://diego.assencio.com/?index=eacd6eedf46c9dd596a5f12221ad15b8
[2]: https://www.baeldung.com/spring-cloud-function
[3]: https://medium.com/faun/spring-cloud-function-deploy-first-serverless-function-using-spring-1bbdc0a4620d
[4]: https://serverless.com/framework/docs/providers/aws/guide/serverless.yml/