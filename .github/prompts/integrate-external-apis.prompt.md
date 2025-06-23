---
tools: [codebase]
---

# External API Integration Analysis & Improvement

Use the codebase tool to analyze the external API integration code and provide comprehensive recommendations for production-ready implementation.

## Analysis Requirements:
1. **Error Handling**: Identify missing error handling, retry logic, and circuit breaker patterns
2. **Concurrency**: Review thread safety, async operations, and resource management
3. **Performance**: Assess caching strategies, connection pooling, and rate limiting
4. **Security**: Evaluate authentication, token management, and data validation
5. **Testing**: Suggest mocking strategies and integration test patterns
6. **Observability**: Recommend logging, monitoring, and debugging approaches

## Focus Areas:
- Thread safety in caching mechanisms
- Proper async error handling with CompletableFuture
- Retry logic with exponential backoff
- Rate limiting and API quota management
- JSON parsing and data validation
- Integration testing strategies
- Monitoring and alerting for external dependencies

## Deliverables:
1. **Issue Identification**: List specific problems with severity levels
2. **Code Improvements**: Provide concrete code examples for fixes
3. **Best Practices**: Suggest industry-standard patterns for API integration
4. **Testing Strategy**: Show how to test external dependencies effectively
5. **Production Considerations**: Include monitoring, configuration, and deployment aspects

Focus on practical, implementable solutions that follow our coding standards and design principles.