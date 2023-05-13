# Yashasvi-CMPE-202

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
1)The Factory Design pattern simplifies object creation by abstracting the creation logic from the client.
2)The pattern allows for the potential creation of more subclasses in the future to handle new types of objects without modifying existing code.
3)The loose coupling between the subclasses enables easy modification and addition of new subclasses as needed in the future.
4)However, the use of the Factory pattern may make the code more abstract and potentially harder to read and understand. It requires understanding the relationships between different classes and their responsibilities.




Diagrams : Attached in the class_diagrams folder of the repository


### CSV

```
✗ java -cp yashasvi-cmpe-202.jar com.yashasvi.Main src/main/resources/input.csv output/output.csv
Output successfully written to output.csv
```

```
✗ cat output.csv
CardNumber,CardType
5567894523129089,MasterCard
59012345678901234567890,"Invalid: more than 19 digits"
4123456789123,Visa
347856341908126,AmericanExpress
6011111100007756,Discover
3601112345678789,"Invalid: not a possible card number"
5167894523129089,MasterCard
4123456789123999,Visa
377856341908126,AmericanExpress
5367894523129089,MasterCard
"6011*890HJrt6789","Invalid: non numeric characters"
,"Invalid: empty/null card number"

```

### JSON

```
✗ java -cp yashasvi-cmpe-202.jar com.yashasvi.Main src/main/resources/input.json output/output.json
Output successfully written to output.json
```

```
✗ cat output.json
{
  "cards": [
    {
      "cardType": "MasterCard",
      "cardNumber": "5567894523129089"
    },
    {
      "cardType": "Invalid: more than 19 digits",
      "cardNumber": "59012345678901234567890"
    },
    {
      "cardType": "Visa",
      "cardNumber": "4123456789123"
    },
    {
      "cardType": "AmericanExpress",
      "cardNumber": "347856341908126"
    },
    {
      "cardType": "Discover",
      "cardNumber": "6011111100007756"
    },
    {
      "cardType": "Invalid: not a possible card number",
      "cardNumber": "3601112345678789"
    },
    {
      "cardType": "MasterCard",
      "cardNumber": "5167894523129089"
    },
    {
      "cardType": "Visa",
      "cardNumber": "4123456789123999"
    },
    {
      "cardType": "AmericanExpress",
      "cardNumber": "377856341908126"
    },
    {
      "cardType": "MasterCard",
      "cardNumber": "5367894523129089"
    },
    {
      "cardType": "Invalid: non numeric characters",
      "cardNumber": "6011*890HJrt6789"
    },
    {
      "cardType": "Invalid: empty/null card number",
      "cardNumber": ""
    }
  ]
}
```

### XML

```
✗ java -cp yashasvi-cmpe-202.jar com.yashasvi.Main src/main/resources/input.xml output/output.xml
Output successfully written to output.xml
```

```
<ArrayList>
  <item>
    <CardNumber>5567894523129089</CardNumber>
    <CardType>MasterCard</CardType>
  </item>
  <item>
    <CardNumber>59012345678901234567890</CardNumber>
    <CardType>Invalid: more than 19 digits</CardType>
  </item>
  <item>
    <CardNumber>4123456789123</CardNumber>
    <CardType>Visa</CardType>
  </item>
  <item>
    <CardNumber>347856341908126</CardNumber>
    <CardType>AmericanExpress</CardType>
  </item>
  <item>
    <CardNumber>6011111100007756</CardNumber>
    <CardType>Discover</CardType>
  </item>
  <item>
    <CardNumber>3601112345678789</CardNumber>
    <CardType>Invalid: not a possible card number</CardType>
  </item>
  <item>
    <CardNumber>5167894523129089</CardNumber>
    <CardType>MasterCard</CardType>
  </item>
  <item>
    <CardNumber>4123456789123999</CardNumber>
    <CardType>Visa</CardType>
  </item>
  <item>
    <CardNumber>377856341908126</CardNumber>
    <CardType>AmericanExpress</CardType>
  </item>
  <item>
    <CardNumber>5367894523129089</CardNumber>
    <CardType>MasterCard</CardType>
  </item>
  <item>
    <CardNumber>6011*890HJrt6789</CardNumber>
    <CardType>Invalid: non numeric characters</CardType>
  </item>
  <item>
    <CardNumber></CardNumber>
    <CardType>Invalid: empty/null card number</CardType>
  </item>
</ArrayList>
```

## Validations

### Validation that required number of arguments are passed

```
✗ java -cp yashasvi-cmpe-202.jar com.yashasvi.Main
Invalid syntax. Usage: java com.yashasvi.Main <input file path> <output file path>
```

### Validation that input and output file extensions are same

```
✗ java -cp yashasvi-cmpe-202.jar com.yashasvi.Main src/main/resources/input.csv output/output.xml
Exception in thread "main" java.lang.RuntimeException: Input and output extensions should be the same
```

### Validation that input file path exists

```
✗ java -cp yashasvi-cmpe-202.jar com.yashasvi.Main input.csv output/output.csv
Exception in thread "main" java.lang.RuntimeException: Input path does not exist
```
