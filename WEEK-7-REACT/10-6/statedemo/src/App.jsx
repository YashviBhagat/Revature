
import React from "react";
import Details from "./details";
import Product from "./products";

export default class App extends React.Component{


  constructor(props){
    super(props);
    this.state={
        firstName:"peter",
        lastName:"parker",
        age:25,
        isMarried:false,
        address:{
          street:"20 Main Street",
          city:"Dallas",
          state:"TX"
        },
        productList:[
          {pId:101,pName:"iphone18",price:1800,isInStock:true},
          {pId:102,pName:"Samsung Galaxy S23",price:1000,isInStock:true},
          {pId:103,pName:"Google Pixel 7",price:800,isInStock:false},
          {pId:104,pName:"OnePlus 11",price:700,isInStock:true},
          {pId:105,pName:"Xiaomi 13",price:500,isInStock:false},
        ],
        counter:0,
        greetUser: function(guestName){
          alert(`Hello ${guestName}, Welcome to our Website!`);
        }
    } 
  }

  AddCounter = () => {
    this.setState({counter:this.state.counter + 1});
  }

  DecreaseCounter = () => {
     this.setState({counter:this.state.counter - 1});

  }

  render(){
    //const { firstName, lastName, age, isMarried, address } = this.state;
    return(
      <div>
        <h1>State Demo</h1>

        <h2>Counter: {this.state.counter}</h2>
        <button onClick={this.AddCounter}>Add</button>
        <button onClick={this.DecreaseCounter}>Subtract</button>

        <hr/>

        <h2>Counter : {this.states.counter} greetings:{this.state.greetUser}</h2>

        {/* <h2>Name:{this.state.firstName} {this.state.lastName}</h2>
        <p>age:{this.state.age}</p>
        <p>Status: {this.state.isMarried ? "Married":"Single"}</p>
        <h3>Address:</h3>
        <p>{this.state.address.street} {this.state.address.city} {this.state.address.state}</p> */}

        {/* <Details fName={this.state.firstName} 
        lName={this.state.lastName}
        city = {this.state.address.city}/> */}

        {/* <Product pList={this.state.productList} /> */}

        
          

        
      </div>
    );
  }
  
  
  
}


