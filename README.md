# Agentic Duke

Demo code for my AI talks using the [Jakarta Agentic AI Specification](https://jakarta.ee/specifications/agentic/).

Export an environment variable named ANTHROPIC_API_KEY with your Anthropic API Key for these examples to work.

```
export ANTHROPIC_API_KEY=<INSERT KEY HERE>
```

Compile and run the application

```
mvn clean package payara-micro:start
```

Test the endpoint (using https://httpie.io)
```
http :8080/agentic-duke/ai message=='Tell me about white peking ducks'
```
