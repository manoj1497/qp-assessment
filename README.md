**Admin API Endpoints**

1.View All Grocery Items
Request : GET
http://localhost:8080/admin/groceries

Response:
 {
        "id": 1,
        "name": "Apple",
        "price": 100.0,
        "inventory": 500
 }
 
 
2.Add a New Grocery Item
Request :POST
http://localhost:8080/admin/groceries 

json:
{
        "name": "Apple",
        "price": 100.0,
        "inventory": 500
}


Response:
json:
{
        "id": 1,
        "name": "Apple",
        "price": 100.0,
        "inventory": 500
}

3. Update Grocery Item
Request : PUT
http://localhost:8080/admin/groceries/{id}

json:
{
  "name": "Apples",
  "price": 100,
  "inventory": 450
}

Response:
json:
{
    "id": 1,
    "name": "Apples",
    "price": 100.0,
    "inventory": 450
}


4. Remove Grocery Item
Request: DELETE 
http://localhost:8080/admin/groceries/{id}

Response:
Record deleted successfully


**User API Endpoints**

1. View Available Grocery Items
Request: GET
http://localhost:8080/user/groceries

Response:
json:
{
        "id": 2,
        "name": "Watermelon",
        "price": 60.0,
        "inventory": 400
}


2. Book Grocery Items
Request: POST
http://localhost:8080/user/place

json:
[
    {
        "userId": 324,
        "orderItems": [
            { "id": 1, "quantity": 5 },
            { "id": 2, "quantity": 3 }
        ]
    }
]


Response:
{
    "items": [
        {
            "id": 1,
            "orderID": "ORD-1735227591516",
            "userId": 324,
            "item_id": 1,
            "name": "Apple",
            "price": 100.0,
            "quantity": 5,
            "totalPrice": 500.0,
            "date": "2024-12-26T21:09:51.5566902"
        },
        {
            "id": 2,
            "orderID": "ORD-1735227591516",
            "userId": 324,
            "item_id": 2,
            "name": "Tomato",
            "price": 50.0,
            "quantity": 3,
            "totalPrice": 150.0,
            "date": "2024-12-26T21:09:51.5676995"
        }
    ],
    "totalAmount": 650.0,
    "userId": 324,
    "orderId": "ORD-1735227591516"
}



