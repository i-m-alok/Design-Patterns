# Template Method Pattern

Mainly this pattern is used when we have repetition of code for same code over multiple classes which can be inherited from a class.

Common structure of this pattern something look like this 


- Super Class 
  - execute (common work)
  - doExecute (abstract method)
- Child Classes of Super Class
  - implement doExecute (this method will contain working as per requirement)

