# Task
Your task is to implement a flexible caching system for the web application. The caching system should support different eviction mechanisms, such as Least Recently Used (LRU), Least Frequently Used (LFU), and Time-Based eviction. Additionally, it should allow users to switch between these eviction strategies dynamically without requiring code changes.

# Requirements:
* Implement a cache interface that defines common cache operations like get, put, and remove.
* Create classes for different eviction strategies, such as LRUEvictionStrategy, LFUEvictionStrategy, and TimeBasedEvictionStrategy. Each class should implement the eviction logic based on its strategy.
* Design a Cache class that takes an eviction strategy as a parameter during initialization and uses it to manage the cache.
* Allow users to change the eviction strategy at runtime without modifying the existing code.


# Issue
While implementing this problem, I started observing that implementation of different cache is different even the data required by each is different .i.e.
* for LRU, whenever we call get or put it will be considered as recently used.
* for LFU, whenever we call get or put we need to increment the frequency.
* for Time Based Cache, whenever we get or put we need to update the timestamp.

Now doubt is, as each strategy requires different kind of data so 
* either we can keep the complete implementation of cache in different caching strategies -> then why we need Strategy Pattern and if user changes the cache type the data will be flushed out
* Or we can keep implementation in Cache class except the Eviction policy -> then it violates the Single Responsibility Principle

Which thought is correct? 
I'm personally confused.