# Finnair_Assignment
 
Endpoint:
GET /passengers?flightNumber=<flight-number>&departureDate=<departure-date>
Response body:
[
{
”passengerId”: ”string”,
“firstName”: “string”,
”lastName”: ”string”,
“bookingId”: “string, 6 chars”
},
…
]
Endpoint:
GET /passengers/<passenger-id>
Response body:
{
”passengerId”: ”string”,
”firstName”: “string”,
“lastName”: “string”,
“email”: “string”,
“bookingId”: “string, 6 chars”,
“flights”: [
{
“flightNumber”: “string, carrier code + flight number”
“departureAirport”: “string, 3 chars”,
“arrivalAirport”: “string, 3 chars”,
“departureDate”: “string, yyyy-mm-dd”,
“arrivalDate”: “string, yyyy-mm-dd”
},
…
]
}
Notes:
• A booking can have multiple passengers, and a passenger can be in one booking.
• A booking can have multiple flights, and a flight can have multiple bookings.
