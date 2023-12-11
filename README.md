# Mohana Satyanarayana Moganti
# Student ID : 017163497

Describe what is the primary problem you try to solve.

We must categorize the credit card into a specific category and confirm it based on the specifications given, such as the first digits and the total number of digits for different types of credit cards.

2. Describe what are the secondary problems you try to solve (if there are any).
Proper initialization of credit card objects following validation checks.
Generation of output files in the required format, containing credit card types, numbers, and error messages for input files with various credit card numbers.
Handling of error scenarios, such as non-numeric characters in the credit card numbers provided in the input file.

3. Describe what design pattern(s) you use how (use plain text and diagrams).
The CreditCardFactory class in your code is an example of the Factory Pattern. This pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one class instance. It promotes loose coupling by eliminating the need to bind application-specific classes into the code. In this case, the factory class (CreditCardFactory) decides which type of credit card object needs to be created based on the input.

"CreditCardFactory" provides a static method getCreditCardType which, based on the card number, determines the type of the credit card (Visa, MasterCard, etc.).

The FileProcessor class uses the Strategy Pattern. This pattern is used to create a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it. Here, FileProcessor uses different parsing and writing strategies (FileFormatParser and FileFormatWriter interfaces) that can be changed at runtime based on the file format.

Usage in Your Code:

FileProcessor can utilize different parser (CSVParser, XMLParser, JSONParser) and writer (CSVWriter, XMLWriter, JSONWriter) strategies based on the file extension.


Credit Card Object Instantiation Class Diagram:
(Credit_Card_Object_Instantiation_Class_Diagram.png)
![image](https://github.com/g<img width="821" alt="Screenshot 2023-12-10 at 1 04 09 PM" src="https://github.com/gopinathsjsu/individual_project_Anudeep_Goud/assets/48233893/a5a57f39-6626-4f2b-91d7-f2186570bd80">
opinathsjsu/individual_project_Anudeep_Goud/assets/48233893/df04c928-8855-4f15-8c10-95773e2c9bd0)

Application Diagram:
![image](https://github.com/gopinathsjsu/individual_project_Anudeep_Goud/assets/48233893/ebeca40e-1d82-4c86-8331-1c1b0dd2cf5d)


