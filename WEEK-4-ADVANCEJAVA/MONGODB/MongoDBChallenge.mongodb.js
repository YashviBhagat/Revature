

// create schema for database and collections

const gadgetDB = db.getSiblingDB('gadgetStore');
gadgetDB.products.drop();
gadgetDB.createCollection('products', {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["name", "price", "inStock"],
		 additionalProperties:true, // in tandem with validationAction, this will disallow dynamic fields other than what we specify here, i.e. locking our schema
         properties: {
            name: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            price: {
               bsonType: ["double", "int"],
               
               description: "must be a integer number or double"
            },
            inStock: {
               bsonType: "bool",
               
               description: "must be a boolean(true or false)"
            }
         }
      }
   },
   validationAction: "error" // Rejects invalid documents. Use "warn" just to log warnings.
});

// Insert collection values
gadgetDB.products.insertMany([
    {"name":"Wireless Mouse","price":45.99,"inStock":true,specs:{brand:"Logitech"}},
    {"name":"Mechanical Keyboard","price":80.00,"inStock":false,specs:{brand:"Keychron"}},
    {"name":"Gaming Monitor ","price":69.99,"inStock":true,specs:{brand:"Dell"}}
    

]);
//Add Bed test case
//gadgetDB.products.insertOne({"name":"Wireless keyboard","price":"20","inStock":false,specs:{brand:"Dell"}});

// UPdate Query 
gadgetDB.products.updateOne(
    {name:"Wireless Mouse"},
    {$set:{category:"Accessories"},$inc: { price: 15 }}
);

//insert Array
gadgetDB.products.updateOne(
    {name:"Mechanical Keyboard"},
    {$push:{tags:"wireless"}}
);
// insert array for bestseller
gadgetDB.products.updateOne(
    {name:"Mechanical Keyboard"},
    {$push:{tags:"Bestseller"}}
);
//Decide you don't want "wireless" after all, and use $pull to remove it from the tags array.
gadgetDB.products.updateOne(
    {name:"Mechanical Keyboard"},
    {$pull:{tags:"wireless"}}
);

//gadgetDB.products.find({price: {$gte : 70 }});

//Find all products made by a specific brand 
// using dot notation (e.g., "specs.brand").
//gadgetDB.products.find({"specs.brand": "Dell"});

//gadgetDB.products.find({
//    category: {$in: ["Accessories", "Electronics"]}
//})

gadgetDB.products.find(); 

// Create second collection
gadgetDB.createCollection('orders',{
    validator:{
        $jsonSchema:{
            bsonType:"object",
            required:["quantity"],
            additionalProperties:true,
            properties:{
                quantity:{
                    bsonType:"int",
                    description:"must be an Integer number"
                }
            }
        }
    },
    validationAction: "error"
});

// find product 
const product = gadgetDB.products.findOne({name:"Mechanical Keyboard"});

gadgetDB.orders.insertOne({
    productId:product._id,
    quantity: 2
});

gadgetDB.orders.aggregate([
    {
        $lookup: {
          from: "products",
          localField: "productId",
          foreignField: "_id",
          as: "ProductDetails"
        }
    },
    {
        $unwind: "$ProductDetails"
    },
    {
        $project: {
          _id: 0,
          productName: "$ProductDetails.name",
          quantity: 1
        }
    }
]);











