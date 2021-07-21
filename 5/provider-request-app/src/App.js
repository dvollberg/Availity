import React from 'react';
import './App.css';

function App() {

  const [firstName, setFirstName] = React.useState("");
  const [lastName, setLastName] = React.useState("");
  const [npiNumber, setNpiNumber] = React.useState("");
  const [businessAddress, setBusinessAddress] = React.useState("");
  const [telephoneNumber, setTelephoneNumber] = React.useState("");
  const [emailAddress, setEmailAddress] = React.useState("");

  const handleSubmit = (event) => {
    alert(`Submitting
      First Name: ${firstName}
      Last Name: ${lastName}
      NPI Number: ${npiNumber}
      Business Address: ${businessAddress}
      Telephone Number: ${telephoneNumber}
      Email Address: ${emailAddress}
    `);

    event.preventDefault();
  }

  return (
    <div className="App">
        <form onSubmit={handleSubmit}>
        <h1 class='centered'>Provider Registration</h1>
        <p>
          <label class='centered'>
            First Name:
            <input
              name="firstName"
              value={firstName}
              onChange={e => setFirstName(e.target.value)}
              required />
          </label>
        </p>
        <p>
        <label>
          Last Name: 
          <input
            name="lastName"
            value={lastName}
            onChange={e => setLastName(e.target.value)}
            required />
        </label>
        </p>
        <p>
        <label>
          NPI Number:
          <input
            name="npiNumber"
            value={npiNumber}
            onChange={e => setNpiNumber(e.target.value)}
            required />
        </label>
        </p>
        <p>
        <label>
          Business Address:
          <input
            name="businessAddress"
            value={businessAddress}
            onChange={e => setBusinessAddress(e.target.value)}
            required />
        </label>
        </p>
        <p>
        <label>
          Telephone Number: 
          <input
            name="telephoneNumber"
            value={telephoneNumber}
            onChange={e => setTelephoneNumber(e.target.value)}
            required />
        </label>
        </p>
        <p>
        <label>
          Email Address:
          <input
            name="emailAddress"
            type="email"
            value={emailAddress}
            onChange={e => setEmailAddress(e.target.value)}
            required />
        </label>
        </p>
        <button>Submit</button>
      </form>
    </div>
  );
}

export default App;
