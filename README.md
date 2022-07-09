# currency-converter

This is a simple application that converts currencies.

*Given* the current exchange rate for USD to EUR is 0.96 \
*When* the user enters 100 for the amount  \
*Then* &euro;96 is returned

![Home screen for currency converter](src/main/resources/images/home.png)
![Result screen for currency converter](src/main/resources/images/currency.png)

Tasks:

1. Run the app and see how it currently functions (Go to http://localhost:8080/home)
2. Run all the tests (right-click on the test folder and select run all tests)
3. Make the AMoneyCalculatorShould test pass
4. Make the AMoneyConverterShould test pass (if you have trouble place a breakpoint and run the test in debug)
5. Replace stub in CurrencyController with call to MoneyConverter
6. Tests should all be passing
7. Remove @Disabled in the CurrencyExchangeBoard
8. Sign up for an API key at https://apilayer.com/marketplace/fixer-api
9. Get CurrencyExchangeBoard test to pass by using a REST Client (you may need to research this... remember researching is a valuable dev skill)
10. Add a CurrencyExchangeBoard Bean to CurrencyConfig
11. Swap the bean that MoneyConverter takes to be a CurrencyExchangeBoard implementation
12. Run the app again, but this time you should get a different exchange rate
13. Make a note of any missing features, error handling, etc. 