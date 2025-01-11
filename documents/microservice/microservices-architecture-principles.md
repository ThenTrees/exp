# Microservices Architecture Principles

### 1. **A microservice has a single concern**
- Should do one thing and one thing only = Single Object responsibility.
> Easier to understand, test, and maintain.
### 2. **A microservice is a discrete**
- Must clear boundaries between services.
- Must be well-encapsulated.
### 3. **A microservice is transportable**
- Can be moved from one runtime environment to another without take to much time.
- Easier to use in a automated deployment process.
### 4. **A microservice is carries its own data**
- Should have its own data storage that is isolated from all other microservices.
- Share with other microservices through public interface.
- The common problem is data redundancy.
### 5. **A microservice is ephemeral**
- It can be created, destroyed, and recreated at any time.
- The standard operating expectation is that microservice come and go all time, sometimes due to system failure and sometimes due scaling demands.  
