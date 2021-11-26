# REST Microservices architecture for E-commerce



Project architecture
 

Tools and Technologies

- Java 8
- Spring Boot
- Spring Web MVC 
- SQL Database engine
- Maven

Features

1. Administrator:

   - Users management
   - Products management
   - Orders management
   - Recommendations management

2. User:

   - Registration
   - Shopping cart (for guest or logged user)
   - Order
   - Product recommendation 
   - Product catalog


an online store is a site with a set of utilities and an individual interface. You need to know how to present your goods and services in a favorable light with the help of high-tech modern means. Online stores are just such means.
At the very start of a business on the Internet, one of the most important tasks is to create a website, because in fact it is a point of sale.
the creation of such an online store will depend on the chosen tariff, which may include a different number of products, store pages, connection of various additional services.
After paying for the goods, if online payment was selected, or the receipt of the order, if payment on receipt was selected, the manager who works remotely and processes applications sees the order in the system, clarifies it, and transfers it to assembly and dispatch.

The work is carried out approximately in the following way:

On your website, the buyer leaves a request for the purchase of goods.

You process the application and hand it over to the supplier, who, in turn, sends the parcel to the desired address.

Pay with the supplier

This scheme contains both previous schemes with their pros and cons. Some of the goods in demand are in stock, less popular goods are ordered on demand.

There are three possible scenarios for the development of events, depending on the goods that were placed in the shopping cart by the buyer.

1. The buyer has placed an order in which only a popular product. In this case, the process of processing and delivery of the order is reduced to packing the order and sending it. You get money quickly. In the picture above, this is path # 1.

2. The buyer has placed an order in which only unpopular goods. In this case, the order is first sent to the supplier, and from there, depending on the conditions of work with the supplier, it is sent to the online store or directly to the buyer. In the picture above, this is path # 2.

3. The buyer has placed an order with the goods that are in stock and which must be ordered from the supplier. Next, the buyer either waits until the online store receives the missing goods from the supplier, or the goods are first sent to him from the warehouse, and then the additional ordered goods are sent. In the picture above, these are paths # 1 and # 2.





Microservices USES
