
#Objective

This program is to interact with the Walmart Open API and implements the following functionality: 

1. Search for products based upon a user-provided search string<br/>
2. Use the first item in the search response as input for a product recommendation search<br/>
3. Retrieve reviews of the first 10 product recommendations<br/>
4. Rank order the recommended products based upon the review sentiments

#Program Flow

Upon input of valid keywords, the program will call the Search API and obtain the item ID of the first element in the results. Then it will invoke a Product Recommendation API call, a list of valid products will be returned, otherwise, corresponding error messages will be shown. A Reviews API call will then be invoked for each of the 10 recommended products. Average overall rating for each product will be returned. New ranking based on average overall ratings will be generated and the program will output the sorted products, in the order of descending average overall ratings. Although product details will be stored in data models, only basic information are shown for simplicity.

#Technology

1. Jackson JSON Processor. Jackson is an open source Java library for processing JSON data format.
2. dom4j. dom4j is a flexible open source XML framework for Java.
3. Maven. The program used maven to compile, test and execute the program in command line.
4. Java Development Kit (JDK) 1.7 or newer.

#Compile

To compile and build the program, use:<br/>
<code>mvn compile</code>

#Test

To test and build the program, use:<br/>
<code>mvn test</code>

#Run

To run the program, use:<br/>
<code>mvn exec:java</code><br/>
User will be expected to input search keywords to run the program.
