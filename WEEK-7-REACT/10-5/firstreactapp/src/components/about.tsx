


function About(){
    const orgName = "Cognizate";
    const orgAddress = "123 Main street, Plano,Texas,Us";
    const productList = ["pepsi","coke","lays","Sprite"];
    return(
        <>
        <h1>About Page</h1>
        <p> this is the about page of my first react app.</p>
        <p>Organization:{orgName}</p>
        <p>Adress: {orgAddress}</p>
        <p> Product List: </p>
            <select>
                {productList.map((product,index) =>
                    <option key={index} value = {product}>
                        {product}

                    </option>
                )}
            </select>

       
        </>
    )
}

export default About;