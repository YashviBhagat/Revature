import React from 'react'


class Home extends React.Component{
    //every component must have render method which returns jsx
    render(){
        //render method always need yo have return statment which return 
        const firstName ="Yashvi"; // this will come from REST api in future
        const lastName = "Bhagat"// this will come from REST api in future
        const skills = ["HTML","CSS","Java","JavaScript"] 
        return(
            <div>
                <h1>This is my home component </h1>
                <p> Welcome to my Homepage, this is the very first component I have </p>


                <p> some jsx expression </p>
                <p> Addition of my fav numbers:{5+10}</p>
                <p> Is 5 greater than 10? {5>10?"Yes":"No"}</p>
                <p>My full name is : {firstName} {lastName}</p>

                <ul>
                    {skills.map((skill, index) => (
                        <li key={index}>{skill}</li>
                    ))}
                </ul>

                </div>


        )
    }
}

export default Home