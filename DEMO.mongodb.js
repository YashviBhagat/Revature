//1. Create/select and manage a database.
//show is shell command
//show dbs;

use('school');
db.dropDatabase();
db.getName();

//2. Create collections explicitly.

//This line switches to (or creates) a different database called school 
// and stores a reference to it in a variable
const schoolDB = db.getSiblingDB('school');

//Create Collections(tables) in school database
schoolDB.createCollection('students');
schoolDB.students.drop();
schoolDB.createCollection('courses');
schoolDB.createCollection('enrollments');

schoolDB.dropDatabase();

//create schema with validation
const schoolDB = db.getSiblingDB('school');
schoolDB.dropDatabase();
schoolDB.createCollection('students',{
    //validator defines rules every document must follow
    validator:{ 
        $jsonSchema:{
            //each document must be an object (a {...} structure). BSON is MongoDB's data format (like JSON).
            bsonType: "object",
            required: ["name","email","age"],
            additionalProperties:false, //this locks the schema — documents can only have the fields defined here
            properties:{
                name:{
                    bsonType:"string",
                    description:"must be a string and is required"
                },
                email:{
                    bsonType:"string",
                    pattern:"^.+@.+$",
                    description:"must be a valid email string and is required"

                },
                age:{
                    bsonType:"int",
                    minimum:5,
                    maximum:100,
                    description:"must be an integer between 5 and 100 and is required"
                }
            }
        }
        
    },
    validationAction:"error"
});

//if we already created a collection,we can add JSON validation
//after the fact by modifying the collection:

const schoolDB = db.getSiblingDB('school');

// display the database
const schoolDB = db.getSiblingDB('school');