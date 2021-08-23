# JSON to PDF converter
This is a REST API which takes JSON from request body and converts to desired PDF format. This application is deployed in Heroku cloud.

# Framework
Spring Boot

# Libraries 
* Lombok
* iText PDF

# Use Cases

Restaurant bill pdf

End point : https://json2pdf-converter.herokuapp.com/api/v1/bill/pdf
Request Method : POST

Request Body
```json
{
	"orders":[
		{
			"itemName":"Kesar Pista",
			"quantity": 1,
			"rate": 60,
			"amount": 60
		},
		{
			"itemName":"Pav Bhaji",
			"quantity": 1,
			"rate": 80,
			"amount": 80
		}
	],
	"totalAmount":140,
	"gstText": "GST (18%)",
	"centralGstText": "CGST (9%)",
	"stateGstText": "SGST (9%)",
	"gstAmount": 25.20,
	"centralGstAmount": 12.60,
	"stateGstAmount": 12.60,
	"grandTotal": 165.00,
	"roundOffText":"Round Off",
	"roundOffAmount":0.20,
	"includeTaxDetail":true
}
```
# Upcoming usecases
- Resume generator
- Multi page pdf generation
