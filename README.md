# CMPE-202-IndividualProject


- Primary Problem:
The primary problem is to verify and categorize credit cards based on certain criteria such as card number length and initial digits. The goal is to determine the category of each credit card.

- Secondary Problems:
After performing the validation checks in the first phase, the secondary problem is to initialize the appropriate card objects based on the validation results. Another task is to write an output file in the desired format, containing records of the card type, card number, and error message. This involves processing a given input file of credit card numbers.

- Design Pattern:
The chosen design pattern for this project is the Factory pattern. The Factory pattern is used to handle the creation of specific objects based on the input type. Here's an overview of how the pattern is applied in this context:
1) The client provides an input file containing credit card details and requests the creation of a specific type of output file.
2) The RecordIO object is created, and a suitable RecordInputOutput object is constructed using the RecordInputOutputFactory based on the input file provided by the user.
3) The RecordInputOutput subclasses (such as JsonRecordIOInputOutput, CsvRecordIOInputOutput, XmlRecordIOInputOutput) implement the logic to extract card information from different types of input data and write the desired results to the designated output files.
4) The CreditCardFactory class is responsible for generating specific types of CreditCard objects based on the inputs.
5) Various CreditCard types are constructed in the subclasses based on the inputs and validation results.
6) The OutputRecord class is used to construct each output record and write it to the appropriate output file.


- Consequences of Using the Factory Pattern:
1) The Factory Design pattern simplifies object creation by abstracting the creation logic from the client.
2) The pattern allows for the potential creation of more subclasses in the future to handle new types of objects without modifying existing code.
3) The loose coupling between the subclasses enables easy modification and addition of new subclasses as needed in the future.
4) However, the use of the Factory pattern may make the code more abstract and potentially harder to read and understand. It requires understanding the relationships between different classes and their responsibilities.

#Diagrams
Attached the diagrams in the resources folder of the repository
