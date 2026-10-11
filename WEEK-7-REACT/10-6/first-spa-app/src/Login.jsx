
import React from 'react';
class Login extends React.Component{
  render(){
    return(
      <div>
        <form>
            <h1>Please Login</h1>
            <input type="text" placeholder='Enter the username'/>
            <input type="password" placeholder='Enter your Password' />
            <button type='submit'>Login</button>
        </form>
        </div>
      

    );
  }
}
export default Login;
